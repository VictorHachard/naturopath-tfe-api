package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.InnerParatagValidator;
import be.heh.app.controller.validators.app.MessageValidator;
import be.heh.app.controller.validators.app.update.InnerParagraphUpdateValidator;
import be.heh.app.controller.validators.app.update.InnerParatagUpdateValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.model.entities.app.*;
import be.heh.app.model.entities.app.enumeration.EnumState;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class InnerParatagService extends AbstractService<InnerParatag> {

    public void addC(AbstractValidator abstractValidator, int paragraphId) {
        //TODO verifiaction
        InnerParatagValidator validator = (InnerParatagValidator) abstractValidator;
        Paratag paratag = paratagRepository.findById(paragraphId).get();
        InnerParatag innerParatag = innerParatagMapper.set(validator,
                paratag.getInnerParatagList().get(paratag.getInnerParatagList().size() - 1).getVersion() + 1,
                this.getUser());
        innerParatagRepository.save(innerParatag);
        paratag.addInnerParatag(innerParatag);
        paratagRepository.save(paratag);
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        //TODO verifiaction
        InnerParatagUpdateValidator validator = (InnerParatagUpdateValidator) abstractValidator;
        InnerParatag innerParatag = super.get(id);
        innerParatagMapper.update(innerParatag, validator);
        if (!validator.getTagIdList().isEmpty()) {
            innerParatag.setTagList(tagRepository.findAllById(validator.getTagIdList()));
        }
        innerParatagRepository.save(innerParatag);
    }

    public void validation(AbstractValidator abstractValidator, int id) {
        //TODO verifiaction
        InnerParatag innerParatag = super.get(id);
        innerParatag.setEnumState(EnumState.VALIDATING);
        innerParatagRepository.save(innerParatag);
    }

    public void addMessage(AbstractValidator abstractValidator, int id) {
        //TODO verifiaction
        MessageValidator validator = (MessageValidator) abstractValidator;

        InnerParatag innerParatag = super.get(id);
        Message message = messageFacade.newInstance(validator.getContent(), this.getUser());
        innerParatag.addMessage(message);
        messageRepository.save(message);
        innerParatagRepository.save(innerParatag);
    }

}
