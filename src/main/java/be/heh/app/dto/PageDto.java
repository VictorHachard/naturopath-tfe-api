package be.heh.app.dto;

import be.heh.app.model.entities.app.Page;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PageDto {

    private Page page;
    private String msgSucess;

}
