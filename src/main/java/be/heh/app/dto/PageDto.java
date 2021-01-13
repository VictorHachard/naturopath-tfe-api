package be.heh.app.dto;

import be.heh.app.dto.commons.AbstractDto;
import be.heh.app.model.entities.app.Category;
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
public class PageDto extends AbstractDto {

    int id;

    Date createdAt;

    Category category;

    User user;

    String title;

    String description;

    List<ParagraphDto> paragraphdtoList;

    List<TagDto> tagDtoList;

    List<ParapageDto> parapageDtoList;

    List<ParatagDto> paratagDtoList;

    List<ImageDto> imageDtoList;

}
