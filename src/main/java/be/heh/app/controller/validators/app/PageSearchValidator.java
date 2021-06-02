package be.heh.app.controller.validators.app;

import be.heh.app.controller.validators.commons.AbstractValidator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class PageSearchValidator extends AbstractValidator {

    @NotNull(message = "")
    @NotEmpty
    @Size(min = 3, max = 256)
    String search;

    int limit;

    boolean justOnePageByCategory;

}