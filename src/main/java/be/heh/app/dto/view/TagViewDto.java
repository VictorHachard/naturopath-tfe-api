package be.heh.app.dto.view;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
public class TagViewDto implements Comparable<TagViewDto> {

    int id;

    TagTypeViewDto tagType;

    String name;

    String content;

    @Override
    public int compareTo(TagViewDto o) {
        return this.getName().compareTo(o.getName());
    }

}
