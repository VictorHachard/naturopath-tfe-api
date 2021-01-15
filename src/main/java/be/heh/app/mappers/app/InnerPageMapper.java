package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.PageValidator;
import be.heh.app.controller.validators.app.update.PageUpdateValidator;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.InnerPage;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.facades.app.InnerPageFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class InnerPageMapper extends AbstractMapper {

    @Autowired
    InnerPageFacade innerPageFacade;

    public InnerPage set(PageValidator pageValidator, User user) {
        return innerPageFacade.newInstance(pageValidator.getTitle(), pageValidator.getDescription(), user);
    }

    public InnerPage set(PageUpdateValidator pageUpdateValidator, int version, User user) {
        return innerPageFacade.newInstance(pageUpdateValidator.getTitle(), pageUpdateValidator.getDescription(), version, user);
    }

}
