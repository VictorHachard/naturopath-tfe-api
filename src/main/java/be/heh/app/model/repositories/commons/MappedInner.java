package be.heh.app.model.repositories.commons;

import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.commons.AbstractInner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MappedInner<T extends AbstractInner, I> extends AbstractRepository<T, I> {

    @Query("select u from User u where ?2 in (select vote.user from #{#entityName} t JOIN t.voteList vote WHERE t.id = ?1)")
    User findVote(int id,User u);

}