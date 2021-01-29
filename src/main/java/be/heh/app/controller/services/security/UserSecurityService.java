package be.heh.app.controller.services.security;

import be.heh.app.controller.services.commons.AbstractSecurityService;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.controller.validators.security.*;
import be.heh.app.dto.security.UserSecurityViewDto;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.security.UserSecurity;
import be.heh.app.model.facades.security.UserSecurityFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class UserSecurityService extends AbstractSecurityService<UserSecurity> {

    public UserSecurityViewDto addC(AbstractValidator abstractValidator) {
        UserSecurityRegisterValidator validator = (UserSecurityRegisterValidator) abstractValidator;
        UserSecurity userSecurity = userSecurityMapper.set(validator);
        User user = userMapper.set(validator);
        userSecurity.setUser(user);
        userRepository.save(user);
        userSecurityRepository.save(userSecurity);
        return userSecurityMapper.getView(userSecurity);
    }

    public UserSecurityViewDto login(AbstractValidator abstractValidator) {
        UserSecurityLoginValidator validator = (UserSecurityLoginValidator) abstractValidator;
        UserSecurity user = userSecurityRepository.findUserByEmailOrUsername(validator.getUsername(), validator.getEmail());
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The username or the email is not correct");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (!passwordEncoder.matches(validator.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The password is not correct");
        } else {
            return userSecurityMapper.getView(user);
        }
    }

    public boolean confirmAccount(AbstractValidator abstractValidator) {
        UserSecurityTokenValidator validator = (UserSecurityTokenValidator) abstractValidator;
        UserSecurity user = userSecurityRepository.findUserByConfirmToken(validator.getToken());
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This token is not valid");
        } else {
            userSecurityFacade.confirm(user);
            return true;
        }
    }

    public UserSecurityViewDto resetAccount(AbstractValidator abstractValidator) {
        UserSecurityResetValidator validator = (UserSecurityResetValidator) abstractValidator;
        UserSecurity user = userSecurityRepository.findUserByResetToken(validator.getToken());
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This token is not valid");
        } else {
            userSecurityMapper.reset(validator, user);
            return userSecurityMapper.getEdit(user);
        }
    }

    public boolean setResetAccount(AbstractValidator abstractValidator) {
        UserSecuritySetResetValidator validator = (UserSecuritySetResetValidator) abstractValidator;
        UserSecurity user = userSecurityRepository.findUserByEmailOrUsername(validator.getUsername(), validator.getEmail());
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user doesn't not exist");
        } else {
            userSecurityFacade.setReset(user);
            return true;
        }
    }

    public boolean deleteAccount(AbstractValidator abstractValidator) {
        UserSecurityTokenValidator validator = (UserSecurityTokenValidator) abstractValidator;
        UserSecurity user = userSecurityRepository.findUserByDeleteToken(validator.getToken());
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This token is not valid");
        } else {
            //userSecurityRepository.deleteById(id);
            return true;
        }
    }

    public boolean setDeleteAccount(int id) {
        if (userSecurityRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user doesn't not exist");
        } else {
            userSecurityFacade.setDelete(userSecurityRepository.findById(id).get());
            return true;
        }
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        UserSecurityRegisterValidator validator = (UserSecurityRegisterValidator) abstractValidator;
    }

}
