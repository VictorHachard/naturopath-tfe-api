package be.heh.app.model.entities.app;

import be.heh.app.model.entities.commons.AbstractEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
// Lombok
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Page extends AbstractEntity {

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "version")
    int version;

    @JoinColumn(name = "categorie_id")
    @ManyToOne
    Category category;

    @JoinColumn(name = "user_id")
    @ManyToOne
    User user;

    @OneToMany
    List<Paragraph> paragraphList;

    @OneToMany
    List<Tag> tagList;

    public void addParagraph(Paragraph ... paragraph) {
        paragraphList.addAll(Arrays.asList(paragraph));
    }

    public boolean verifyTypeParagraph(ParagraphType type) {
        for (Paragraph paragraph: paragraphList) {
            if (paragraph.getParagraphType().getName().equals(type.getName())) {
                return false;
            }
        }
        return true;
    }

    public void addTag(Tag ... tag) {
        tagList.addAll(Arrays.asList(tag));
    }

    public boolean verifyTypeTag(TagType type) {
        for (Tag tag: tagList) {
            if (tag.getTagType().getName().equals(type.getName())) {
                return false;
            }
        }
        return true;
    }

}
