package be.heh.app.dto.view;

import be.heh.app.dto.commons.AbstractDto;
import be.heh.app.model.entities.app.enumeration.EnumSize;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ParatagViewDto extends AbstractDto {

    String title;

    ParatagTypeViewDto paratagType;

    String content;

    EnumSize size;

    List<TagViewDto> tagList;

    public ParatagViewDto(int id, String title, ParatagTypeViewDto paratagType, String content, EnumSize size, List<TagViewDto> tagList) {
        super(id);
        this.title = title;
        this.paratagType = paratagType;
        this.content = content;
        this.size = size;
        this.tagList = tagList;
    }

}
