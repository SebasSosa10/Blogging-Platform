package EAM.Blogging.repository;

import EAM.Blogging.model.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RepositoryPostCategory extends JpaRepository<PostCategory, Long> {
    List<PostCategory> findByCategory_Name(String categoryName);
}
