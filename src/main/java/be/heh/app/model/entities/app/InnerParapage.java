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
public class InnerParapage extends AbstractInner {

    @Column(name = "title")
    String title;

    @Column(name = "content", length = 2500)
    String content;

    @ManyToMany
    List<Page> pageList = new ArrayList<>();

    public void addPage(Page... p) {
        if (pageList == null) {
            pageList = new ArrayList<>();
        }
        pageList.addAll(Arrays.asList(p));
    }

    public void cleanPage() {
        pageList.clear();
    }

    public void addPage(List<Page> p) {
        if (pageList == null) {
            pageList = new ArrayList<>();
        }
        pageList.addAll(p);
    }

}
