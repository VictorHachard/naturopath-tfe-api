package be.heh.app.model.entities.app;

import be.heh.app.model.entities.commons.AbstractEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
public class Image extends AbstractEntity {

    @JoinColumn(name = "user_id")
    @ManyToOne
    User user;

}
