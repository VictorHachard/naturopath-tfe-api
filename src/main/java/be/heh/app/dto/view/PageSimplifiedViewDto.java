package be.heh.app.dto.view;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
public class PageSimplifiedViewDto {

    int id;

    Date createdAt;

    String title;

    String description;

    ImageForPageByCategoryViewDto image;

    List<TagViewDto> tagList;

}
