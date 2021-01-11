package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.TagValidator;
import be.heh.app.model.entities.app.InnerTag;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.facades.app.InnerTagFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class InnerTagMapper {

    @Autowired
    InnerTagFacade innerTagFacade;

    public InnerTag map(TagValidator tagValidator, User user) {
        return innerTagFacade.newInstance(tagValidator.getName(), tagValidator.getDescription(), user);
    }

}
