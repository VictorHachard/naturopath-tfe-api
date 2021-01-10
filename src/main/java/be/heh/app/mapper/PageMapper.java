package be.heh.app.mapper;

import be.heh.app.controller.validators.PageValidator;
import be.heh.app.model.entities.app.Page;

public final class PageMapper {

    public static Page map(PageValidator pageValidator) {
        Page page = new Page();
        page.setName(pageValidator.getName());
        page.setDescription(pageValidator.getDescription());
        page.setUser(pageValidator.getUser());
        page.setCategory(pageValidator.getCategory());
        return page;
    }

}
