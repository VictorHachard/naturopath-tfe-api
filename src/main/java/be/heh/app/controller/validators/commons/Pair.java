package be.heh.app.controller.validators.commons;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class Pair extends AbstractValidator {

    @NotNull(message = "")
    @Min(1)
    Integer id;

    @NotNull(message = "")
    @NotEmpty
    String type;

}
