package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerTag;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class InnerTagFacade extends AbstractFacade<InnerTag> {

    public InnerTag newInstance(String name, String content, User user) {
        InnerTag res = super.newInstance();
        res.setUser(user);
        res.setContent(content);
        res.setName(name);
        res.setVersion(0);
        res.setEnumState(EnumState.DRAFT);
        return res;
    }

    // Init
    public InnerTag init(String name, String content) {
        InnerTag res = super.newInstance();
        res.setUser(userRepository.findById(1).get());
        res.setContent(content);
        res.setName(name);
        res.setVersion(0);
        res.setEnumState(EnumState.VALIDATED);
        return res;
    }

    public InnerTag newInstance(String name, String content, int version, User user) {
        InnerTag res = super.newInstance();
        res.setUser(user);
        res.setContent(content);
        res.setName(name);
        res.setVersion(version);
        res.setEnumState(EnumState.DRAFT);
        return res;
    }

}
