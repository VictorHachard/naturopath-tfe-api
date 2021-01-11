package be.heh.app.model.repositories;

import be.heh.app.model.entities.app.Vote;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends AbstractRepository<Vote, Integer> {
}
