package be.heh.app.dto.edit;

import be.heh.app.model.entities.app.SortedType;
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

    List<CategoryEditDto> childCategory;

    List<SortedType> sortedTypeType;

    @Override
    public int compareTo(CategoryEditDto o) {
        return this.getName().compareTo(o.getName());
    }

}
