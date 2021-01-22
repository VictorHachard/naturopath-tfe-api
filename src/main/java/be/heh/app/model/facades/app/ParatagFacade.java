package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerParatag;
import be.heh.app.model.entities.app.Paratag;
import be.heh.app.model.entities.app.ParatagType;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.enumeration.EnumSize;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class ParatagFacade extends AbstractFacade<Paratag> {

    public Paratag newInstance(InnerParatag innerParatag, ParatagType paratagType, User user, EnumSize enumSize) {
        Paratag res = super.newInstance();
        res.addInnerParatag(innerParatag);
        res.setParatagType(paratagType);
        res.setUser(user);
        res.setEnumSize(enumSize);
        return res;
    }

    // Init
    public Paratag init(InnerParatag innerParatag, ParatagType paratagType, EnumSize enumSize) {
        Paratag res = super.newInstance();
        res.addInnerParatag(innerParatag);
        res.setParatagType(paratagType);
        res.setUser(userRepository.findById(1).get());
        res.setEnumSize(enumSize);
        return res;
    }

}
