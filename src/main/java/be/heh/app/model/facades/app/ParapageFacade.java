package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerParapage;
import be.heh.app.model.entities.app.Parapage;
import be.heh.app.model.entities.app.ParapageType;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.app.ParapageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParapageFacade extends AbstractFacade<Parapage> {

    @Autowired
    ParapageRepository parapageRepository;

    public Parapage newInstance(InnerParapage innerParapage, ParapageType parapageType, User user) {
        Parapage parapage = new Parapage();
        parapage.addInnerParapage(innerParapage);
        parapage.setParapageType(parapageType);
        parapage.setUser(user);
        return parapage;
    }

}
