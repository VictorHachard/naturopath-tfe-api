package be.heh.app.model.entities.app;

import be.heh.app.model.entities.commons.AbstractLang;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Arrays;
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

    public void addParagraphType(ParagraphType ... paragraphType) {
        if (paragraphTypeList == null) {
            paragraphTypeList = new ArrayList<>();
        }
        paragraphTypeList.addAll(Arrays.asList(paragraphType));
    }

    public void addTagType(TagType ... tagType) {
        if (tagTypeList == null) {
            tagTypeList = new ArrayList<>();
        }
        tagTypeList.addAll(Arrays.asList(tagType));
    }

}
