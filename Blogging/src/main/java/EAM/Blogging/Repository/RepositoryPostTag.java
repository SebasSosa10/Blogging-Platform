package EAM.Blogging.Repository;

import EAM.Blogging.Model.PostTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPostTag extends JpaRepository<PostTag, Long> {
}
