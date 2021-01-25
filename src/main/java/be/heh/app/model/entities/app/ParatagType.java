package be.heh.app.model.entities.app;

import be.heh.app.model.entities.app.enumeration.EnumSize;
import be.heh.app.model.entities.commons.AbstractType;
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
public class ParatagType extends AbstractType {

    @Column(name = "name")
    String name;

    @Column(name = "description", length = 2500)
    String description;

    @Column(name = "enum_size")
    EnumSize enumSize;

    @JoinColumn(name = "tag_type_id")
    @ManyToOne
    TagType tagType;

}
