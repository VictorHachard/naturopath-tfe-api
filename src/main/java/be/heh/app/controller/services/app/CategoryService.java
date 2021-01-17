package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.CategoryValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.dto.edit.CategoryEditDto;
import be.heh.app.dto.view.CategoryViewDto;
import be.heh.app.model.entities.app.Category;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class CategoryService extends AbstractService<Category> {

    public List<CategoryViewDto> getAllDto() {
        List<CategoryViewDto> categoryDtoList = new ArrayList<>();
        categoryRepository.findAllParent().forEach(category -> {
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
        categoryRepository.findAllParent().forEach(category -> {
            CategoryEditDto categoryDto = getRecursiveEdit(category);
            categoryDtoList.add(categoryDto);
        });
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
        categoryDto.setCategoryEditDto(new ArrayList<>());
        if (!children.isEmpty()) {
            children.forEach(children1 -> {
                CategoryEditDto CategoryDtoChild = getRecursiveEdit(children1);
                categoryDto.getCategoryEditDto().add(CategoryDtoChild);
            });
        }
        return categoryDto;
    }

    @Override
    public void add(AbstractValidator abstractValidator) {
        CategoryValidator validator = (CategoryValidator) abstractValidator;
        if (validator.getCategoryId() != null && categoryRepository.findById(validator.getCategoryId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else if (validator.getParagraphTypeIdList() != null && paragraphTypeRepository.findAllById(validator.getParagraphTypeIdList()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this getParagraphTypeIdList");
        } else if (validator.getTagTypeIdList() != null && tagTypeRepository.findAllById(validator.getTagTypeIdList()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this getTagTypeIdList");
        } else if (validator.getParapageTypeIdList() != null && parapageTypeRepository.findAllById(validator.getParapageTypeIdList()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this getParapageTypeIdList");
        } else if (validator.getParatagTypeIdList() != null && paratagTypeRepository.findAllById(validator.getParatagTypeIdList()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this getParatagTypeIdList");
        }
        categoryRepository.save(categoryMapper.set(
                validator,
                validator.getCategoryId() != null ? categoryRepository.findById(validator.getCategoryId()).get() : null,
                validator.getParagraphTypeIdList() != null ? paragraphTypeRepository.findAllById(validator.getParagraphTypeIdList()) : new ArrayList<>(),
                validator.getTagTypeIdList() != null ? tagTypeRepository.findAllById(validator.getTagTypeIdList()) : new ArrayList<>(),
                validator.getParapageTypeIdList() != null ? parapageTypeRepository.findAllById(validator.getParapageTypeIdList()) : new ArrayList<>(),
                validator.getParatagTypeIdList() != null ? paratagTypeRepository.findAllById(validator.getParatagTypeIdList()) : new ArrayList<>()));
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        CategoryValidator validator = (CategoryValidator) abstractValidator;
        if (categoryRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else if (categoryRepository.findById(validator.getCategoryId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else if (paragraphTypeRepository.findAllById(validator.getParagraphTypeIdList()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else if (tagTypeRepository.findAllById(validator.getTagTypeIdList()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else if (parapageTypeRepository.findAllById(validator.getParapageTypeIdList()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else if (paratagTypeRepository.findAllById(validator.getParatagTypeIdList()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        }
        //TODO
        categoryRepository.save(categoryMapper.set(
                validator,
                categoryRepository.findById(validator.getCategoryId()).get(),
                paragraphTypeRepository.findAllById(validator.getParagraphTypeIdList()),
                tagTypeRepository.findAllById(validator.getTagTypeIdList()),
                parapageTypeRepository.findAllById(validator.getParapageTypeIdList()),
                paratagTypeRepository.findAllById(validator.getParatagTypeIdList())));
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
