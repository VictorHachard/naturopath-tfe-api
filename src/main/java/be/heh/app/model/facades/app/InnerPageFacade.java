package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerPage;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class InnerPageFacade extends AbstractFacade<InnerPage> {

    public InnerPage newInstance(String title, String description, User user) {
        InnerPage innerPage = new InnerPage();
        innerPage.setUser(user);
        innerPage.setDescription(description);
        innerPage.setTitle(title);
        innerPage.setVersion(0);
        innerPage.setEnumState(EnumState.DRAFT);
        return innerPage;
    }

    public InnerPage newInstance(String title, String description, int version, User user) {
        InnerPage innerPage = new InnerPage();
        innerPage.setUser(user);
        innerPage.setDescription(description);
        innerPage.setTitle(title);
        innerPage.setVersion(version);
        innerPage.setEnumState(EnumState.DRAFT);
        return innerPage;
    }

    // Init
    public InnerPage init(String title, String description) {
        InnerPage innerPage = new InnerPage();
        innerPage.setUser(userRepository.findById(0).get());
        innerPage.setDescription(description);
        innerPage.setTitle(title);
        innerPage.setVersion(0);
        innerPage.setEnumState(EnumState.VALIDATED);
        return innerPage;
    }

}
