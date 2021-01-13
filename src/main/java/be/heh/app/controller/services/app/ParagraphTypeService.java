package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.GeneralTypeValidator;
import be.heh.app.model.entities.app.Category;
import be.heh.app.model.entities.app.ParagraphType;
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
public class ParagraphTypeService extends AbstractService<ParagraphType> {

    public ParagraphType insertParagraphType(GeneralTypeValidator generalTypeValidator) {
        ParagraphType tag = paragraphTypeMapper.map(generalTypeValidator);
        paragraphTypeRepository.save(tag);
        return tag;
    }

    public void linkParagraphTypeToCategory(int categoryId, int paragraphTypeId) {
        if (categoryRepository.findById(categoryId).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else if (paragraphTypeRepository.findById(paragraphTypeId).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no ParagraphType with this paragraphTypeId");
        } else {
            Category category = categoryRepository.findById(categoryId).get();
            category.addParagraphType(paragraphTypeRepository.findById(paragraphTypeId).get());
            categoryRepository.save(category);
        }
    }

}
