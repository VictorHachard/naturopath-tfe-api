package be.heh.app.dto.view;

import be.heh.app.dto.commons.AbstractDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ParagraphViewDto extends AbstractDto {

    ParagraphTypeViewDto paragraphType;

    String title;

    String content;

    public ParagraphViewDto(int id, ParagraphTypeViewDto paragraphType, String title, String content) {
        super(id);
        this.paragraphType = paragraphType;
        this.title = title;
        this.content = content;
    }

}
