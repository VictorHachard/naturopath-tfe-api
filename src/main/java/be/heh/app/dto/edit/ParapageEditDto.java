package be.heh.app.dto.edit;

import be.heh.app.dto.view.ParapageTypeViewDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
public class ParapageEditDto {

    int id;

    ParapageTypeViewDto parapageType;

    List<InnerParapageEditDto> innerParapageList;

}
