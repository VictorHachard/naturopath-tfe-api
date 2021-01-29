package be.heh.app.mappers.app;

import be.heh.app.dto.view.SortedTypeViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.SortedType;
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
public class SortedTypeMapper extends AbstractMapper {

    public List<SortedTypeViewDto> getAllView(List<SortedType> j) {
        List<SortedTypeViewDto> res = new ArrayList<>();
        j.forEach(i -> {
            res.add(this.getView(i));
        });
        Collections.sort(res);
        return res;
    }

    public SortedTypeViewDto getView(SortedType sortedType) {
        return new SortedTypeViewDto(
                sortedType.getId(),
                sortedType.getOrder(),
                sortedType.getAbstractType().getId(),
                sortedType.getAbstractType().getType()
        );
    }

}
