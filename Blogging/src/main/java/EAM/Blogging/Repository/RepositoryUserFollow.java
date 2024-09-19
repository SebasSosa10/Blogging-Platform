package EAM.Blogging.Repository;

import EAM.Blogging.Model.UserFollow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUserFollow extends JpaRepository<UserFollow, Long> {

}
