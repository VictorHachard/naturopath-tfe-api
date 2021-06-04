package be.heh.app.model.entities.app;

import be.heh.app.model.entities.commons.AbstractLang;
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
public class Category extends AbstractLang {

    @Column(name = "name")
    String name;

    @Column(name = "description", length = 2500)
    String description;

    @Column(name = "order_f")
    int order;

    @Column(name = "is_parent")
    boolean isParent;

    @JoinColumn(name = "category_id")
    @ManyToOne
    Category parentCategory;

    @OneToMany
    List<SortedType> sortedTypeList;

    public void addType(SortedType... l) {
        if (sortedTypeList == null) {
            sortedTypeList = new ArrayList<>();
        }
        sortedTypeList.addAll(Arrays.asList(l));
    }

    public void addType(List<SortedType> l) {
        if (sortedTypeList == null) {
            sortedTypeList = new ArrayList<>();
        }
        sortedTypeList.addAll(l);
    }

    public void clearSortedType() {
        sortedTypeList.clear();
    }

}
