package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.Category;
import be.heh.app.model.entities.app.InnerPage;
import be.heh.app.model.entities.app.Page;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.app.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PageFacade extends AbstractFacade<Page> {

    @Autowired
    PageRepository pageRepository;

    public Page newInstance(InnerPage innerPage, User user, Category category) {
        Page page = new Page();
        page.addInnerPage(innerPage);
        page.setUser(user);
        page.setCategory(category);
        return page;
    }

}
