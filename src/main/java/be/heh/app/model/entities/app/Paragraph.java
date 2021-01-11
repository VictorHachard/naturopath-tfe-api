package be.heh.app.model.entities.app;

import be.heh.app.model.entities.commons.AbstractEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Arrays;
import java.util.List;

@Entity
// Lombok
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Paragraph extends AbstractEntity {

    @JoinColumn(name = "paragraph_type_id")
    @ManyToOne
    ParagraphType paragraphType;

    @JoinColumn(name = "user_id")
    @ManyToOne
    User user;

    @OneToMany
    List<InnerParagraph> innerParagraphList;

    public void addInnerParagraph(InnerParagraph ... innerParagraph) {
        innerParagraphList.addAll(Arrays.asList(innerParagraph));
    }

}
