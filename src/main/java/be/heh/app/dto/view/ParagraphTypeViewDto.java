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
public class ParagraphTypeViewDto implements Comparable<ParagraphTypeViewDto> {

    int id;

    String name;

    String description;

    boolean alert;

    @Override
    public int compareTo(ParagraphTypeViewDto o) {
        return this.getName().compareTo(o.getName());
    }

}
