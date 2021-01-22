package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerPage;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class InnerPageFacade extends AbstractFacade<InnerPage> {

    public InnerPage newInstance(String title, String description, User user) {
        InnerPage res = super.newInstance();
        res.setUser(user);
        res.setDescription(description);
        res.setTitle(title);
        res.setVersion(0);
        res.setEnumState(EnumState.DRAFT);
        return res;
    }

    public InnerPage newInstance(String title, String description, int version, User user) {
        InnerPage res = super.newInstance();
        res.setUser(user);
        res.setDescription(description);
        res.setTitle(title);
        res.setVersion(version);
        res.setEnumState(EnumState.DRAFT);
        return res;
    }

    // Init
    public InnerPage init(String title, String description) {
        InnerPage res = super.newInstance();
        res.setUser(userRepository.findById(1).get());
        res.setDescription(description);
        res.setTitle(title);
        res.setVersion(0);
        res.setEnumState(EnumState.VALIDATED);
        return res;
    }

}
