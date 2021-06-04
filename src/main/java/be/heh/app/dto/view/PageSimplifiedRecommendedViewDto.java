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
public class PageSimplifiedRecommendedViewDto {

    int id;

    String category;

    Date createdAt;

    String title;

    String description;

    ImageForPageByCategoryViewDto image;

}
