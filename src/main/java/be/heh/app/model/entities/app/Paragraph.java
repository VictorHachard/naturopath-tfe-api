package be.heh.app.model.entities.app;

import be.heh.app.model.entities.commons.AbstractEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
// Lombok
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Paragraph extends AbstractEntity {

    @Column(name = "title")
    String title;

    @Column(name = "content")
    String content;

    @JoinColumn(name = "paragraph_type_id")
    @ManyToOne
    ParagraphType paragraphType;

    @JoinColumn(name = "user_id")
    @ManyToOne
    User user;

}
