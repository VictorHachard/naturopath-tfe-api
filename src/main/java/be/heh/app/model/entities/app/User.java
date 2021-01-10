package be.heh.app.model.entities.app;

import be.heh.app.model.entities.commons.AbstractEntity;
import be.heh.app.model.entities.security.UserSecurity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "birth")
    @Temporal(TemporalType.DATE)
    Date birth;

    @Column(name = "lang")
    String lang;

}
