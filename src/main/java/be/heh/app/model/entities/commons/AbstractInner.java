package be.heh.app.model.entities.commons;

import be.heh.app.model.entities.app.Message;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.Vote;
import be.heh.app.model.entities.app.enumeration.EnumState;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@MappedSuperclass
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public abstract class AbstractInner extends AbstractEntity {

    @Column(name = "version")
    int version;

    @OneToMany
    List<Vote> voteList;

    @OneToMany
    List<Message> messageList;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    EnumState enumState;

    @JoinColumn(name = "user_id")
    @ManyToOne
    User user;

    public void addMessage(Message... messages) {
        if (messageList == null) {
            messageList = new ArrayList<>();
        }
        messageList.addAll(Arrays.asList(messages));
    }

    public boolean addVote(Vote... vote) {
        if (voteList == null) {
            voteList = new ArrayList<>();
        }
        voteList.addAll(Arrays.asList(vote));
        if (voteList.size() == 5) {
            for (Vote vote1: voteList) {
                if (vote1.getChoice() == 0) {
                    enumState = EnumState.NOT_VALIDATED;
                    return false;
                }
            }
            enumState = EnumState.VALIDATED;
            return false;
        } else {
            return true;
        }
    }

    public boolean isFinalState() {
        if (enumState == EnumState.VALIDATED || enumState == EnumState.NOT_VALIDATED) {
            return true;
        } else {
            return false;
        }
    }

}
