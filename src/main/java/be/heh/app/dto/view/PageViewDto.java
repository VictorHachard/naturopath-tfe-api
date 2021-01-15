package be.heh.app.dto.view;

import be.heh.app.dto.commons.AbstractDto;
import be.heh.app.model.entities.app.User;
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
public class PageViewDto extends AbstractDto {

    int id;

    Date createdAt;

    CategoryViewDto categoryViewDto; //TODO utiliser nouveau dto dois envoyer les parent

    User user;

    String title;

    String description;

    List<ParagraphViewDto> paragraphDtoList;

    List<TagViewDto> tagDtoList;

    List<ParapageViewDto> parapageDtoList;

    List<ParatagViewDto> paratagDtoList;

    List<ImageViewDto> imageDtoList;

}
