package be.heh.app.model.repositories;

import be.heh.app.model.entities.app.ParagraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParagraphTypeRepository extends JpaRepository<ParagraphType, Integer> {
}
