package be.heh.app.mapper;

import be.heh.app.controller.validators.PageValidator;
import be.heh.app.model.entities.app.Category;
import be.heh.app.model.entities.app.Page;
import be.heh.app.model.entities.app.User;

public final class PageMapper {

    public static Page map(PageValidator pageValidator, Category category, User user) {
        Page page = new Page();
        page.setName(pageValidator.getName());
        page.setDescription(pageValidator.getDescription());
        page.setUser(user);
        page.setCategory(category);
        return page;
    }

}
