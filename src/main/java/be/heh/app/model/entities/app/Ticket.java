package be.heh.app.model.entities.app;

import be.heh.app.model.entities.commons.AbstractEntity;
import be.heh.app.model.entities.security.UserSecurity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
// Lombok
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Ticket extends AbstractEntity {

    @JoinColumn(name = "user_security_id")
    @ManyToOne
    UserSecurity userSecurity;

    @Column(name = "subject")
    String subject;

    @Column(name = "is_close")
    boolean isClose;

    @OneToMany
    List<TicketContent> ticketContentList;

    public void add(TicketContent... ticketContents) {
        if (ticketContentList == null) {
            ticketContentList = new ArrayList<>();
        }
        ticketContentList.addAll(Arrays.asList(ticketContents));
    }

}
