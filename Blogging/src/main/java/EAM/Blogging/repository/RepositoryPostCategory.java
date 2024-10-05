package EAM.Blogging.repository;

import EAM.Blogging.model.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPostCategory extends JpaRepository<PostCategory, Long> {
}
