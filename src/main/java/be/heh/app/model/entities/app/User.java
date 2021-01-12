package be.heh.app.model.entities.app;

import be.heh.app.model.entities.commons.AbstractEntity;
import be.heh.app.model.entities.security.UserSecurity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="utilisateur")
// Lombok
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class User extends AbstractEntity {

    @OneToOne
    UserSecurity userSecurity;

    @Column(name = "lang")
    String lang;

}
