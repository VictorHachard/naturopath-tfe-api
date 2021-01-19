package be.heh.app.model.entities.app;

import be.heh.app.model.entities.commons.AbstractInner;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
// Lombok
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class InnerParagraph extends AbstractInner {

    @Column(name = "title")
    String title;

    @Column(name = "content", length = 2500)
    String content;

}
