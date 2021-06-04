package be.heh.app.controller.validators.app.update;

import be.heh.app.controller.validators.commons.AbstractValidator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class InnerTagUpdateValidator extends AbstractValidator {

    String name;

    String content;
}
