package be.heh.app.dto.edit;

import be.heh.app.dto.view.SortedTypeViewDto;
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
public class CategoryEditDto implements Comparable<CategoryEditDto> {

    int id;

    String name;

    String description;

    boolean isParent;

    List<CategoryEditDto> childCategory;

    List<SortedTypeViewDto> sortedTypeType;

    @Override
    public int compareTo(CategoryEditDto o) {
        return this.getName().compareTo(o.getName());
    }

}
