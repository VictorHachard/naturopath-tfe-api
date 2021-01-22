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
public class PageViewDto {

    int id;

    Date createdAt;

    CategoryViewDto category;

    UserViewDto user;

    String title;

    String description;

    List<ParagraphViewDto> paragraphList;

    List<ParapageViewDto> parapageList;

    List<ParatagViewDto> paratagList;

    List<ImageViewDto> imageList;

}
