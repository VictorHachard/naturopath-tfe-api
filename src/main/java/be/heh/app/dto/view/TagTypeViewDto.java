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
public class TagTypeViewDto implements Comparable<TagTypeViewDto> {

    int id;

    String name;

    String description;

    @Override
    public int compareTo(TagTypeViewDto o) {
        return this.getName().compareTo(o.getName());
    }

}
