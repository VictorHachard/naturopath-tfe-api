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
@Table(name = "aime")
// Lombok
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Like extends AbstractEntity {

    @JoinColumn(name = "user_id")
    @ManyToOne
    User user;

    @JoinColumn(name = "page_id")
    @ManyToOne
    Page page;

    @Column(name = "actual_like")
    boolean actualLike;

    @Column(name = "liked")
    boolean liked;

}
