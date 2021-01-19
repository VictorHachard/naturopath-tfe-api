package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerTag;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class InnerTagFacade extends AbstractFacade<InnerTag> {

    public InnerTag newInstance(String name, String content, User user) {
        InnerTag innerTag = new InnerTag();
        innerTag.setUser(user);
        innerTag.setContent(content);
        innerTag.setName(name);
        innerTag.setVersion(0);
        innerTag.setEnumState(EnumState.DRAFT);
        return innerTag;
    }

    // Init
    public InnerTag init(String name, String content) {
        InnerTag innerTag = new InnerTag();
        innerTag.setUser(userRepository.findById(1).get());
        innerTag.setContent(content);
        innerTag.setName(name);
        innerTag.setVersion(0);
        innerTag.setEnumState(EnumState.VALIDATED);
        return innerTag;
    }

    public InnerTag newInstance(String name, String content, int version, User user) {
        InnerTag innerTag = new InnerTag();
        innerTag.setUser(user);
        innerTag.setContent(content);
        innerTag.setName(name);
        innerTag.setVersion(version);
        innerTag.setEnumState(EnumState.DRAFT);
        return innerTag;
    }

}
