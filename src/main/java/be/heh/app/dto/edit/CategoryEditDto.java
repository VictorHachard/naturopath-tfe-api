package be.heh.app.dto.edit;

import be.heh.app.dto.view.ParagraphTypeViewDto;
import be.heh.app.dto.view.ParapageTypeViewDto;
import be.heh.app.dto.view.ParatagTypeViewDto;
import be.heh.app.dto.view.TagTypeViewDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
public class CategoryEditDto {

    int id;

    String name;

    String description;

    List<CategoryEditDto> CategoryEditDto;

    List<ParagraphTypeViewDto> ParagraphTypeViewDtoList;

    List<TagTypeViewDto> tagTypeViewDtoList;

    List<ParapageTypeViewDto> parapageTypeViewDtoList;

    List<ParatagTypeViewDto> paratagTypeViewDtoList;

}
