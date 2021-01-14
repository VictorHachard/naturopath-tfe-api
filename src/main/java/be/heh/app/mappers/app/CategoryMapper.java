package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.CategoryValidator;
import be.heh.app.dto.CategoryDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.Category;
import be.heh.app.model.facades.app.CategoryFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class CategoryMapper extends AbstractMapper {

    @Autowired
    CategoryFacade categoryFacade;

    public Category map(CategoryValidator categoryValidator) {
        return categoryFacade.newInstance(categoryValidator.getName(),
                categoryValidator.getDescription(),
                categoryValidator.getLang());
    }

    public List<CategoryDto> getAll(List<Category> categoryList) {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        categoryList.forEach(category -> {
            categoryDtoList.add(this.get(category));
        });
        return categoryDtoList;
    }

    public CategoryDto get(Category category) {
        return new CategoryDto(category.getId(),
                category.getCreatedAt(),
                category.getName(),
                category.getDescription(),
                category.isParent(),
                null);
    }

}
