package be.heh.app.mappers.security;

import be.heh.app.controller.validators.security.UserSecurityRegisterValidator;
import be.heh.app.controller.validators.security.UserSecurityResetValidator;
import be.heh.app.dto.security.UserSecurityViewDto;
import be.heh.app.init.AbstractSecurityAutowire;
import be.heh.app.model.entities.security.UserSecurity;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class UserSecurityMapper extends AbstractSecurityAutowire {

    public UserSecurity set(UserSecurityRegisterValidator validator) {
        UserSecurity res = userSecurityFacade.newInstance(
                validator.getUsername(),
                validator.getEmail(),
                validator.getPassword()
        );
        return res;
    }

    public void reset(UserSecurityResetValidator validator, UserSecurity user) {
        userSecurityFacade.reset(user, validator.getPassword());
    }

    public UserSecurityViewDto getView(UserSecurity user) {
        return new UserSecurityViewDto(
                user.getId(),
                user.getUsername());
    }

    public UserSecurityViewDto getEdit(UserSecurity user) {
        return null; //TODO
    }

}
