package be.heh.app.controller.validators;

import be.heh.app.model.entities.app.Category;
import be.heh.app.model.entities.app.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class PageValidator {

    @NotNull(message = "")
    String name;

    @NotNull(message = "")
    String description;

    @NotNull(message = "")
    Category category;

    @NotNull(message = "")
    User user;

}
