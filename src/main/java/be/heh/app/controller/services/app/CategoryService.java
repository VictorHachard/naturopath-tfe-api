package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.CategoryValidator;
import be.heh.app.controller.validators.app.update.CategoryUpdateValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.controller.validators.commons.Pair;
import be.heh.app.dto.edit.CategoryEditDto;
import be.heh.app.dto.view.CategoryViewDto;
import be.heh.app.model.entities.app.Category;
import be.heh.app.model.entities.app.ParagraphType;
import be.heh.app.model.entities.app.ParatagType;
import be.heh.app.model.entities.app.SortedType;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class CategoryService extends AbstractService<Category> {

    public List<CategoryViewDto> getAllParentDto() {
        List<Category> categoryList = categoryRepository.findAllParent();
        if (categoryList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no " + this.getClass().getSimpleName() + " in the database");
        }
        return categoryMapper.getAllView(categoryList);
    }

    public List<CategoryViewDto> getAllDto() {
        List<CategoryViewDto> categoryDtoList = new ArrayList<>();
        List<Category> categoryList = categoryRepository.findAllExceptChild();
        if (categoryList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no " + this.getClass().getSimpleName() + " in the database");
        }
        categoryList.forEach(category -> {
            CategoryViewDto categoryDto = getRecursive(category);
            categoryDtoList.add(categoryDto);

        });
        return categoryDtoList;
    }

    public CategoryViewDto getDto(int id) {
        return getRecursive(super.get(id));
    }

    public List<CategoryEditDto> getAllEditDto() {
        List<CategoryEditDto> categoryDtoList = new ArrayList<>();
        List<Category> categoryList = categoryRepository.findAllExceptChild();
        if (categoryList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no " + this.getClass().getSimpleName() + " in the database");
        }
        categoryList.forEach(category -> {
            CategoryEditDto categoryDto = getRecursiveEdit(category);
            categoryDtoList.add(categoryDto);
        });
        Collections.sort(categoryDtoList);
        return categoryDtoList;
    }

    public CategoryEditDto getEditDto(int id) {
        return getRecursiveEdit(super.get(id));
    }

    private CategoryViewDto getRecursive(Category category) {
        CategoryViewDto categoryDto = categoryMapper.getView(category);
        List<Category> children = categoryRepository.findChild(category);
        categoryDto.setChildCategory(new ArrayList<>());
        if (!children.isEmpty()) {
            children.forEach(children1 -> {
                CategoryViewDto CategoryDtoChild = getRecursive(children1);
                categoryDto.getChildCategory().add(CategoryDtoChild);
            });
        }
        return categoryDto;
    }

    private CategoryEditDto getRecursiveEdit(Category category) {
        CategoryEditDto categoryDto = categoryMapper.getEdit(category);
        List<Category> children = categoryRepository.findChild(category);
        categoryDto.setChildCategory(new ArrayList<>());
        if (!children.isEmpty()) {
            children.forEach(children1 -> {
                CategoryEditDto CategoryDtoChild = getRecursiveEdit(children1);
                categoryDto.getChildCategory().add(CategoryDtoChild);
            });
        }
        return categoryDto;
    }

    public int addC(AbstractValidator abstractValidator) {
        CategoryValidator validator = (CategoryValidator) abstractValidator;
        if (validator.getParentCategoryId() != null && categoryRepository.findById(validator.getParentCategoryId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no " + categoryRepository.getClass().getSimpleName().replace("Repository", "") + " with this categoryId");
        }
        Category category = categoryMapper.set(validator, validator.getParentCategoryId() != null ? categoryRepository.findById(validator.getParentCategoryId()).get() : null);
        categoryRepository.save(category);
        return category.getId();
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        super.update(abstractValidator, id);
        CategoryUpdateValidator validator = (CategoryUpdateValidator) abstractValidator;
        /*if (categoryRepository.findById(validator.getParentCategoryId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else if (paragraphTypeRepository.findAllById(validator.getParagraphTypeIdList()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else if (parapageTypeRepository.findAllById(validator.getParapageTypeIdList()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else if (paratagTypeRepository.findAllById(validator.getParatagTypeIdList()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        }*/

        Category category = categoryRepository.findById(id).get();

        category.clearSortedType();

        List<Integer> paragraphTypeIdList = new ArrayList<>();
        List<Integer> paratagTypeIdList = new ArrayList<>();

        int index = 1;
        SortedType st;
        for (Pair p: validator.getSortedTypeList()) {
            switch (p.getType()) {
                case "ParatagType":
                    paratagTypeIdList.add(p.getId());
                    st = sortedTypeFacade.newInstance(paratagTypeRepository.findById(p.getId()).get(), index);
                    category.addType(st);
                    sortedTypeRepository.save(st);
                    break;
                case "ParagraphType":
                    paragraphTypeIdList.add(p.getId());
                    st = sortedTypeFacade.newInstance(paragraphTypeRepository.findById(p.getId()).get(), index);
                    category.addType(st);
                    sortedTypeRepository.save(st);
                    break;
            }
            index++;
        }

        /*List<ParagraphType> paragraphTypeList = paragraphTypeRepository.findAllById(paragraphTypeIdList);
        List<ParatagType> paratagTypeList = paratagTypeRepository.findAllById(paratagTypeIdList);

        for (Pair p: validator.getSortedTypeList()) {
            switch (p.getType()) {
                case "ParatagType":
                    sortedTypeFacade.newInstance();
                    break;
                case "ParagraphType":
                    sortedTypeFacade.newInstance();
                    break;
            }
        }*/

        categoryMapper.update(
                category,
                validator,
                validator.getParentCategoryId() != null ? categoryRepository.findById(validator.getParentCategoryId()).get() : null);

        categoryRepository.save(category);
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
