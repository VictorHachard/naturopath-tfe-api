package be.heh.app.model.repositories.commons;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractRepository<T, I> extends JpaRepository<T, I> {

}
