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
public class MessageValidator {

    @NotNull(message = "")
    String content;

    @NotNull(message = "")
    int userId;

    @NotNull(message = "")
    int id;

    @NotNull(message = "")
    String typeMessage;

}
