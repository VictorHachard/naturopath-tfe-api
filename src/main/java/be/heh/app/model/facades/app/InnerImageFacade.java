package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerImage;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class InnerImageFacade extends AbstractFacade<InnerImage> {

    // Init
    public InnerImage init(String title, String description, String url) {
        InnerImage res = super.newInstance();
        res.setUser(userRepository.findById(this.userId).get());
        res.setDescription(description);
        res.setUrl(url);
        res.setTitle(title);
        res.setVersion(0);
        res.setEnumState(EnumState.VALIDATED);
        return res;
    }

    public InnerImage newInstance(String title, String description, String url, int version, User user) {
        InnerImage res = super.newInstance();
        res.setUser(user);
        res.setDescription(description);
        res.setTitle(title);
        res.setUrl(url);
        res.setVersion(version);
        res.setEnumState(EnumState.DRAFT);
        return res;
    }

}
