package be.heh.app.model.entities.app;

import be.heh.app.model.entities.app.enumeration.State;
import be.heh.app.model.entities.commons.AbstractEntity;
import be.heh.app.model.entities.commons.AbstractInner;
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
public class InnerTag extends AbstractInner {

    @Column(name = "names")
    String name;

    @Column(name = "content")
    String content;

}
