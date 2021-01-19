package be.heh.app.dto.edit;

import be.heh.app.dto.commons.AbstractDto;
import be.heh.app.dto.view.ParagraphTypeViewDto;
import be.heh.app.dto.view.ParapageTypeViewDto;
import be.heh.app.dto.view.ParatagTypeViewDto;
import be.heh.app.dto.view.TagTypeViewDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class CategoryEditDto extends AbstractDto {

    String name;

    String description;

    List<CategoryEditDto> CategoryEditDto;

    List<ParagraphTypeViewDto> ParagraphTypeViewDtoList;

    List<TagTypeViewDto> tagTypeViewDtoList;

    List<ParapageTypeViewDto> parapageTypeViewDtoList;

    List<ParatagTypeViewDto> paratagTypeViewDtoList;

    public CategoryEditDto(int id, String name, String description, List<be.heh.app.dto.edit.CategoryEditDto> categoryEditDto, List<ParagraphTypeViewDto> paragraphTypeViewDtoList, List<TagTypeViewDto> tagTypeViewDtoList, List<ParapageTypeViewDto> parapageTypeViewDtoList, List<ParatagTypeViewDto> paratagTypeViewDtoList) {
        super(id);
        this.name = name;
        this.description = description;
        CategoryEditDto = categoryEditDto;
        ParagraphTypeViewDtoList = paragraphTypeViewDtoList;
        this.tagTypeViewDtoList = tagTypeViewDtoList;
        this.parapageTypeViewDtoList = parapageTypeViewDtoList;
        this.paratagTypeViewDtoList = paratagTypeViewDtoList;
    }

}
