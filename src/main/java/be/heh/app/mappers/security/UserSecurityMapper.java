package be.heh.app.mappers.security;

import be.heh.app.controller.validators.security.UserSecurityValidator;
import be.heh.app.init.AbstractSecurityAutowire;
import be.heh.app.model.entities.security.UserSecurity;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class UserSecurityMapper extends AbstractSecurityAutowire {

    public UserSecurity set(UserSecurityValidator validator) {
        UserSecurity res = userSecurityFacade.newInstance(validator.getUsername(),
                validator.getEmail(),
                validator.getFirstName(),
                validator.getLastName(),
                validator.getPassword(),
                new Date(validator.getBirth()));
        return res;
    }

}
