package be.heh.app.mappers;

import be.heh.app.controller.validators.CategoryValidator;
import be.heh.app.model.entities.app.Category;
import be.heh.app.model.facades.app.CategoryFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class CategoryMapper {

    @Autowired
    static CategoryFacade categoryFacade;

    public static Category map(CategoryValidator categoryValidator) {
        return categoryFacade.newInstance(categoryValidator.getName(), categoryValidator.getDescription(), categoryValidator.getLang());
    }

}
