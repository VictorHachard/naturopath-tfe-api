package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerParagraph;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class InnerParagraphFacade extends AbstractFacade<InnerParagraph> {

    public InnerParagraph newInstance( User user) {
        InnerParagraph res = super.newInstance();
        res.setUser(user);
        res.setVersion(0);
        res.setEnumState(EnumState.DRAFT);
        return res;
    }

    public InnerParagraph newInstance(String title, String content, User user) {
        InnerParagraph res = super.newInstance();
        res.setUser(user);
        res.setContent(content);
        res.setTitle(title);
        res.setVersion(0);
        res.setEnumState(EnumState.DRAFT);
        return res;
    }

    public InnerParagraph newInstance(String title, String content, int version, User user) {
        InnerParagraph res = super.newInstance();
        res.setUser(user);
        res.setContent(content);
        res.setTitle(title);
        res.setVersion(version);
        res.setEnumState(EnumState.DRAFT);
        return res;
    }

    public InnerParagraph init(String title, String content) {
        InnerParagraph res = super.newInstance();
        res.setUser(userRepository.findById(1).get());
        res.setContent(content);
        res.setTitle(title);
        res.setVersion(0);
        res.setEnumState(EnumState.VALIDATED);
        return res;
    }

}
