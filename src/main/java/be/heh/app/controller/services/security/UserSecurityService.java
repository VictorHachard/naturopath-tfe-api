package be.heh.app.controller.services.security;

import be.heh.app.controller.services.commons.AbstractSecurityService;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.controller.validators.security.UserSecurityLoginValidator;
import be.heh.app.controller.validators.security.UserSecurityRegisterValidator;
import be.heh.app.dto.security.UserSecurityViewDto;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.security.UserSecurity;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class UserSecurityService extends AbstractSecurityService<UserSecurity> {

    public UserSecurityViewDto addC(AbstractValidator abstractValidator) {
        UserSecurityRegisterValidator validator = (UserSecurityRegisterValidator) abstractValidator;
        UserSecurity userSecurity = userSecurityMapper.set(validator);
        User user = userMapper.set();
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

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        UserSecurityRegisterValidator validator = (UserSecurityRegisterValidator) abstractValidator;
    }

}
