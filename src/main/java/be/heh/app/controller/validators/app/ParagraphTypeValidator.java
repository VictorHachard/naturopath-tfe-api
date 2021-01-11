package be.heh.app.controller.validators.app;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class ParagraphTypeValidator {

    @NotNull(message = "")
    @NotEmpty
    @Size(min = 2, max = 32)
    String name;

    @NotNull(message = "")
    @NotEmpty
    @Size(min = 16, max = 1024)
    String description;

}
