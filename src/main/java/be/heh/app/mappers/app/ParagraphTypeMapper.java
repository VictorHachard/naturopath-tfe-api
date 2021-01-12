package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.GeneralTypeValidator;
import be.heh.app.model.entities.app.ParagraphType;
import be.heh.app.model.facades.app.ParagraphTypeFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class ParagraphTypeMapper {

    @Autowired
    ParagraphTypeFacade paragraphTypeFacade;

    public ParagraphType map(GeneralTypeValidator generalTypeValidator) {
        return paragraphTypeFacade.newInstance(generalTypeValidator.getName(), generalTypeValidator.getDescription());
    }

}
