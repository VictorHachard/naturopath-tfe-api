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
public class SortedTypeViewDto implements Comparable<SortedTypeViewDto> {

    int id;

    int order;

    int typeId;

    String type;

    @Override
    public int compareTo(SortedTypeViewDto o) {
        return Integer.compare(this.getOrder(), o.getOrder());
    }

}
