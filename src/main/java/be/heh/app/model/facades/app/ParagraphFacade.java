package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerParagraph;
import be.heh.app.model.entities.app.Paragraph;
import be.heh.app.model.entities.app.ParagraphType;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class ParagraphFacade extends AbstractFacade<Paragraph> {

    public Paragraph newInstance(InnerParagraph innerParagraph, ParagraphType paragraphType, User user) {
        Paragraph res = super.newInstance();
        res.addInnerParagraph(innerParagraph);
        res.setParagraphType(paragraphType);
        res.setUser(user);
        return res;
    }

    // Init
    public Paragraph init(InnerParagraph innerParagraph, ParagraphType paragraphType) {
        Paragraph res = super.newInstance();
        res.addInnerParagraph(innerParagraph);
        res.setParagraphType(paragraphType);
        res.setUser(userRepository.findById(this.userId).get());
        return res;
    }

}
