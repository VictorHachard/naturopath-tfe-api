package be.heh.app.mappers.app;

import be.heh.app.controller.validators.security.UserSecurityLoginValidator;
import be.heh.app.controller.validators.security.UserSecurityRegisterValidator;
import be.heh.app.controller.validators.security.UserSecurityResetValidator;
import be.heh.app.dto.view.UserViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class UserMapper extends AbstractMapper {

    public User set(UserSecurityRegisterValidator validator) {
        return userFacade.newInstance(validator.getUsername());
    }

    public UserViewDto getView(User user) {
        return new UserViewDto(
                user.getId(),
                user.getUsername());
    }

}
