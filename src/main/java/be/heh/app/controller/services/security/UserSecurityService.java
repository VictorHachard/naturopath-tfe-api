package be.heh.app.controller.services.security;

import be.heh.app.controller.services.commons.AbstractSecurityService;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.controller.validators.security.*;
import be.heh.app.dto.security.UserSecurityViewDto;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.security.Role;
import be.heh.app.model.entities.security.UserSecurity;
import be.heh.app.model.entities.security.enumeration.EnumRole;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
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

    public UserSecurityViewDto login(AbstractValidator abstractValidator) {
        UserSecurityLoginValidator validator = (UserSecurityLoginValidator) abstractValidator;
        UserSecurity user = userSecurityRepository.findByEmailOrUsername(validator.getEmailOrUsername()).get();
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The username or the email is not correct");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (!passwordEncoder.matches(validator.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The password is not correct");
        } else {
            userSecurityRepository.save(user);
            return userSecurityMapper.getView(user);
        }
    }

    public void logout() {

    }

    public boolean setConfirmAccount(int id) {
        if (userSecurityRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user doesn't not exist");
        } else {
            userSecurityFacade.setConfirm(userSecurityRepository.findById(id).get());
            return true;
        }
    }

    public boolean confirmAccount(AbstractValidator abstractValidator) {
        UserSecurityTokenValidator validator = (UserSecurityTokenValidator) abstractValidator;
        if (!userSecurityRepository.existsByConfirmToken(validator.getToken())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This token is not valid");
        } else {
            UserSecurity user = userSecurityRepository.findByConfirmToken(validator.getToken()).get();
            userSecurityFacade.confirm(user);
            return true;
        }
    }

    public UserSecurityViewDto resetAccount(AbstractValidator abstractValidator) {
        UserSecurityResetValidator validator = (UserSecurityResetValidator) abstractValidator;

        if (!userSecurityRepository.existsByResetToken(validator.getToken())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This token is not valid");
        } else {
            UserSecurity user = userSecurityRepository.findByResetToken(validator.getToken()).get();
            userSecurityMapper.reset(validator, user);
            return null;
            //return userSecurityMapper.getEdit(user);
        }
    }

    public boolean setResetAccount(AbstractValidator abstractValidator) {
        UserSecuritySetResetValidator validator = (UserSecuritySetResetValidator) abstractValidator;
        UserSecurity user = userSecurityRepository.findByEmailOrUsername(validator.getEmailOrUsername()).get();
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user doesn't not exist");
        } else {
            userSecurityFacade.setReset(user);
            return true;
        }
    }

    public boolean deleteAccount(AbstractValidator abstractValidator) {
        UserSecurityTokenValidator validator = (UserSecurityTokenValidator) abstractValidator;
        if (!userSecurityRepository.existsByDeleteToken(validator.getToken())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This token is not valid");
        } else {
            //UserSecurity user = userSecurityRepository.findByDeleteToken(validator.getToken()).get();
            //userSecurityRepository.deleteById(id);
            return true;
        }
    }

    public boolean setDeleteAccount(int id) {
        if (userSecurityRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user doesn't not exist");
        } else {
            //userSecurityFacade.setDelete(userSecurityRepository.findById(id).get());
            return true;
        }
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        UserSecurityRegisterValidator validator = (UserSecurityRegisterValidator) abstractValidator;
    }

    @Override
    @Transactional
    public UserSecurity loadUserByUsername(String s) throws UsernameNotFoundException {
        UserSecurity user = userSecurityRepository.findByEmailOrUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + s));

        return userSecurityFacade.build(user);
    }
}
