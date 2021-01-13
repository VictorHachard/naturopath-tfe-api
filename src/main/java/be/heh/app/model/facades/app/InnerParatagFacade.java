package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerParatag;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.app.InnerParatagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InnerParatagFacade extends AbstractFacade<InnerParatag> {

    @Autowired
    InnerParatagRepository innerParatagRepository;

}