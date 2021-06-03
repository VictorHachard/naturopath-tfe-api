package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.ParatagTypeValidator;
import be.heh.app.dto.view.ParatagTypeViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.ParatagType;
import be.heh.app.model.entities.app.TagType;
import be.heh.app.model.entities.app.enumeration.EnumSize;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class ParatagTypeMapper extends AbstractMapper {

    public ParatagType set(ParatagTypeValidator validator, TagType tagType) {
        return paratagTypeFacade.newInstance(
                validator.getName(),
                validator.getDescription(),
                tagType,
                EnumSize.valueOf(validator.getSize()),
                validator.isAlert()
        );
    }

    public void update(ParatagType paratagType, ParatagTypeValidator validator, TagType tagType) {
        paratagType.setName( validator.getName());
        paratagType.setDescription(validator.getDescription());
        paratagType.setTagType(tagType);
        paratagType.setEnumSize(EnumSize.valueOf(validator.getSize()));
        paratagType.setAlert(validator.isAlert());
    }

    public List<ParatagTypeViewDto> getAllView(List<ParatagType> j) {
        List<ParatagTypeViewDto> res = new ArrayList<>();
        j.forEach(i -> {
            res.add(this.getView(i));
        });
        Collections.sort(res);
        return res;
    }

    public ParatagTypeViewDto getView(ParatagType paratagType) {
        return new ParatagTypeViewDto(
                paratagType.getId(),
                paratagType.getName(),
                paratagType.getDescription(),
                paratagType.isAlert(),
                tagTypeMapper.getView(paratagType.getTagType()),
                paratagType.getEnumSize()
        );
    }

}
