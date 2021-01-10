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
public class ParagraphValidator {

    @NotNull(message = "")
    String title;

    @NotNull(message = "")
    String content;

    @NotNull(message = "")
    int paragraphTypeId;

    @NotNull(message = "")
    int pageId;

    @NotNull(message = "")
    int userId;

}
