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
public class InnerPageValidator {

    @NotNull(message = "")
    @NotEmpty
    String title;

    @NotNull(message = "")
    @NotEmpty
    String description;

    @NotNull(message = "")
    @Min(1)
    int pageId;

}
