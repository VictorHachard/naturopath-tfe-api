package be.heh.app.controller.validators.app.validation;

import be.heh.app.controller.validators.commons.AbstractValidator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class InnerImageValidationValidator extends AbstractValidator {

    @NotNull(message = "")
    @NotEmpty
    @Size(min = 2, max = 32)
    String title;

    @NotNull(message = "")
    @NotEmpty
    @Size(min = 32, max = 1024)
    String description;

    @NotNull(message = "")
    @NotEmpty
    String url;

}
