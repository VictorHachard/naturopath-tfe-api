package be.heh.app.controller.validators;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class TagTypeValidator {

    @NotNull(message = "")
    String name;

    @NotNull(message = "")
    String description;

}
