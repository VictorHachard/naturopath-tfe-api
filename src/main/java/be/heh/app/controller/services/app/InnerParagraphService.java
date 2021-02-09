package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.update.InnerParagraphUpdateValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.model.entities.app.InnerParagraph;
import be.heh.app.model.entities.app.Paragraph;
import be.heh.app.model.entities.app.enumeration.EnumState;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class InnerParagraphService extends AbstractService<InnerParagraph> {

    public void addC(AbstractValidator abstractValidator, int paragraphId) {
        //TODO verifiaction
        InnerParagraphUpdateValidator validator = (InnerParagraphUpdateValidator) abstractValidator;
        Paragraph paragraph = paragraphRepository.findById(paragraphId).get();
        InnerParagraph innerParagraph = innerParagraphMapper.set(validator, this.getUser());
        innerParagraphRepository.save(innerParagraph);
        paragraph.addInnerParagraph(innerParagraph);
        paragraphRepository.save(paragraph);
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        //TODO verifiaction
        InnerParagraphUpdateValidator validator = (InnerParagraphUpdateValidator) abstractValidator;
        InnerParagraph innerParagraph = super.get(id);
        innerParagraphMapper.update(innerParagraph, validator);
        innerParagraphRepository.save(innerParagraph);
    }

    public void validation(AbstractValidator abstractValidator, int id) {
        //TODO verifiaction
        InnerParagraph innerParagraph = super.get(id);
        innerParagraph.setEnumState(EnumState.VALIDATING);
        innerParagraphRepository.save(innerParagraph);
    }

}
