package be.heh.app.dto.edit;

import be.heh.app.dto.view.CategoryViewDto;
import be.heh.app.dto.view.UserViewDto;
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
public class PageEditDto {

    int id;

    CategoryViewDto category;

    UserViewDto user;

    List<InnerPageEditDto> innerPageList;

    List<ParagraphEditDto> paragraphList;

    List<ParatagEditDto> paratagList;

    List<ParapageEditDto> parapageList;

}
