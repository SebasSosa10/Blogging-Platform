package EAM.Blogging.repository;

import EAM.Blogging.model.PostTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryPostTag extends JpaRepository<PostTag, Long> {
    List<PostTag> findByTag_Name(String tagName);
}
