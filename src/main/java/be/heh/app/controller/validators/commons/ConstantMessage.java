package be.heh.app.controller.validators.commons;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

// Lombok
@FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
public final class ConstantMessage {

    public final static String notNull = " cannot be null.";

}
