package be.heh.app.controller.validators;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class TagValidator {

    @NotNull(message = "")
    @NotEmpty
    String name;

    @NotNull(message = "")
    @NotEmpty
    String description;

    @NotNull(message = "")
    @Min(1)
    int tagTypeId;

    @NotNull(message = "")
    @Min(1)
    int pageId;

    @NotNull(message = "")
    @Min(1)
    int userId;

}
