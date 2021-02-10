package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.MessageValidator;
import be.heh.app.controller.validators.app.update.InnerTagUpdateValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.model.entities.app.InnerTag;
import be.heh.app.model.entities.app.Message;
import be.heh.app.model.entities.app.Tag;
import be.heh.app.model.entities.app.enumeration.EnumState;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class InnerTagService extends AbstractService<InnerTag> {

    public void addC(AbstractValidator abstractValidator, int TagId) {
        //TODO verifiaction
        InnerTagUpdateValidator validator = (InnerTagUpdateValidator) abstractValidator;
        Tag tag = tagRepository.findById(TagId).get();
        InnerTag innerTag = innerTagMapper.set(validator,
                tag.getInnerTagList().get(tag.getInnerTagList().size() - 1).getVersion() + 1,
                this.getUser());
        innerTagRepository.save(innerTag);
        tag.addInnerTag(innerTag);
        tagRepository.save(tag);
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        //TODO verifiaction
        InnerTagUpdateValidator validator = (InnerTagUpdateValidator) abstractValidator;
        InnerTag innerTag = super.get(id);
        innerTagMapper.update(innerTag, validator);
        innerTagRepository.save(innerTag);
    }

    public void validation(AbstractValidator abstractValidator, int id) {
        //TODO verifiaction
        InnerTag innerTag = super.get(id);
        innerTag.setEnumState(EnumState.VALIDATING);
        innerTagRepository.save(innerTag);
    }

    public void addMessage(AbstractValidator abstractValidator, int id) {
        //TODO verifiaction
        MessageValidator validator = (MessageValidator) abstractValidator;

        InnerTag innerTag = super.get(id);
        Message message = messageFacade.newInstance(validator.getContent(), this.getUser());
        innerTag.addMessage(message);
        messageRepository.save(message);
        innerTagRepository.save(innerTag);
    }

}
