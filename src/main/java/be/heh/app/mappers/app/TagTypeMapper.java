package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.GeneralTypeValidator;
import be.heh.app.model.entities.app.TagType;
import be.heh.app.model.facades.app.TagTypeFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class TagTypeMapper {

    @Autowired
    TagTypeFacade tagTypeFacade;

    public TagType map(GeneralTypeValidator generalTypeValidator) {
        return tagTypeFacade.newInstance(generalTypeValidator.getName(), generalTypeValidator.getDescription());
    }

}
