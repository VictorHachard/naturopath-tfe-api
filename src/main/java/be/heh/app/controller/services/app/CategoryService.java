package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.CategoryValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.dto.CategoryDto;
import be.heh.app.model.entities.app.Category;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class CategoryService extends AbstractService<Category> {

    public List<CategoryDto> getAllDto() {
        return categoryMapper.getAll(super.getAll());
    }

    public CategoryDto getDto(int id) {
        return categoryMapper.get(super.get(id));
    }

    @Override
    public void add(AbstractValidator abstractValidator) {
        categoryRepository.save(categoryMapper.map((CategoryValidator) abstractValidator));
    }

    @Override
    public void delete(int id) {
        //TODO delete link
        if (categoryRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else {
            categoryRepository.deleteById(id);
        }
    }

}
