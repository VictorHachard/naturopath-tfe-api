package be.heh.app.dto.view;

import be.heh.app.dto.commons.AbstractDto;
import lombok.AccessLevel;
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

    CategoryViewDto category;

    UserViewDto user;

    String title;

    String description;

    List<ParagraphViewDto> paragraphList;

    List<TagViewDto> tagList;

    List<ParapageViewDto> parapageList;

    List<ParatagViewDto> paratagList;

    List<ImageViewDto> imageList;

    public PageViewDto(int id, Date createdAt, CategoryViewDto categoryViewDto, UserViewDto user, String title, String description, List<ParagraphViewDto> paragraphDtoList, List<TagViewDto> tagDtoList, List<ParapageViewDto> parapageDtoList, List<ParatagViewDto> paratagDtoList, List<ImageViewDto> imageDtoList) {
        super(id);
        this.createdAt = createdAt;
        this.category = categoryViewDto;
        this.user = user;
        this.title = title;
        this.description = description;
        this.paragraphList = paragraphDtoList;
        this.tagList = tagDtoList;
        this.parapageList = parapageDtoList;
        this.paratagList = paratagDtoList;
        this.imageList = imageDtoList;
    }

}
