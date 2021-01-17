package be.heh.app.mappers.app;

import be.heh.app.dto.view.ParatagTypeViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.ParatagType;
import be.heh.app.model.facades.app.ParatagTypeFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class ParatagTypeMapper extends AbstractMapper {

    public List<ParatagTypeViewDto> getAllView(List<ParatagType> j) {
        List<ParatagTypeViewDto> res = new ArrayList<>();
        j.forEach(i -> {
            res.add(this.getView(i));
        });
        return res;
    }

    public ParatagTypeViewDto getView(ParatagType paratagType) {
        return new ParatagTypeViewDto(
                paratagType.getId(),
                paratagType.getName(),
                paratagType.getDescription(),
                tagTypeMapper.getView(paratagType.getTagType())
        );
    }

}
