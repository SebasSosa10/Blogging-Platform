package EAM.Blogging.repository;

import EAM.Blogging.model.PostTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPostTag extends JpaRepository<PostTag, Long> {
}
