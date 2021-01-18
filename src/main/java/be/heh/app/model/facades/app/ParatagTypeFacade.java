package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.ParatagType;
import be.heh.app.model.entities.app.TagType;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class ParatagTypeFacade extends AbstractFacade<ParatagType> {

    public ParatagType newInstance(String name, String description, TagType tagType) {
        ParatagType paratagType = new ParatagType();
        paratagType.setName(name);
        paratagType.setDescription(description);
        paratagType.setTagType(tagType);
        return paratagType;
    }

}
