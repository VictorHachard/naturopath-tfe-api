package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerParatag;
import be.heh.app.model.entities.app.Paratag;
import be.heh.app.model.entities.app.ParatagType;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.app.ParatagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParatagFacade extends AbstractFacade<Paratag> {

    @Autowired
    ParatagRepository paratagRepository;

    public Paratag newInstance(InnerParatag innerParatag, ParatagType paratagType, User user) {
        Paratag paratag = new Paratag();
        paratag.addInnerParatag(innerParatag);
        paratag.setParatagType(paratagType);
        paratag.setUser(user);
        return paratag;
    }

    public InnerParatag getLastNonDraft(Paratag paratag) {
        InnerParatag innerParatag = null;
        for (InnerParatag innerParatag1 : paratag.getInnerParatagList()) {
            if (innerParatag1.getEnumState() == EnumState.VALIDATED) {
                innerParatag = innerParatag1;
            }
        }
        return innerParatag;
    }

}
