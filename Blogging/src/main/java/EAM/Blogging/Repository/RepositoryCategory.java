package EAM.Blogging.Repository;

import EAM.Blogging.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCategory extends JpaRepository<Category, Long> {
}
