package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.update.InnerParagraphUpdateValidator;
import be.heh.app.controller.validators.app.update.InnerParatagUpdateValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.model.entities.app.InnerParagraph;
import be.heh.app.model.entities.app.InnerParatag;
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
public class InnerParatagService extends AbstractService<InnerParatag> {

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
        InnerParatagUpdateValidator validator = (InnerParatagUpdateValidator) abstractValidator;
        InnerParatag innerParatag = super.get(id);
        innerParatagMapper.update(innerParatag, validator);

        innerParatag.cleanTag();

        innerParatagRepository.save(innerParatag);

        System.out.println(tagRepository.findAllById(validator.getTagIdList()));
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

}
