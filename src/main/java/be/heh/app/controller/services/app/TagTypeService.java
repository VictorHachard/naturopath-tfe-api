package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.GeneralTypeValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.dto.view.TagTypeViewDto;
import be.heh.app.model.entities.app.TagType;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class TagTypeService extends AbstractService<TagType> {

    public int addC(AbstractValidator abstractValidator) {
        GeneralTypeValidator validator = (GeneralTypeValidator) abstractValidator;
        TagType tagType = tagTypeMapper.set(validator);
        tagTypeRepository.save(tagType);
        return tagType.getId();
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        super.update(abstractValidator, id);
        GeneralTypeValidator validator = (GeneralTypeValidator) abstractValidator;
        TagType tagType = tagTypeRepository.findById(id).get();
        tagTypeMapper.update(tagType, validator);
        tagTypeRepository.save(tagType);
    }

    public List<TagTypeViewDto> getAllDto() {
        return tagTypeMapper.getAllView(super.getAll());
    }

}
