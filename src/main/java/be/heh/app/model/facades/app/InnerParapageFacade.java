package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerParapage;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.app.InnerParapageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InnerParapageFacade extends AbstractFacade<InnerParapage> {

    @Autowired
    InnerParapageRepository innerParapageRepository;


}
