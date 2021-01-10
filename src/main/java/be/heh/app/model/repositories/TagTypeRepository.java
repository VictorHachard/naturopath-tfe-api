package be.heh.app.model.repositories;

import be.heh.app.model.entities.app.TagType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagTypeRepository extends JpaRepository<TagType, Integer> {
}
