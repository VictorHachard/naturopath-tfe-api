package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.MessageValidator;
import be.heh.app.controller.validators.app.update.InnerImageUpdateValidator;
import be.heh.app.controller.validators.app.validation.InnerImageValidationValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.model.entities.app.Image;
import be.heh.app.model.entities.app.InnerImage;
import be.heh.app.model.entities.app.Message;
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

    public void addC(AbstractValidator abstractValidator, int id) {
        //TODO verifiaction
        InnerImageUpdateValidator validator = (InnerImageUpdateValidator) abstractValidator;
        Image image = imageRepository.findById(id).get();
        InnerImage innerImage = innerImageMapper.set(validator,
                image.getInnerImageList().get(image.getInnerImageList().size() - 1).getVersion() + 1,
                this.getUser());
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
        InnerImageValidationValidator validator = (InnerImageValidationValidator) abstractValidator;
        InnerImage innerImage = super.get(id);
        innerImage.setEnumState(EnumState.VALIDATING);
        innerImageRepository.save(innerImage);
    }

    public void addMessage(AbstractValidator abstractValidator, int id) {
        //TODO verifiaction
        MessageValidator validator = (MessageValidator) abstractValidator;

        InnerImage innerImage = super.get(id);
        Message message = messageFacade.newInstance(validator.getContent(), this.getUser());
        innerImage.addMessage(message);
        messageRepository.save(message);
        innerImageRepository.save(innerImage);
    }

}
