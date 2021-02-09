package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerImage;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class InnerImageFacade extends AbstractFacade<InnerImage> {

    public InnerImage newInstance(User user) {
        InnerImage res = super.newInstance();
        res.setUser(user);
        res.setVersion(0);
        res.setEnumState(EnumState.DRAFT);
        return res;
    }

    public InnerImage newInstance(String title, String description, String url, User user) {
        InnerImage res = super.newInstance();
        res.setUser(user);
        res.setDescription(description);
        res.setUrl(url);
        res.setTitle(title);
        res.setVersion(0);
        res.setEnumState(EnumState.DRAFT);
        return res;
    }

}
