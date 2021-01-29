package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.CategoryValidator;
import be.heh.app.controller.validators.app.update.CategoryUpdateValidator;
import be.heh.app.dto.edit.CategoryEditDto;
import be.heh.app.dto.view.CategoryViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.Category;
import be.heh.app.model.entities.app.ParagraphType;
import be.heh.app.model.entities.app.ParapageType;
import be.heh.app.model.entities.app.ParatagType;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class CategoryMapper extends AbstractMapper {

    public Category set(CategoryValidator validator, Category parentCategory) {
        return categoryFacade.newInstance(
                validator.getName(),
                validator.getDescription(),
                parentCategory,
                validator.getIsParent());
    }

    public void update(Category category, CategoryUpdateValidator validator, Category parentCategory, List<ParagraphType> paragraphTypeList, List<ParapageType> parapageTypeList, List<ParatagType> paratagTypeList) {
        /*categoryFacade.updateInstance(
                category,
                validator.getName(),
                validator.getDescription(),
                parentCategory,
                paragraphTypeList,
                parapageTypeList,
                paratagTypeList
        );*/
    }

    public List<CategoryViewDto> getAllView(List<Category> j) {
        List<CategoryViewDto> res = new ArrayList<>();
        j.forEach(i -> {
            res.add(this.getView(i));
        });
        Collections.sort(res);
        return res;
    }

    public CategoryViewDto getView(Category category) {
        return new CategoryViewDto(
                category.getId(),
                category.getName(),
                category.getDescription(),
                null);
    }

    public CategoryEditDto getEdit(Category category) {
        return new CategoryEditDto(
                category.getId(),
                category.getName(),
                category.getDescription(),
                null,
                sortedTypeMapper.getAllView(category.getSortedTypeList()));
    }

}
