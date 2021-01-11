package be.heh.app.model.repositories;

import be.heh.app.model.entities.app.Message;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends AbstractRepository<Message, Integer> {
}
