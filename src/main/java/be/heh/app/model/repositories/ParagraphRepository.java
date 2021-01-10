package be.heh.app.model.repositories;

import be.heh.app.model.entities.app.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParagraphRepository extends JpaRepository<Paragraph, Integer> {
}
