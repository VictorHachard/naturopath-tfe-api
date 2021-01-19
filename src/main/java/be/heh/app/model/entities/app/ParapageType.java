package be.heh.app.model.entities.app;

import be.heh.app.model.entities.commons.AbstractEntity;
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
public class ParapageType extends AbstractEntity {

    @Column(name = "name")
    String name;

    @Column(name = "description", length = 2500)
    String description;

}
