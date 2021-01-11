package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerTag;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.InnerTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InnerTagFacade extends AbstractFacade<InnerTag> {

    @Autowired
    InnerTagRepository innerTagRepository;

    @Override
    public InnerTag newInstance() {
        return innerTagRepository.newInstance();
    }

}
