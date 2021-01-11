package be.heh.app.mappers;

import be.heh.app.controller.validators.PageValidator;
import be.heh.app.model.entities.app.InnerPage;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.facades.app.InnerPageFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class InnerPageMapper {

    @Autowired
    static InnerPageFacade innerPageFacade;

    public static InnerPage map(PageValidator pageValidator, User user) {
        return innerPageFacade.newInstance(pageValidator.getTitle(), pageValidator.getDescription(), user);
    }

}
