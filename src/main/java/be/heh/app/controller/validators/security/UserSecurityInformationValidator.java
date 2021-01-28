package be.heh.app.controller.validators.security;

import be.heh.app.controller.validators.commons.AbstractValidator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class UserSecurityInformationValidator extends AbstractValidator {

    @NotNull(message = "")
    @NotEmpty
    @Pattern(regexp = "[A-Z][a-zA-Z]*", message = "Firstname must start with a capitalized letter")
    String firstName;

    @NotNull(message = "")
    @NotEmpty
    @Pattern(regexp = "[A-Z][a-zA-Z]*", message = "Lastname must start with a capitalized letter")
    String lastName;

    @NotNull(message = "")
    String birth;

}
