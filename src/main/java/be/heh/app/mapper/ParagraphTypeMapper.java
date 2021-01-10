package be.heh.app.mapper;

import be.heh.app.controller.validators.ParagraphTypeValidator;
import be.heh.app.model.entities.app.ParagraphType;

public final class ParagraphTypeMapper {

    public static ParagraphType map(ParagraphTypeValidator paragraphTypeValidator) {
        ParagraphType paragraphType = new ParagraphType();
        paragraphType.setName(paragraphTypeValidator.getName());
        paragraphType.setDescription(paragraphTypeValidator.getDescription());
        return paragraphType;
    }

}
