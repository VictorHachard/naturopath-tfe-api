package be.heh.app.model.facades.commons;

import be.heh.app.model.entities.commons.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Constructor;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractFacade<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    public T newInstance() {
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
        return (T) obj;
    }

    public List<T> getList(List<T> list){
        return new ArrayList<>(list);
    }

}
