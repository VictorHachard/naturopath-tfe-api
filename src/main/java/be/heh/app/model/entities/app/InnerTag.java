package be.heh.app.model.entities.app;

import be.heh.app.model.entities.commons.AbstractEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
// Lombok
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class InnerTag extends AbstractEntity {

    @Column(name = "names")
    String name;

    @Column(name = "content")
    String content;

    @Column(name = "version")
    int version;

    @OneToMany
    List<Vote> voteList;

    @OneToMany
    List<Message> messageList;

    @Column(name = "state")
    String state;

    @JoinColumn(name = "user_id")
    @ManyToOne
    User user;

}
