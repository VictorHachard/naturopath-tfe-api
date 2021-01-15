package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.ParagraphValidator;
import be.heh.app.controller.validators.app.update.ParagraphUpdateValidator;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.InnerParagraph;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.facades.app.InnerParagraphFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class InnerParagraphMapper extends AbstractMapper {

    @Autowired
    InnerParagraphFacade innerParagraphFacade;

    public InnerParagraph set(ParagraphValidator paragraphValidator, User user) {
        return innerParagraphFacade.newInstance(paragraphValidator.getTitle(), paragraphValidator.getContent(), user);
    }

    public InnerParagraph set(ParagraphUpdateValidator paragraphUpdateValidator, int version, User user) {
        return innerParagraphFacade.newInstance(paragraphUpdateValidator.getTitle(), paragraphUpdateValidator.getContent(), version, user);
    }

}
