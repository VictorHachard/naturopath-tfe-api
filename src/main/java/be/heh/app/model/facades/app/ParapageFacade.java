package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerParapage;
import be.heh.app.model.entities.app.Parapage;
import be.heh.app.model.entities.app.ParapageType;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class ParapageFacade extends AbstractFacade<Parapage> {

    public Parapage newInstance(InnerParapage innerParapage, ParapageType parapageType, User user) {
        Parapage res = super.newInstance();
        res.addInnerParapage(innerParapage);
        res.setParapageType(parapageType);
        res.setUser(user);
        return res;
    }

    // Init
    public Parapage init(InnerParapage innerParapage, ParapageType parapageType) {
        Parapage res = super.newInstance();
        res.addInnerParapage(innerParapage);
        res.setParapageType(parapageType);
        res.setUser(userRepository.findById(1).get());
        return res;
    }

}
