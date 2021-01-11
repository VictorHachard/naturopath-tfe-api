package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerPage;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.InnerPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InnerPageFacade extends AbstractFacade<InnerPage> {

    @Autowired
    InnerPageRepository innerPageRepository;

    public InnerPage newInstance(String title, String description, User user) {
        InnerPage innerPage = new InnerPage();
        innerPage.setUser(user);
        innerPage.setDescription(description);
        innerPage.setTitle(title);
        innerPage.setVersion(0);
        return innerPage;
    }

}