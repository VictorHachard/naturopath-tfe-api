package be.heh.app.dto.view;

import be.heh.app.dto.commons.AbstractDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class TagViewDto extends AbstractDto {

    TagTypeViewDto tagType;

    String name;

    String content;

    public TagViewDto(int id, TagTypeViewDto tagType, String name, String content) {
        super(id);
        this.tagType = tagType;
        this.name = name;
        this.content = content;
    }

}
