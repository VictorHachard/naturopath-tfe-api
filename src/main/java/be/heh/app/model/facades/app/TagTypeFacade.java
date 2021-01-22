package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.TagType;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class TagTypeFacade extends AbstractFacade<TagType> {

    public TagType newInstance(String name, String description) {
        TagType res = super.newInstance();
        res.setName(name);
        res.setDescription(description);
        return res;
    }

}
