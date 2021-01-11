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
public class InnerPageValidator {

    @NotNull(message = "")
    String title;

    @NotNull(message = "")
    String description;

    @NotNull(message = "")
    int pageId;

}
