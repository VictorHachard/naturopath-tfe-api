package be.heh.app.controller.validators.app;

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
public class CategoryValidator extends AbstractValidator {

    @NotNull(message = "")
    @NotEmpty
    @Size(min = 4, max = 32)
    String name;

    @NotNull(message = "")
    @NotEmpty
    @Size(min = 16, max = 1024) //TODO check w  ith the entity the max
    String description;

    @NotNull(message = "")
    Boolean isParent;

    // For parent can be null
    Integer parentCategoryId;

}
