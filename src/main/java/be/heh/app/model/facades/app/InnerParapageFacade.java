package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerParapage;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class InnerParapageFacade extends AbstractFacade<InnerParapage> {

    public InnerParapage newInstance(User user) {
        InnerParapage res = super.newInstance();
        res.setUser(user);
        res.setVersion(0);
        res.setEnumState(EnumState.DRAFT);
        return res;
    }

    public InnerParapage newInstance(String title, String content, int version, User user) {
        InnerParapage res = super.newInstance();
        res.setUser(user);
        res.setContent(content);
        res.setTitle(title);
        res.setVersion(version);
        res.setEnumState(EnumState.DRAFT);
        return res;
    }

    // Init
    public InnerParapage init(String title, String content) {
        InnerParapage res = super.newInstance();
        res.setUser(userRepository.findById(this.userId).get());
        res.setContent(content);
        res.setTitle(title);
        res.setVersion(0);
        res.setEnumState(EnumState.VALIDATED);
        return res;
    }

}
