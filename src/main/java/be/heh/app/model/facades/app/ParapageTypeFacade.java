package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.ParagraphType;
import be.heh.app.model.entities.app.ParapageType;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.app.ParapageTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParapageTypeFacade extends AbstractFacade<ParapageType> {

    @Autowired
    ParapageTypeRepository parapageTypeRepository;

    public ParapageType newInstance(String name, String description) {
        ParapageType parapageType = new ParapageType();
        parapageType.setName(name);
        parapageType.setDescription(description);
        return parapageType;
    }

}
