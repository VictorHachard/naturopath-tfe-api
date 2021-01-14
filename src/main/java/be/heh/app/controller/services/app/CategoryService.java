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

import java.util.ArrayList;
import java.util.List;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class CategoryService extends AbstractService<Category> {

    public List<CategoryDto> getAllDto() {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        categoryRepository.findAllParent().forEach(category -> {
            CategoryDto categoryDto = getRecursive(category);
            categoryDtoList.add(categoryDto);

        });
        return categoryDtoList;
    }

    public CategoryDto getDto(int id) {
        return getRecursive(super.get(id));
    }

    private CategoryDto getRecursive(Category category) {
        CategoryDto categoryDto = categoryMapper.get(category);
        List<Category> children = categoryRepository.findAllChild(category);
        categoryDto.setCategoryDtoList(new ArrayList<>());
        if (!children.isEmpty()) {
            children.forEach(children1 -> {
                CategoryDto CategoryDtoChild = getRecursive(children1);
                categoryDto.getCategoryDtoList().add(CategoryDtoChild);
            });
        }
        return categoryDto;
    }

    @Override
    public void add(AbstractValidator abstractValidator) {
        CategoryValidator categoryValidator = (CategoryValidator) abstractValidator;
        if (categoryValidator.getCategoryId() != null && categoryRepository.findById(categoryValidator.getCategoryId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else if (categoryValidator.getParagraphTypeIdList() != null && paragraphTypeRepository.findAllById(categoryValidator.getParagraphTypeIdList()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this getParagraphTypeIdList");
        } else if (categoryValidator.getTagTypeIdList() != null && tagTypeRepository.findAllById(categoryValidator.getTagTypeIdList()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this getTagTypeIdList");
        } else if (categoryValidator.getParapageTypeIdList() != null && parapageTypeRepository.findAllById(categoryValidator.getParapageTypeIdList()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this getParapageTypeIdList");
        } else if (categoryValidator.getParatagTypeIdList() != null && paratagTypeRepository.findAllById(categoryValidator.getParatagTypeIdList()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this getParatagTypeIdList");
        }
        categoryRepository.save(categoryMapper.set(categoryValidator,
                categoryValidator.getCategoryId() != null ? categoryRepository.findById(categoryValidator.getCategoryId()).get() : null,
                categoryValidator.getParagraphTypeIdList() != null ? paragraphTypeRepository.findAllById(categoryValidator.getParagraphTypeIdList()) : new ArrayList<>(),
                categoryValidator.getTagTypeIdList() != null ? tagTypeRepository.findAllById(categoryValidator.getTagTypeIdList()) : new ArrayList<>(),
                categoryValidator.getParapageTypeIdList() != null ? parapageTypeRepository.findAllById(categoryValidator.getParapageTypeIdList()) : new ArrayList<>(),
                categoryValidator.getParatagTypeIdList() != null ? paratagTypeRepository.findAllById(categoryValidator.getParatagTypeIdList()) : new ArrayList<>()));
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        CategoryValidator categoryValidator = (CategoryValidator) abstractValidator;
        if (categoryRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else if (categoryRepository.findById(categoryValidator.getCategoryId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else if (paragraphTypeRepository.findAllById(categoryValidator.getParagraphTypeIdList()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else if (tagTypeRepository.findAllById(categoryValidator.getTagTypeIdList()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else if (parapageTypeRepository.findAllById(categoryValidator.getParapageTypeIdList()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else if (paratagTypeRepository.findAllById(categoryValidator.getParatagTypeIdList()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        }
        categoryRepository.save(categoryMapper.set(categoryRepository.findById(id).get(),
                categoryValidator,
                categoryRepository.findById(categoryValidator.getCategoryId()).get(),
                paragraphTypeRepository.findAllById(categoryValidator.getParagraphTypeIdList()),
                tagTypeRepository.findAllById(categoryValidator.getTagTypeIdList()),
                parapageTypeRepository.findAllById(categoryValidator.getParapageTypeIdList()),
                paratagTypeRepository.findAllById(categoryValidator.getParatagTypeIdList())));
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
