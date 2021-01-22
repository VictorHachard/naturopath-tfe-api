package be.heh.app.dto.view;

import be.heh.app.model.entities.app.enumeration.EnumSize;
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
public class ParatagViewDto {

    int id;

    String title;

    ParatagTypeViewDto paratagType;

    String content;

    EnumSize size;

    List<TagViewDto> tagList;

}
