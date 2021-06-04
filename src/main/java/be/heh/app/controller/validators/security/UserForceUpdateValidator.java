package be.heh.app.controller.validators.security;

import be.heh.app.controller.validators.commons.AbstractValidator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class UserForceUpdateValidator extends AbstractValidator {

    @NotNull(message = "")
    @NotEmpty
    @Email
    String email;

    @NotNull(message = "")
    Boolean owner;

    @NotNull(message = "")
    Boolean administrator;

    @NotNull(message = "")
    Boolean moderator;

    @NotNull(message = "")
    Boolean user;

}
