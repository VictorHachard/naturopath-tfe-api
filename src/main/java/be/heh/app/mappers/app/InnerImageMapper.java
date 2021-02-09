package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.ImageValidator;
import be.heh.app.controller.validators.app.InnerImageValidator;
import be.heh.app.controller.validators.app.update.InnerImageUpdateValidator;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.InnerImage;
import be.heh.app.model.entities.app.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class InnerImageMapper extends AbstractMapper {

    public InnerImage set(User user) {
        return innerImageFacade.newInstance(user);
    }

    public InnerImage set(ImageValidator validator, User user) {
        return innerImageFacade.newInstance(
                validator.getTitle(),
                validator.getDescription(),
                validator.getUrl(),
                user
        );
    }

    public InnerImage set(InnerImageValidator validator, User user) {
        return innerImageFacade.newInstance(
                validator.getTitle(),
                validator.getDescription(),
                validator.getUrl(),
                user
        );
    }

    public void update(InnerImage innerImage, InnerImageUpdateValidator validator) {
        innerImage.setTitle(validator.getTitle());
        innerImage.setDescription(validator.getDescription());
    }

}
