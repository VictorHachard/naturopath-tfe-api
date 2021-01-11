package be.heh.app.model.entities.app;

import be.heh.app.controller.validators.ParagraphValidator;
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
public class InnerParagraph extends AbstractEntity {

    @Column(name = "title")
    String title;

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

    public InnerParagraph(String title, String content, int version, User user) {
        this.title = title;
        this.content = content;
        this.version = version;
        this.state = "PROGRESS";
        this.user = user;
    }

    public InnerParagraph(ParagraphValidator paragraphValidator, User user) {
        this.title = paragraphValidator.getTitle();
        this.content = paragraphValidator.getContent();
        this.version = 0;
        this.state = "PROGRESS";
        this.user = user;
    }
}
