package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.Image;
import be.heh.app.model.entities.app.InnerImage;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class ImageFacade extends AbstractFacade<Image> {

    public Image newInstance(InnerImage innerImage, User user) {
        Image res = super.newInstance();
        res.addInnerImage(innerImage);
        res.setUser(user);
        return res;
    }

}
