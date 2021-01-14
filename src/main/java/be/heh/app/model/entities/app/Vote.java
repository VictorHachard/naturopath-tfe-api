package be.heh.app.model.entities.app;

import be.heh.app.model.entities.commons.AbstractEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
public class Vote extends AbstractEntity {

    @JoinColumn(name = "user_id")
    @ManyToOne
    User user;

    @JoinColumn(name = "choice")
    int choice; // 0 pour - 1 contre

    /*@JoinColumn(name = "inner_id")
    @ManyToOne
    AbstractInner inner;*/

}
