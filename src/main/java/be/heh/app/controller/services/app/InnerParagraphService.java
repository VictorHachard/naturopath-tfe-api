package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.InnerParagraphValidator;
import be.heh.app.controller.validators.app.update.InnerParagraphUpdateValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.model.entities.app.InnerParagraph;
import be.heh.app.model.entities.app.Paragraph;
import be.heh.app.model.entities.app.User;
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

    @Override
    public void add(AbstractValidator abstractValidator) {
        //TODO verifiaction
        InnerParagraphValidator validator = (InnerParagraphValidator) abstractValidator;
        Paragraph paragraph = paragraphRepository.findById(validator.getParagraphTypeId()).get();
        User user = userRepository.findById(validator.getUserId()).get();

        InnerParagraph innerParagraph = innerParagraphMapper.set(validator, user);
        innerParagraphRepository.save(innerParagraph);
        paragraph.addInnerParagraph(innerParagraph);
        paragraphRepository.save(paragraph);
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        //TODO verifiaction
        InnerParagraphUpdateValidator validator = (InnerParagraphUpdateValidator) abstractValidator;
        InnerParagraph innerParagraph = innerParagraphRepository.findById(id).get();
        innerParagraphMapper.update(innerParagraph, validator);
        innerParagraphRepository.save(innerParagraph);
    }

    public void validation(int id) {
        //TODO verifiaction
        InnerParagraph innerParagraph = innerParagraphRepository.findById(id).get();
        innerParagraph.setEnumState(EnumState.VALADATING);
        innerParagraphRepository.save(innerParagraph);
    }

}
