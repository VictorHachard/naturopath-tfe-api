package be.heh.app.model.entities.app;

import be.heh.app.model.entities.commons.AbstractLang;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
// Lombok
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Category extends AbstractLang {

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @OneToMany
    List<ParagraphType> paragraphTypeList;

    @OneToMany
    List<TagType> tagTypeList;

}
