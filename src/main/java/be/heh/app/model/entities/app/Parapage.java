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
public class Parapage extends AbstractEntity {

    @JoinColumn(name = "parapage_type_id")
    @ManyToOne
    ParapageType parapageType;

    @JoinColumn(name = "user_id")
    @ManyToOne
    User user;

    @OneToMany
    List<InnerParapage> innerParapageList;

    public void addInnerParapage(InnerParapage... innerParapage) {
        if (innerParapageList == null) {
            innerParapageList = new ArrayList<>();
        }
        innerParapageList.addAll(Arrays.asList(innerParapage));
    }

}
