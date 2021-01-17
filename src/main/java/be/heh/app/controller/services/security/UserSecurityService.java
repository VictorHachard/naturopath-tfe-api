package be.heh.app.controller.services.security;

import be.heh.app.controller.services.commons.AbstractSecurityService;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.controller.validators.security.UserSecurityValidator;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.security.UserSecurity;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class UserSecurityService extends AbstractSecurityService<UserSecurity> {

    @Override
    public void add(AbstractValidator abstractValidator) {
        UserSecurityValidator validator = (UserSecurityValidator) abstractValidator;
        UserSecurity userSecurity = userSecurityMapper.set(validator);
        User user = userMapper.set();
        userSecurity.setUser(user);
        userRepository.save(user);
        userSecurityRepository.save(userSecurity);
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        UserSecurityValidator validator = (UserSecurityValidator) abstractValidator;
    }

}
