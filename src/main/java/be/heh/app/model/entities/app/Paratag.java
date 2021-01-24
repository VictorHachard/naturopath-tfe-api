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
public class Paratag extends AbstractEntity {

    @JoinColumn(name = "paratag_type_id")
    @ManyToOne
    ParatagType paratagType;

    @JoinColumn(name = "user_id")
    @ManyToOne
    User user;

    @OneToMany
    List<InnerParatag> innerParatagList;

    public void addInnerParatag(InnerParatag... innerParatag) {
        if (innerParatagList == null) {
            innerParatagList = new ArrayList<>();
        }
        innerParatagList.addAll(Arrays.asList(innerParatag));
    }

}
