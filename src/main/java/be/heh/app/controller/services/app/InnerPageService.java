package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.MessageValidator;
import be.heh.app.controller.validators.app.update.InnerPageUpdateValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.model.entities.app.Image;
import be.heh.app.model.entities.app.InnerPage;
import be.heh.app.model.entities.app.Message;
import be.heh.app.model.entities.app.Page;
import be.heh.app.model.entities.app.enumeration.EnumState;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class InnerPageService extends AbstractService<InnerPage> {

    public void addC(AbstractValidator abstractValidator, int id) {
        //TODO verifiaction
        InnerPageUpdateValidator validator = (InnerPageUpdateValidator) abstractValidator;
        Page page = pageRepository.findById(id).get();

        Image image = imageRepository.findById(validator.getImageId()).get();
        InnerPage innerPage = innerPageMapper.set(validator, image,
                page.getInnerPageList().get(page.getInnerPageList().size() - 1).getVersion() + 1,
                this.getUser());
        innerPageRepository.save(innerPage);
        page.addInnerPage(innerPage);
        pageRepository.save(page);
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        //TODO verifiaction
        InnerPageUpdateValidator validator = (InnerPageUpdateValidator) abstractValidator;
        InnerPage innerPage = super.get(id);
        Image image = imageRepository.findById(validator.getImageId()).get();
        innerPageMapper.update(innerPage, image, validator);
        innerPageRepository.save(innerPage);
    }

    public void validation(AbstractValidator abstractValidator, int id) {
        //TODO verifiaction
        InnerPage innerPage = super.get(id);
        innerPage.setEnumState(EnumState.VALIDATING);
        innerPageRepository.save(innerPage);
    }

    public void addMessage(AbstractValidator abstractValidator, int id) {
        //TODO verifiaction
        MessageValidator validator = (MessageValidator) abstractValidator;

        InnerPage innerPage = super.get(id);
        Message message = messageFacade.newInstance(validator.getContent(), this.getUser());
        innerPage.addMessage(message);
        messageRepository.save(message);
        innerPageRepository.save(innerPage);
    }

}
