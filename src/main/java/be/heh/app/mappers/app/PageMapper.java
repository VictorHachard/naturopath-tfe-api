package be.heh.app.mappers.app;

import be.heh.app.model.entities.app.Category;
import be.heh.app.model.entities.app.InnerPage;
import be.heh.app.model.entities.app.Page;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.facades.app.PageFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class PageMapper {

    @Autowired
    PageFacade pageFacade;

    public Page map(InnerPage innerPage, Category category, User user) {
        return pageFacade.newInstance(innerPage, user, category);
    }

}
