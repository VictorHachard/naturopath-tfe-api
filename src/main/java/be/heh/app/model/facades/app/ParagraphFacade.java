package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerParagraph;
import be.heh.app.model.entities.app.Paragraph;
import be.heh.app.model.entities.app.ParagraphType;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.app.ParagraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParagraphFacade extends AbstractFacade<Paragraph> {

    @Autowired
    ParagraphRepository paragraphRepository;

    public Paragraph newInstance(InnerParagraph innerParagraph, ParagraphType paragraphType, User user) {
        Paragraph paragraph = new Paragraph();
        paragraph.addInnerParagraph(innerParagraph);
        paragraph.setParagraphType(paragraphType);
        paragraph.setUser(user);
        return paragraph;
    }

    public InnerParagraph getLastNonDraft(Paragraph paragraph) {
        InnerParagraph innerParagraph = null;
        for (InnerParagraph innerParagraph1 : paragraph.getInnerParagraphList()) {
            if (innerParagraph1.getEnumState() == EnumState.VALIDATED) {
                innerParagraph = innerParagraph1;
            }
        }
        return innerParagraph;
    }

}
