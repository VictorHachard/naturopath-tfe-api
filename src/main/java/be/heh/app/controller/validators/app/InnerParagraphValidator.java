package be.heh.app.controller.validators.app;

import be.heh.app.controller.validators.commons.AbstractValidator;
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
public class InnerParagraphValidator extends AbstractValidator {

    @NotNull(message = "")
    @Size(min = 8, max = 128)
    @NotEmpty
    String title;

    @NotNull(message = "")
    @NotEmpty
    @Size(min = 128, max = 8182)
    String content;

    @NotNull(message = "")
    @Min(1)
    int paragraphId;

    @NotNull(message = "")
    @Min(1)
    int userId;

}
