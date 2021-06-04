package be.heh.app.mappers.security;

import be.heh.app.controller.validators.security.UserSecurityNameUpdateValidator;
import be.heh.app.controller.validators.security.UserSecurityRegisterValidator;
import be.heh.app.controller.validators.security.UserSecurityResetValidator;
import be.heh.app.dto.security.UserSecurityEditDto;
import be.heh.app.dto.security.UserSecuritySimplifiedViewDto;
import be.heh.app.dto.security.UserSecurityViewDto;
import be.heh.app.dto.view.ImageViewDto;
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
public final class UserSecurityMapper extends AbstractSecurityAutowire {

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

    public void update(UserSecurity userSecurity, UserSecurityNameUpdateValidator validator) {
        userSecurityFacade.updateName(userSecurity, validator.getFirstName(), validator.getLastName());
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
                res,
                user.getIsDark(),
                user.getEmailAuth() && user.getEmailAuthAt() != null,
                null
        );
    }

    public List<UserSecurityEditDto> getAllEdit(List<UserSecurity> userList) {
        List<UserSecurityEditDto> res = new ArrayList<>();
        userList.forEach(i -> {
            res.add(this.getEdit(i));
        });
        return res;
    }

    public UserSecurityEditDto getEdit(UserSecurity user) {
        List<String> roleList = new ArrayList<>();
        user.getEnumPermissionList().forEach(permission -> {
            roleList.add(permission.getName().name());
        });
        List<String> emailList = new ArrayList<>();
        user.getEnumEmailList().forEach(email -> {
            emailList.add(email.getName().name());
        });
        return new UserSecurityEditDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirth(),
                (user.getConfirmedAt() != null),
                user.getIsProfilePrivacy(),
                user.getIsDark(),
                roleList,
                emailList,
                user.getEmailAuth()
        );
    }

    public UserSecuritySimplifiedViewDto getSimplifiedViewDto(UserSecurity user) {
        return new UserSecuritySimplifiedViewDto(
                user.getId(),
                user.getUsername()
        );
    }

}
