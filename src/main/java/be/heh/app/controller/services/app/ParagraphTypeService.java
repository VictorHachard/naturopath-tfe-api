package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.GeneralTypeValidator;
import be.heh.app.controller.validators.app.ParagraphTypeValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.dto.view.ParagraphTypeViewDto;
import be.heh.app.model.entities.app.ParagraphType;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class ParagraphTypeService extends AbstractService<ParagraphType> {

    public int addC(AbstractValidator abstractValidator) {
        ParagraphTypeValidator validator = (ParagraphTypeValidator) abstractValidator;
        ParagraphType paragraphType = paragraphTypeMapper.set(validator);
        paragraphTypeRepository.save(paragraphType);
        return paragraphType.getId();
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        super.update(abstractValidator, id);
        ParagraphTypeValidator validator = (ParagraphTypeValidator) abstractValidator;
        ParagraphType paragraphType = paragraphTypeRepository.findById(id).get();
        paragraphTypeMapper.update(paragraphType, validator);
        paragraphTypeRepository.save(paragraphType);
    }

    public List<ParagraphTypeViewDto> getAllDto() {
        return paragraphTypeMapper.getAllView(super.getAll());
    }

    public ParagraphTypeViewDto getDto(int id) {
        return paragraphTypeMapper.getView(super.get(id));
    }

}
