package be.heh.app.model.entities.app;

import be.heh.app.model.entities.app.enumeration.EnumState;
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
public class Page extends AbstractEntity {

    @JoinColumn(name = "categorie_id")
    @ManyToOne
    Category category;

    @JoinColumn(name = "user_id")
    @ManyToOne
    User user;

    @Column(name = "enum_state")
    EnumState enumState;

    @OneToMany
    List<InnerPage> innerPageList = new ArrayList<>();

    @OneToMany
    List<Paragraph> paragraphList;

    @OneToMany
    List<Parapage> parapageList;

    @OneToMany
    List<Paratag> paratagList;

    @OneToMany
    List<Message> messageList;

    public void addMessage(Message... messages) {
        if (messageList == null) {
            messageList = new ArrayList<>();
        }
        messageList.addAll(Arrays.asList(messages));
    }

    public void addParagraph(Paragraph... paragraph) {
        if (paragraphList == null) {
            paragraphList = new ArrayList<>();
        }
        paragraphList.addAll(Arrays.asList(paragraph));
    }

    public void addParatag(Paratag... paratag) {
        if (paratagList == null) {
            paratagList = new ArrayList<>();
        }
        paratagList.addAll(Arrays.asList(paratag));
    }

    public void addParapage(Parapage... parapage) {
        if (parapageList == null) {
            parapageList = new ArrayList<>();
        }
        parapageList.addAll(Arrays.asList(parapage));
    }

    public void addInnerPage(InnerPage... innerPage) {
        if (innerPageList == null) {
            innerPageList = new ArrayList<>();
        }
        innerPageList.addAll(Arrays.asList(innerPage));
    }

}
