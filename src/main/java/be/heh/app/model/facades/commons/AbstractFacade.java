package be.heh.app.model.facades.commons;

import be.heh.app.init.AbstractAutowire;
import be.heh.app.model.entities.commons.AbstractEntity;
import lombok.extern.java.Log;

import java.lang.reflect.ParameterizedType;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Log
public abstract class AbstractFacade<T> extends AbstractAutowire {

    protected int userId = 5;

    public T newInstance() {
        AbstractEntity obj = null;
        try {
            Object instance = ((Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
            obj = (AbstractEntity) instance;
        } catch (Exception e) {
            log.info("AbstractRepository " + e.getMessage());
        }
        obj.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return (T) obj;
    }

    public List<T> getList(List<T> list){
        return new ArrayList<>(list);
    }

}
