package be.heh.app.model.repositories.commons;

import be.heh.app.model.entities.commons.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Constructor;
import java.lang.reflect.TypeVariable;
import java.util.Date;
import java.util.logging.Logger;

public interface AbstractRepository<I, ID> extends JpaRepository<I, ID> {

    public default  I newInstance() {
        TypeVariable[] clazz = this.getClass().getTypeParameters();
        TypeVariable t = clazz[0];
        Constructor constructor = t.getClass().getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        AbstractEntity obj = null;
        try {
             obj = (AbstractEntity) constructor.newInstance();
             obj.setCreatedAt(new Date());
        } catch (Exception e) {
            Logger.getLogger("AbstractRepository").info(e.getMessage());
        }
        return (I) obj;
    }

}
