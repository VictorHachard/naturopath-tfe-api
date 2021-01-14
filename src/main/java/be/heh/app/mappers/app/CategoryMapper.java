package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.CategoryValidator;
import be.heh.app.dto.CategoryDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.*;
import be.heh.app.model.facades.app.CategoryFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class CategoryMapper extends AbstractMapper {

    @Autowired
    CategoryFacade categoryFacade;

    public Category set(Category category, CategoryValidator categoryValidator, Category category1, List<ParagraphType> paragraphTypeList, List<TagType> tagTypeList, List<ParapageType> parapageTypeList, List<ParatagType> paratagTypeList) {
        category = categoryFacade.newInstance(categoryValidator.getName(),
                categoryValidator.getDescription(),
                category1,
                paragraphTypeList,
                tagTypeList,
                parapageTypeList,
                paratagTypeList);
        return category;
    }

    public Category set(CategoryValidator categoryValidator, Category category1, List<ParagraphType> paragraphTypeList, List<TagType> tagTypeList, List<ParapageType> parapageTypeList, List<ParatagType> paratagTypeList) {
        return this.set(new Category(),
                categoryValidator,
                category1,
                paragraphTypeList,
                tagTypeList,
                parapageTypeList,
                paratagTypeList);
    }

    public CategoryDto get(Category category) {
        return new CategoryDto(category.getId(),
                category.getName(),
                category.getDescription(),
                null);
    }

}
