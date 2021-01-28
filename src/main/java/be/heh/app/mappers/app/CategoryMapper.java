package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.CategoryValidator;
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

import java.util.List;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class CategoryMapper extends AbstractMapper {

    //TODO
    public Category set(CategoryValidator categoryValidator, Category parentCategory, List<ParagraphType> paragraphTypeList, List<ParapageType> parapageTypeList, List<ParatagType> paratagTypeList) {
        /*Category category = categoryFacade.newInstance(
                categoryValidator.getName(),
                categoryValidator.getDescription(),
                parentCategory,
                paragraphTypeList,
                parapageTypeList,
                paratagTypeList);
        return category;*/
        return null;
    }

    public Category set(CategoryValidator categoryValidator, Category parentCategory) {
        return categoryFacade.newInstance(
                categoryValidator.getName(),
                categoryValidator.getDescription(),
                parentCategory);
    }

    public void update(Category category, CategoryValidator categoryValidator, Category parentCategory, List<ParagraphType> paragraphTypeList, List<ParapageType> parapageTypeList, List<ParatagType> paratagTypeList) {
        /*categoryFacade.updateInstance(
                category,
                categoryValidator.getName(),
                categoryValidator.getDescription(),
                parentCategory,
                paragraphTypeList,
                parapageTypeList,
                paratagTypeList
        );*/
    }

    public CategoryViewDto getView(Category category) {
        return new CategoryViewDto(
                category.getId(),
                category.getName(),
                category.getDescription(),
                null);
    }

    public CategoryEditDto getEdit(Category category) {
        return null; //TODO
    }

}
