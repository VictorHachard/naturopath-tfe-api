package be.heh.app.model.entities.app;

import be.heh.app.model.entities.commons.AbstractInner;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
public class InnerParatag extends AbstractInner {

    @Column(name = "title")
    String title;

    @Column(name = "content", length = 2500)
    String content;

    @ManyToMany
    List<Tag> tagList;

    public void addTag(Tag... tag) {
        if (tagList == null) {
            tagList = new ArrayList<>();
        }
        tagList.addAll(Arrays.asList(tag));
    }

    public void cleanTag() {
        tagList.clear();
    }

    public void addTag(List<Tag> tag) {
        if (tagList == null) {
            tagList = new ArrayList<>();
        }
        tagList.addAll(tag);
    }

}
