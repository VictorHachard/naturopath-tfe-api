package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.GeneralTypeValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.model.entities.app.TagType;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class TagTypeService extends AbstractService<TagType> {

    @Override
    public void add(AbstractValidator abstractValidator) {
        GeneralTypeValidator validator = (GeneralTypeValidator) abstractValidator;
        tagTypeRepository.save(tagTypeMapper.set(validator));
    }

}
