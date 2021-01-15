package be.heh.app.model.repositories.commons;

import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.commons.AbstractInner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MappedInner<T extends AbstractInner, I> extends AbstractRepository<T, I> {

    @Query("select u from User u where ?2 in (select vote.user from #{#entityName} t JOIN t.voteList vote WHERE t.id = ?1)")
    User findVote(int innerId, User user);

    /*@Query("select u from #{#entityName} u where (select inner.enumState from #{#entityName} t JOIN t.innerlist inner WHERE t.id = ?1) = VALIDATED")
    AbstractInner findLastNoDraft(int innerId);

    public InnerPage getLastNonDraft(Page page) {
        InnerPage innerPage = null;
        innerPageRepository.findLastNoDraft(page)
        for (InnerPage innerPage1 : page.getInnerPageList()) {
            if (innerPage1.getEnumState() == EnumState.VALIDATED) {
                innerPage = innerPage1;
            }
        }
        return innerPage;
    }

    public InnerPage getLastNonDraft(Page page) {
        InnerPage innerPage = null;
        for (InnerPage innerPage1 : page.getInnerPageList()) {
            if (innerPage1.getEnumState() == EnumState.VALIDATED) {
                innerPage = innerPage1;
            }
        }
        return innerPage;
    }*/


}