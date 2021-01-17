package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.TagUpdateValidator;
import be.heh.app.controller.validators.app.TagValidator;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.InnerTag;
import be.heh.app.model.entities.app.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class InnerTagMapper extends AbstractMapper {

    public InnerTag set(TagValidator tagValidator, User user) {
        return innerTagFacade.newInstance(
                tagValidator.getName(),
                tagValidator.getDescription(),
                user);
    }

    public InnerTag set(TagUpdateValidator tagUpdateValidator, int version, User user) {
        return innerTagFacade.newInstance(
                tagUpdateValidator.getName(),
                tagUpdateValidator.getDescription(),
                version,
                user);
    }

}
