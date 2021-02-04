package be.heh.app.model.repositories.commons;

import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.commons.AbstractInner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MappedInner<T extends AbstractInner, I> extends AbstractRepository<T, I> {

    /**
     * Return true if the user has already voted in the innerId given in parameter, false otherwise.
     * @param innerId the id of the inner
     * @param user the user
     * @return true if the user has already voted
     */
    @Query("select case when (count(u) > 0) then true else false end from User u where ?2 in (select vote.user from #{#entityName} t join t.voteList vote where t.id = ?1)")
    Boolean hasVoted(int innerId, User user);

    /**
     * Return true if the user has already voted in the innerId given in parameter, false otherwise.
     * @param innerId the id of the inner
     * @param userId the id of the user
     * @return true if the user has already voted
     */
    @Query("select case when (count(u) > 0) then true else false end from User u where ?2 in (select vote.user.id from #{#entityName} t join t.voteList vote where t.id = ?1)")
    Boolean hasVotedById(int innerId, int userId);

}