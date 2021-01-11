package be.heh.app.controller.services.security;

import be.heh.app.controller.services.commons.AbstractSecurityService;
import be.heh.app.controller.validators.CategoryValidator;
import be.heh.app.model.entities.app.Category;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class UserService extends AbstractSecurityService {

    public List<Category> getAllCategory() {
        if (categoryRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category in the database");
        } else {
            return categoryRepository.findAll();
        }
    }

    public Category getCategory(int id) {
        if (categoryRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else {
            return categoryRepository.findById(id).get();
        }
    }

    public Category insertCategory(CategoryValidator categoryValidator) {
        Category category = categoryMapper.map(categoryValidator);
        categoryRepository.save(category);
        return category;
    }

    public Category deleteCategory(int id) {
        //TODO delete link
        if (categoryRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else {
            Category category = categoryRepository.findById(id).get();
            categoryRepository.delete(category);
            return category;
        }
    }

}
