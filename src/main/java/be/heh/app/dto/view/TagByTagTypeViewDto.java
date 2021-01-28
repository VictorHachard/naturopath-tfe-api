package be.heh.app.dto.view;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
public class TagByTagTypeViewDto implements Comparable<TagByTagTypeViewDto> {

    int id;

    Date createdAt;

    String name;

    String content;

    @Override
    public int compareTo(TagByTagTypeViewDto o) {
        return this.getName().compareTo(o.getName());
    }

}
