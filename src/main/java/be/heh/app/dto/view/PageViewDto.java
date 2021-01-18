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
@Getter
@Setter
public class PageViewDto extends AbstractDto {

    Date createdAt;

    CategoryViewDto categoryViewDto;

    User user;

    String title;

    String description;

    List<ParagraphViewDto> paragraphDtoList;

    List<TagViewDto> tagDtoList;

    List<ParapageViewDto> parapageDtoList;

    List<ParatagViewDto> paratagDtoList;

    List<ImageViewDto> imageDtoList;

    public PageViewDto(int id, Date createdAt, CategoryViewDto categoryViewDto, User user, String title, String description, List<ParagraphViewDto> paragraphDtoList, List<TagViewDto> tagDtoList, List<ParapageViewDto> parapageDtoList, List<ParatagViewDto> paratagDtoList, List<ImageViewDto> imageDtoList) {
        super(id);
        this.createdAt = createdAt;
        this.categoryViewDto = categoryViewDto;
        this.user = user;
        this.title = title;
        this.description = description;
        this.paragraphDtoList = paragraphDtoList;
        this.tagDtoList = tagDtoList;
        this.parapageDtoList = parapageDtoList;
        this.paratagDtoList = paratagDtoList;
        this.imageDtoList = imageDtoList;
    }

}
