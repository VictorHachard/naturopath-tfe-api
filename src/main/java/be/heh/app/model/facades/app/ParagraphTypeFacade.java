package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.ParagraphType;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class ParagraphTypeFacade extends AbstractFacade<ParagraphType> {

    public ParagraphType newInstance(String name, String description) {
        ParagraphType res = super.newInstance();
        res.setName(name);
        res.setDescription(description);
        return res;
    }

}
