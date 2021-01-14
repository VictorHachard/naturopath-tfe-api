package be.heh.app.model.entities.app;

import be.heh.app.model.entities.commons.AbstractInner;
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
public class Image extends AbstractInner {

    @JoinColumn(name = "user_id")
    @ManyToOne
    User user;

    @OneToMany
    List<InnerImage> innerImageList;

    public void addInnerImage(InnerImage... innerImage) {
        if (innerImageList == null) {
            innerImageList = new ArrayList<>();
        }
        innerImageList.addAll(Arrays.asList(innerImage));
    }

}
