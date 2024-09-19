package EAM.Blogging.Repository;

import EAM.Blogging.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRole extends JpaRepository<Role, Long> {
}
