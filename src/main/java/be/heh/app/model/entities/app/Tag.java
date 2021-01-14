package be.heh.app.model.entities.app;

import be.heh.app.model.entities.commons.AbstractEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Tag extends AbstractEntity {

    @JoinColumn(name = "tag_type_id")
    @ManyToOne
    TagType tagType;

    @JoinColumn(name = "user_id")
    @ManyToOne
    User user;

    @OneToMany
    List<InnerTag> innerTagList;

    public void addInnerTag(InnerTag... innerTag) {
        if (innerTagList == null) {
            innerTagList = new ArrayList<>();
        }
        innerTagList.addAll(Arrays.asList(innerTag));
    }

}
