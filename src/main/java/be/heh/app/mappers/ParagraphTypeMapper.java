package be.heh.app.mappers;

import be.heh.app.controller.validators.ParagraphTypeValidator;
import be.heh.app.model.entities.app.ParagraphType;
import be.heh.app.model.facades.app.ParagraphTypeFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class ParagraphTypeMapper {

    @Autowired
    static ParagraphTypeFacade paragraphTypeFacade;

    public static ParagraphType map(ParagraphTypeValidator paragraphTypeValidator) {
        return paragraphTypeFacade.newInstance(paragraphTypeValidator);
    }

}
