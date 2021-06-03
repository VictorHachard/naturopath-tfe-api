package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.GeneralTypeValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.dto.view.ParapageTypeViewDto;
import be.heh.app.model.entities.app.ParagraphType;
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
        /*GeneralTypeValidator validator = (GeneralTypeValidator) abstractValidator;
        ParagraphType paragraphType = parapageTypeMapper.set(validator);
        paragraphTypeRepository.save(paragraphType);
        return paragraphType.getId();*/
        return 1;
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        /*super.update(abstractValidator, id);
        GeneralTypeValidator validator = (GeneralTypeValidator) abstractValidator;
        ParagraphType paragraphType = paragraphTypeRepository.findById(id).get();
        paragraphTypeMapper.update(paragraphType, validator);
        paragraphTypeRepository.save(paragraphType);*/
    }

    public List<ParapageTypeViewDto> getAllDto() {
        return parapageTypeMapper.getAllView(super.getAll());
    }

    public ParapageTypeViewDto getDto(int id) {
        return parapageTypeMapper.getView(super.get(id));
    }

}
