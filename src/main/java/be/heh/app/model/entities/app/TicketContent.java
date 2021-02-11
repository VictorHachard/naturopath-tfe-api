package be.heh.app.model.entities.app;

import be.heh.app.model.entities.commons.AbstractEntity;
import be.heh.app.model.entities.security.UserSecurity;
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
public class TicketContent extends AbstractEntity {

    @JoinColumn(name = "user_security_id")
    @ManyToOne
    UserSecurity userSecurity;

    @Column(name = "content", length = 2500)
    String content;

}
