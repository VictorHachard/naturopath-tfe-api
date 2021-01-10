package be.heh.app.mapper;

import be.heh.app.controller.validators.CategoryValidator;
import be.heh.app.model.entities.app.Category;

public final class CategoryMapper {

    public static Category map(CategoryValidator categoryValidator) {
        Category category = new Category();
        category.setName(categoryValidator.getName());
        category.setDescription(categoryValidator.getDescription());
        category.setLang(categoryValidator.getLang());
        return category;
    }

}
