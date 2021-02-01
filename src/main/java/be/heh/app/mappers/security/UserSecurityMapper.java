package be.heh.app.mappers.security;

import be.heh.app.controller.validators.security.UserSecurityRegisterValidator;
import be.heh.app.controller.validators.security.UserSecurityResetValidator;
import be.heh.app.dto.security.UserSecurityEditDto;
import be.heh.app.dto.security.UserSecurityViewDto;
import be.heh.app.init.AbstractSecurityAutowire;
import be.heh.app.model.entities.security.UserSecurity;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public void update(UserSecurity userSecurity, UserSecurityRegisterValidator validator) {
        userSecurityFacade.update(userSecurity, validator.getUsername(), validator.getEmail());
    }

    public void reset(UserSecurityResetValidator validator, UserSecurity user) {
        userSecurityFacade.reset(user, validator.getPassword());
    }

    public UserSecurityViewDto getView(UserSecurity user) {
        List<String> res = new ArrayList<>();
        user.getEnumPermissionList().forEach(permission -> {
            res.add(permission.getName().name());
        });
        return new UserSecurityViewDto(
                null,
                user.getUsername(),
                res
        );
    }

    public UserSecurityEditDto getEdit(UserSecurity user) {
        List<String> res = new ArrayList<>();
        user.getEnumPermissionList().forEach(permission -> {
            res.add(permission.getName().name());
        });
        return new UserSecurityEditDto(
                null,
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirth(),
                (user.getConfirmedAt() != null),
                user.getAllEmails(),
                user.getIsProfilePrivacy(),
                res
        );
    }

}
