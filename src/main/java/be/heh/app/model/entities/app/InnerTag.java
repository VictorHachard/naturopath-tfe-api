package be.heh.app.model.entities.app;

import be.heh.app.model.entities.commons.AbstractEntity;
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

    public void addMessage(Message ... messages) {
        if (messageList == null) {
            messageList = new ArrayList<>();
        }
        messageList.addAll(Arrays.asList(messages));
    }

    public boolean addVote(Vote ... vote) {
        if (voteList == null) {
            voteList = new ArrayList<>();
        }
        voteList.addAll(Arrays.asList(vote));
        if (voteList.size() == 5) {
            for (Vote vote1: voteList) {
                if (vote1.getChoice() == 0) {
                    state = "NotValidate";
                    return false;
                }
            }
            state = "Validate";
            return false;
        } else {
            return true;
        }
    }

    public boolean userAlreadyVote(User user) {
        if (voteList == null) {
            return false;
        }
        for (Vote vote : voteList) {
            if (vote.getUser() == user) {
                return true;
            }
        }
        return false;
    }

}
