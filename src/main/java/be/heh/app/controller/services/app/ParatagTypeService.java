package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.ParatagTypeValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.dto.view.ParatagTypeViewDto;
import be.heh.app.model.entities.app.ParatagType;
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
public class ParatagTypeService extends AbstractService<ParatagType> {

    public int addC(AbstractValidator abstractValidator) {
        ParatagTypeValidator validator = (ParatagTypeValidator) abstractValidator;
        if (tagTypeRepository.findById(validator.getTagTypeId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no with this categoryId");
        }
        ParatagType paragraphType = paratagTypeMapper.set(validator, tagTypeRepository.findById(validator.getTagTypeId()).get());
        paratagTypeRepository.save(paragraphType);
        return paragraphType.getId();
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        super.update(abstractValidator, id);
        ParatagTypeValidator validator = (ParatagTypeValidator) abstractValidator;
        if (tagTypeRepository.findById(validator.getTagTypeId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no with this categoryId");
        }
        ParatagType paratagType = paratagTypeRepository.findById(id).get();
        paratagTypeMapper.update(paratagType, validator, tagTypeRepository.findById(validator.getTagTypeId()).get());
        paratagTypeRepository.save(paratagType);
    }

    public List<ParatagTypeViewDto> getAllDto() {
        return paratagTypeMapper.getAllView(super.getAll());
    }

    public ParatagTypeViewDto getDto(int id) {
        return paratagTypeMapper.getView(super.get(id));
    }

}
