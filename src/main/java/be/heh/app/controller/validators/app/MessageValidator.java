package be.heh.app.controller.validators.app;

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
public class MessageValidator {

    @NotNull(message = "")
    @NotEmpty
    @Size(min = 4, max = 2048)
    String content;

    @NotNull(message = "")
    @Min(1)
    int userId;

    @NotNull(message = "")
    @Min(1)
    int id;

    @NotNull(message = "")
    String typeMessage;

}
