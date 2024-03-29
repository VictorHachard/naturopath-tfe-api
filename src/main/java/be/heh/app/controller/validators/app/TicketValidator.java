package be.heh.app.controller.validators.app;

import be.heh.app.controller.validators.commons.AbstractValidator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class TicketValidator extends AbstractValidator {

    @NotNull(message = "")
    @NotEmpty
    String subject;

    @NotNull(message = "")
    @NotEmpty
    @Size(max = 2500)
    String content;

}
