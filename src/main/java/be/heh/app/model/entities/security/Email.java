package be.heh.app.model.entities.security;

import be.heh.app.model.entities.security.enumeration.EnumEmail;
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
public class Email implements Serializable {

    @Id
    @GeneratedValue
    int id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    EnumEmail name;

}
