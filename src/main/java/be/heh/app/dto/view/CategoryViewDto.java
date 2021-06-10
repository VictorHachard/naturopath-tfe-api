package be.heh.app.dto.view;

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
public class CategoryViewDto implements Comparable<CategoryViewDto> {

    int id;

    String name;

    String description;

    boolean isParent;

    List<CategoryViewDto> childCategory;

    @Override
    public int compareTo(CategoryViewDto o) {
        return this.getName().compareTo(o.getName());
    }

}
