package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.SortedType;
import be.heh.app.model.entities.commons.AbstractType;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class SortedTypeFacade extends AbstractFacade<SortedType> {

    public SortedType newInstance(AbstractType abstractType, int order) {
        SortedType res = super.newInstance();
        res.setOrder(order);
        res.setAbstractType(abstractType);
        return res;
    }

}
