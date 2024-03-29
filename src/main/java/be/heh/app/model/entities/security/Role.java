package be.heh.app.model.entities.security;

import be.heh.app.model.entities.security.enumeration.EnumRole;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
// Lombok
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Role implements Serializable {

    @Id
    @GeneratedValue
    int id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    EnumRole name;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    Date createdAt;

}
