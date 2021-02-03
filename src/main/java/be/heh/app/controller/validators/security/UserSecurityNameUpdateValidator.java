package be.heh.app.controller.validators.security;

import be.heh.app.controller.validators.commons.AbstractValidator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class UserSecurityNameUpdateValidator extends AbstractValidator {

    @NotNull(message = "")
    @NotEmpty
    String firstName;

    @NotNull(message = "")
    @NotEmpty
    String lastName;

}
