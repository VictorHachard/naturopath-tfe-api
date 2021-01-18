package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.Image;
import be.heh.app.model.entities.app.InnerImage;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class ImageFacade extends AbstractFacade<Image> {

    public Image newInstance(InnerImage innerImage, User user) {
        Image image = new Image();
        image.addInnerImage(innerImage);
        image.setUser(user);
        return image;
    }

    public InnerImage getLastNonDraft(Image image) {
        InnerImage innerImage = null;
        for (InnerImage innerImage1 : image.getInnerImageList()) {
            if (innerImage1.getEnumState() == EnumState.VALIDATED) {
                innerImage = innerImage1;
            }
        }
        return innerImage;
    }

}
