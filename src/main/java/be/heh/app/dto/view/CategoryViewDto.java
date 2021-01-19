package be.heh.app.dto.view;

import be.heh.app.dto.commons.AbstractDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class CategoryViewDto extends AbstractDto {

    String name;

    String description;

    List<CategoryViewDto> childCategory;

    public CategoryViewDto(int id, String name, String description, List<CategoryViewDto> childCategory) {
        super(id);
        this.name = name;
        this.description = description;
        this.childCategory = childCategory;
    }
    
}
