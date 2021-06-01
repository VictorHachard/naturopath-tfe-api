package be.heh.app.dto.view;

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
public class PageSearchDto {

    CategoryViewDto categoryViewDto;

    List<PageSimplifiedViewDto2> pageSimplifiedViewDto2List;

}
