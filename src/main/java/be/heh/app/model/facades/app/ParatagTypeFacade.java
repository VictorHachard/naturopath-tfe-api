package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.ParagraphType;
import be.heh.app.model.entities.app.ParatagType;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.app.ParatagTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParatagTypeFacade extends AbstractFacade<ParatagType> {

    @Autowired
    ParatagTypeRepository paratagTypeRepository;

    public ParatagType newInstance(String name, String description) {
        ParatagType paratagType = new ParatagType();
        paratagType.setName(name);
        paratagType.setDescription(description);
        return paratagType;
    }

}
