package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.ParapageType;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class ParapageTypeFacade extends AbstractFacade<ParapageType> {

    public ParapageType newInstance(String name, String description, boolean alert) {
        ParapageType res = super.newInstance();
        res.setName(name);
        res.setAlert(alert);
        res.setDescription(description);
        return res;
    }

}
