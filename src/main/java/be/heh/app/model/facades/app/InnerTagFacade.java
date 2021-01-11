package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerParagraph;
import be.heh.app.model.entities.app.InnerTag;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.InnerTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InnerTagFacade extends AbstractFacade<InnerTag> {

    @Autowired
    InnerTagRepository innerTagRepository;

    public InnerTag newInstance(String name, String content, User user) {
        InnerTag innerTag = new InnerTag();
        innerTag.setUser(user);
        innerTag.setContent(content);
        innerTag.setName(name);
        innerTag.setVersion(0);
        return innerTag;
    }

}
