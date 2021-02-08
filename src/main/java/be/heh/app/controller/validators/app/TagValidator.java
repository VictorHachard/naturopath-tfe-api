package be.heh.app.controller.validators.app;

import be.heh.app.controller.validators.commons.AbstractValidator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class TagValidator extends AbstractValidator {

    @NotNull(message = "")
    @NotEmpty
    String name;

    @NotNull(message = "")
    @NotEmpty
    String content;

    @NotNull(message = "")
    @Min(1)
    int tagTypeId;

}
