package EAM.Blogging.repository;

import EAM.Blogging.model.UserFollow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUserFollow extends JpaRepository<UserFollow, Long> {

}
