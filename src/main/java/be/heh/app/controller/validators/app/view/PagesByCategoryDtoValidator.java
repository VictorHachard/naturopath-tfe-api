package be.heh.app.controller.validators.app.view;

import be.heh.app.controller.validators.commons.AbstractValidator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class PagesByCategoryDtoValidator extends AbstractValidator {

    @NotNull(message = "")
    @Min(1)
    Integer categoryId;

}
