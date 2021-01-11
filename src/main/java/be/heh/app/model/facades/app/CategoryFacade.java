package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.Category;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.app.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryFacade extends AbstractFacade<Category> {

    @Autowired
    CategoryRepository categoryRepository;

    public Category newInstance(String name, String description, String lang) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        category.setLang(lang);
        return category;
    }

    public Category newInstance(String name, String description) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        category.setLang("EN");
        return category;
    }

}
