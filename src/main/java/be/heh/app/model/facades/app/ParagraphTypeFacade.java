package be.heh.app.model.facades.app;

import be.heh.app.controller.validators.app.ParagraphTypeValidator;
import be.heh.app.model.entities.app.ParagraphType;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.app.ParagraphTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParagraphTypeFacade extends AbstractFacade<ParagraphType> {

    @Autowired
    ParagraphTypeRepository paragraphTypeRepository;

    public ParagraphType newInstance(ParagraphTypeValidator paragraphTypeValidator) {
        ParagraphType paragraphType = new ParagraphType();
        paragraphType.setName(paragraphTypeValidator.getName());
        paragraphType.setDescription(paragraphTypeValidator.getDescription());
        return paragraphType;
    }

}
