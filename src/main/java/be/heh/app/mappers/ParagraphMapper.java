package be.heh.app.mappers;

import be.heh.app.model.entities.app.InnerParagraph;
import be.heh.app.model.entities.app.Paragraph;
import be.heh.app.model.entities.app.ParagraphType;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.facades.app.ParagraphFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class ParagraphMapper {

    @Autowired
    static ParagraphFacade paragraphFacade;

    public static Paragraph map(InnerParagraph innerParagraph, ParagraphType paragraphType, User user) {
        return paragraphFacade.newInstance(innerParagraph, paragraphType, user);
    }

}
