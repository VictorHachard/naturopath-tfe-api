package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.Image;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.app.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImageFacade extends AbstractFacade<Image> {

    @Autowired
    ImageRepository imageRepository;

}
