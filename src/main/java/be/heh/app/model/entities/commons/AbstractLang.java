package be.heh.app.model.entities.commons;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public abstract class AbstractLang extends AbstractEntity {

    @Column(name = "lang")
    String lang;

}
