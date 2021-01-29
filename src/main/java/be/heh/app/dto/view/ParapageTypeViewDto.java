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
public class ParapageTypeViewDto implements Comparable<ParapageTypeViewDto> {

    int id;

    String name;

    String description;

    @Override
    public int compareTo(ParapageTypeViewDto o) {
        return this.getName().compareTo(o.getName());
    }

}
