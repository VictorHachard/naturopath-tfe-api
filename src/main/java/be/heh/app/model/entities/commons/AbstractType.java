package be.heh.app.model.entities.commons;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public abstract class AbstractType extends AbstractEntity {

    public String getType() {
        return "AbstractType";
    }

}
