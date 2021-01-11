package be.heh.app.mappers;

import be.heh.app.controller.validators.TagTypeValidator;
import be.heh.app.model.entities.app.TagType;
import be.heh.app.model.facades.app.TagTypeFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class TagTypeMapper {

    @Autowired
    static TagTypeFacade tagTypeFacade;

    public static TagType map(TagTypeValidator tagTypeValidator) {
        return tagTypeFacade.newInstance(tagTypeValidator);
    }

}
