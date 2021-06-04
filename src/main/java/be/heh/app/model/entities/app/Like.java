package be.heh.app.model.entities.app;

import be.heh.app.model.entities.commons.AbstractEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

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
