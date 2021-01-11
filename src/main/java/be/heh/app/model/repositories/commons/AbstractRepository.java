package be.heh.app.model.repositories.commons;

import be.heh.app.model.entities.commons.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.lang.reflect.Constructor;
import java.lang.reflect.TypeVariable;
import java.util.Date;
import java.util.logging.Logger;

@NoRepositoryBean
public interface AbstractRepository<I, ID> extends JpaRepository<I, ID> {
}
