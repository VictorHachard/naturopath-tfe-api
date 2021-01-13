package be.heh.app.dto;

import be.heh.app.model.entities.app.Category;
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
public class CategoryDto {

    int id;

    Date createdAt;

    String name;

    String description;

    boolean parent;

    Category parentCategory;

}
