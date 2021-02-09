package be.heh.app.model.entities.app;

import be.heh.app.model.entities.commons.AbstractInner;
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
public class InnerPage extends AbstractInner {

    @Column(name = "title")
    String title;

    @Column(name = "description", length = 2500)
    String description;

    @JoinColumn(name = "image_id")
    @ManyToOne
    Image image;

}
