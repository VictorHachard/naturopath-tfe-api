package be.heh.app.mapper;

import be.heh.app.controller.validators.ParagraphValidator;
import be.heh.app.model.entities.app.Page;
import be.heh.app.model.entities.app.Paragraph;
import be.heh.app.model.entities.app.ParagraphType;
import be.heh.app.model.entities.app.User;

public final class ParagraphMapper {

    public static Paragraph map(ParagraphValidator paragraphValidator, Page page, ParagraphType paragraphType, User user) {
        Paragraph paragraph = new Paragraph();
        paragraph.setTitle(paragraphValidator.getTitle());
        paragraph.setContent(paragraphValidator.getContent());
        paragraph.setParagraphType(paragraphType);
        paragraph.setUser(user);
        return paragraph;
    }

}
