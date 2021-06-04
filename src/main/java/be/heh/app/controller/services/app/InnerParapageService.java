package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.InnerParapageValidator;
import be.heh.app.controller.validators.app.InnerParatagValidator;
import be.heh.app.controller.validators.app.MessageValidator;
import be.heh.app.controller.validators.app.update.InnerParapageUpdateValidator;
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
public class InnerParapageService extends AbstractService<InnerParapage> {

    public void addC(AbstractValidator abstractValidator, int parapageId) {
        //TODO verifiaction
        InnerParapageValidator validator = (InnerParapageValidator) abstractValidator;
        Parapage parapage = parapageRepository.findById(parapageId).get();
        InnerParapage innerParapage = innerParapageMapper.set(validator,
                parapage.getInnerParapageList().get(parapage.getInnerParapageList().size() - 1).getVersion() + 1,
                this.getUser());
        innerParapageRepository.save(innerParapage);
        parapage.addInnerParapage(innerParapage);
        parapageRepository.save(parapage);
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        //TODO verifiaction
        InnerParapageUpdateValidator validator = (InnerParapageUpdateValidator) abstractValidator;
        InnerParapage innerParapage = super.get(id);
        innerParapageMapper.update(innerParapage, validator);
        if (!validator.getPageIdList().isEmpty()) {
            innerParapage.setPageList(pageRepository.findAllById(validator.getPageIdList()));
        }
        innerParapageRepository.save(innerParapage);
    }

    public void validation(AbstractValidator abstractValidator, int id) {
        //TODO verifiaction
        InnerParapage innerParapage = super.get(id);
        innerParapage.setEnumState(EnumState.VALIDATING);
        innerParapageRepository.save(innerParapage);
    }

    public void addMessage(AbstractValidator abstractValidator, int id) {
        //TODO verifiaction
        MessageValidator validator = (MessageValidator) abstractValidator;

        InnerParapage innerParapage = super.get(id);
        Message message = messageFacade.newInstance(validator.getContent(), this.getUser());
        innerParapage.addMessage(message);
        messageRepository.save(message);
        innerParapageRepository.save(innerParapage);
    }

}
