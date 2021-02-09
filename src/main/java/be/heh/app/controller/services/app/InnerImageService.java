package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.InnerImageValidator;
import be.heh.app.controller.validators.app.update.InnerImageUpdateValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.model.entities.app.Image;
import be.heh.app.model.entities.app.InnerImage;
import be.heh.app.model.entities.app.enumeration.EnumState;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class InnerImageService extends AbstractService<InnerImage> {

    @Override
    public void add(AbstractValidator abstractValidator) {
        //TODO verifiaction
        InnerImageValidator validator = (InnerImageValidator) abstractValidator;
        Image image = imageRepository.findById(validator.getImageId()).get();
        InnerImage innerImage = innerImageMapper.set(validator, this.getUser());
        innerImageRepository.save(innerImage);
        image.add(innerImage);
        imageRepository.save(image);
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        //TODO verifiaction
        InnerImageUpdateValidator validator = (InnerImageUpdateValidator) abstractValidator;
        InnerImage innerImage = super.get(id);
        innerImageMapper.update(innerImage, validator);
        innerImageRepository.save(innerImage);
    }

    public void validation(AbstractValidator abstractValidator, int id) {
        //TODO verifiaction
        InnerImage innerImage = super.get(id);
        innerImage.setEnumState(EnumState.VALIDATING);
        innerImageRepository.save(innerImage);
    }

}
