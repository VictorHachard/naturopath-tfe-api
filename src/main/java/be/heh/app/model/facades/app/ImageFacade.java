package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.Image;
import be.heh.app.model.entities.app.InnerImage;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class ImageFacade extends AbstractFacade<Image> {

    public Image init(InnerImage innerImage) {
        Image res = super.newInstance();
        res.add(innerImage);
        res.setUser(userRepository.findById(this.userId).get());
        return res;
    }

    public Image newInstance(InnerImage innerImage, User user) {
        Image res = super.newInstance();
        res.add(innerImage);
        res.setUser(user);
        return res;
    }

}
