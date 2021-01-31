package be.heh.app.model.entities.security;

import be.heh.app.model.entities.security.enumeration.EnumPermission;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
// Lombok
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Permission implements Serializable {

    @Id
    @GeneratedValue
    int id;

    @Column(name = "enum_type")
    @Enumerated(EnumType.STRING)
    EnumPermission enumPermission;

}
