package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerParagraph;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class InnerParagraphFacade extends AbstractFacade<InnerParagraph> {

    public InnerParagraph newInstance(String title, String content, User user) {
        InnerParagraph innerParagraph = new InnerParagraph();
        innerParagraph.setUser(user);
        innerParagraph.setContent(content);
        innerParagraph.setTitle(title);
        innerParagraph.setVersion(0);
        innerParagraph.setEnumState(EnumState.DRAFT);
        return innerParagraph;
    }

    public InnerParagraph newInstance(String title, String content, int version, User user) {
        InnerParagraph innerParagraph = new InnerParagraph();
        innerParagraph.setUser(user);
        innerParagraph.setContent(content);
        innerParagraph.setTitle(title);
        innerParagraph.setVersion(version);
        innerParagraph.setEnumState(EnumState.DRAFT);
        return innerParagraph;
    }

    public InnerParagraph init(String title, String content) {
        InnerParagraph innerParagraph = new InnerParagraph();
        innerParagraph.setUser(userRepository.findById(1).get());
        innerParagraph.setContent(content);
        innerParagraph.setTitle(title);
        innerParagraph.setVersion(0);
        innerParagraph.setEnumState(EnumState.VALIDATED);
        return innerParagraph;
    }

}
