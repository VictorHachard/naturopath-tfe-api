package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.ParagraphTypeValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.dto.view.ParapageTypeViewDto;
import be.heh.app.model.entities.app.ParapageType;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class ParapageTypeService extends AbstractService<ParapageType> {

    public int addC(AbstractValidator abstractValidator) {
        ParagraphTypeValidator validator = (ParagraphTypeValidator) abstractValidator;
        ParapageType parapageType = parapageTypeMapper.set(validator);
        parapageTypeRepository.save(parapageType);
        return parapageType.getId();
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        super.update(abstractValidator, id);
        ParagraphTypeValidator validator = (ParagraphTypeValidator) abstractValidator;
        ParapageType parapageType = parapageTypeRepository.findById(id).get();
        parapageTypeMapper.update(parapageType, validator);
        parapageTypeRepository.save(parapageType);
    }

    public List<ParapageTypeViewDto> getAllDto() {
        return parapageTypeMapper.getAllView(super.getAll());
    }

    public ParapageTypeViewDto getDto(int id) {
        return parapageTypeMapper.getView(super.get(id));
    }

}
