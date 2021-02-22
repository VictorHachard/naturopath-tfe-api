package be.heh.app.controller.services.security;

import be.heh.app.controller.services.commons.AbstractSecurityService;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.controller.validators.security.*;
import be.heh.app.dto.security.UserSecurityViewDto;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.security.CookieRememberMe;
import be.heh.app.model.entities.security.Role;
import be.heh.app.model.entities.security.UserSecurity;
import be.heh.app.model.entities.security.enumeration.EnumRole;
import be.heh.app.model.facades.security.CookieRememberMeFacade;
import be.heh.app.springjwt.JwtUtils;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class UserSecurityService extends AbstractSecurityService<UserSecurity> implements UserDetailsService {

    public UserSecurityViewDto addC(AbstractValidator abstractValidator) {
        UserSecurityRegisterValidator validator = (UserSecurityRegisterValidator) abstractValidator;
        if (userSecurityRepository.existsByUsername(validator.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The username is already taken");
        } else if (userSecurityRepository.existsByEmail(validator.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The email is already taken");
        }
        UserSecurity userSecurity = userSecurityMapper.set(validator);
        User user = userMapper.set(validator);
        Role p = permissionMapper.set(EnumRole.ROLE_USER);
        userSecurity.setUser(user);
        userSecurity.addPermission(p);
        permissionRepository.save(p);
        userRepository.save(user);
        userSecurityRepository.save(userSecurity);
        return userSecurityMapper.getView(userSecurity);
    }

    public UserSecurityViewDto login(String usernameOrEmail, String password, boolean rememberMe) {
        if (!userSecurityRepository.existsByEmail(usernameOrEmail) && !userSecurityRepository.existsByUsername(usernameOrEmail)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The username or the email is not correct");
        }
        UserSecurity user = userSecurityRepository.findByEmailOrUsername(usernameOrEmail).get();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The password is not correct");
        } else {
            //TODO last connection
            UserSecurityViewDto res = userSecurityMapper.getView(user);
            if (user.getEmailAuth()) {
                userSecurityFacade.setDoubleEmail(user);
                userSecurityRepository.save(user);
            } else {
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(res.getUsername(), password));

                SecurityContextHolder.getContext().setAuthentication(authentication);
                String jwt = jwtUtils.generateJwtToken(authentication);
                res.setToken(jwt);
            }
            System.out.println(rememberMe);
            if (rememberMe) {
                CookieRememberMe cookie = cookieRememberMeFacade.newInstance();
                cookieRememberMeRepository.save(cookie);
                user.addCookie(cookie);
                userSecurityRepository.save(user);
                res.setCookieToken(cookie.getToken());
            }
            return res;
        }
    }

    public UserSecurityViewDto confirmDoubleAuth(String usernameOrEmail, String password, String code, boolean rememberMe) {
        if (!userSecurityRepository.existsByEmail(usernameOrEmail) && !userSecurityRepository.existsByUsername(usernameOrEmail)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The username or the email is not correct");
        }
        UserSecurity user = userSecurityRepository.findByEmailOrUsername(usernameOrEmail).get();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserSecurityViewDto res;
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The password is not correct");
        } else if (!user.getEmailAuthToken().equals(code)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The code is not correct");
        } else {
            res = userSecurityMapper.getView(user);
            userSecurityFacade.confirmDoubleEmail(user);
            userSecurityRepository.save(user);
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(res.getUsername(), password));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);
            res.setToken(jwt);
            System.out.println(rememberMe);
            if (rememberMe) {
                CookieRememberMe cookie = cookieRememberMeFacade.newInstance();
                cookieRememberMeRepository.save(cookie);
                user.addCookie(cookie);
                userSecurityRepository.save(user);
                res.setCookieToken(cookie.getToken());
            }
        }
        return res;
    }

    public boolean setConfirmAccount(UserSecurity u) {
        userSecurityFacade.setConfirm(u);
        userSecurityRepository.save(u);
        return true;
    }

    public boolean confirmAccount(AbstractValidator abstractValidator) {
        UserSecurityTokenValidator validator = (UserSecurityTokenValidator) abstractValidator;
        if (!userSecurityRepository.existsByConfirmToken(validator.getToken())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This token is not valid or the user doesn't not exist");
        } else {
            UserSecurity user = userSecurityRepository.findByConfirmToken(validator.getToken()).get();
            userSecurityFacade.confirm(user);
            userSecurityRepository.save(user);
            log.info("User " + user.getUsername() + " has confirm is account");
            return true;
        }
    }

    public void resetAccount(AbstractValidator abstractValidator) {
        UserSecurityResetValidator validator = (UserSecurityResetValidator) abstractValidator;

        if (!userSecurityRepository.existsByResetToken(validator.getToken())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This token is not valid or the user doesn't not exist");
        } else {
            UserSecurity user = userSecurityRepository.findByResetToken(validator.getToken()).get();
            userSecurityMapper.reset(validator, user);
            userSecurityRepository.save(user);
        }
    }

    public void setResetAccount(AbstractValidator abstractValidator) {
        UserSecuritySetResetValidator validator = (UserSecuritySetResetValidator) abstractValidator;
        UserSecurity user = userSecurityRepository.findByEmailOrUsername(validator.getEmailOrUsername()).get();
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user doesn't not exist");
        } else {
            userSecurityFacade.setReset(user);
            userSecurityRepository.save(user);
        }
    }

    public void deleteAccount(AbstractValidator abstractValidator) {
        UserSecurityTokenValidator validator = (UserSecurityTokenValidator) abstractValidator;
        if (!userSecurityRepository.existsByDeleteToken(validator.getToken())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This token is not valid or the user doesn't not exist");
        } else {
            //UserSecurity user = userSecurityRepository.findByDeleteToken(validator.getToken()).get();
            //userSecurityRepository.deleteById(id);
        }
    }

    public void setDeleteAccount(AbstractValidator abstractValidator, UserSecurity userSecurity) {
        UserSecurityDeleteValidator validator = (UserSecurityDeleteValidator) abstractValidator;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (!passwordEncoder.matches(validator.getPassword(), userSecurity.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The password is not correct");
        } else {
            userSecurityFacade.setDelete(userSecurity);
            userSecurityRepository.save(userSecurity);
        }
    }

    public void updateUsernameEmail(AbstractValidator abstractValidator, UserSecurity userSecurity) {
        UserSecurityRegisterValidator validator = (UserSecurityRegisterValidator) abstractValidator;
        if (userSecurityRepository.existsByUsername(validator.getUsername()) && !validator.getUsername().equals(userSecurity.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The username is already taken");
        } else if (userSecurityRepository.existsByEmail(validator.getEmail()) && !validator.getEmail().equals(userSecurity.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The email is already taken");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (!passwordEncoder.matches(validator.getPassword(), userSecurity.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The password is not correct");
        } else {
            userSecurityMapper.update(userSecurity, validator);
            userMapper.update(userSecurity.getUser(), validator);
            userRepository.save(userSecurity.getUser());
            userSecurityRepository.save(userSecurity);
        }
    }

    public void updateFirstNameLastName(AbstractValidator abstractValidator, UserSecurity userSecurity) {
        UserSecurityNameUpdateValidator validator = (UserSecurityNameUpdateValidator) abstractValidator;
        userSecurityMapper.update(userSecurity, validator);
        userSecurityRepository.save(userSecurity);
    }

    public void updatePassword(AbstractValidator abstractValidator, UserSecurity userSecurity) {
        UserSecurityPasswordUpdateValidator validator = (UserSecurityPasswordUpdateValidator) abstractValidator;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (!passwordEncoder.matches(validator.getOldPassword(), userSecurity.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The password is not correct");
        } else {
            userSecurityFacade.updatePassword(userSecurity, validator.getPassword());
            userSecurityRepository.save(userSecurity);
        }
    }

    public void updateAppearance(AbstractValidator abstractValidator, UserSecurity userSecurity) {
        UserSecurityAppearanceUpdateValidator validator = (UserSecurityAppearanceUpdateValidator) abstractValidator;
        userSecurityFacade.updateAppearance(userSecurity, validator.getDark());
        userSecurityRepository.save(userSecurity);
    }

    public void updatePrivacy(AbstractValidator abstractValidator, UserSecurity userSecurity) {
        UserSecurityPrivacyUpdateValidator validator = (UserSecurityPrivacyUpdateValidator) abstractValidator;
        userSecurityFacade.updatePrivacy(userSecurity, validator.getIsPrivate());
        userSecurityRepository.save(userSecurity);
    }

    public void updateSecurity(AbstractValidator abstractValidator, UserSecurity userSecurity) {
        UserSecuritySecurityUpdateValidator validator = (UserSecuritySecurityUpdateValidator) abstractValidator;
        userSecurityFacade.updateSecurity(userSecurity, validator.getEmailAuth());
        userSecurityRepository.save(userSecurity);
    }

    @Override
    @Transactional
    public UserSecurity loadUserByUsername(String s) throws UsernameNotFoundException {
        UserSecurity user = userSecurityRepository.findByEmailOrUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + s));
        return userSecurityFacade.build(user);
    }

}
