package EAM.Blogging.repository;

import EAM.Blogging.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRole extends JpaRepository<Role, Long> {
}
