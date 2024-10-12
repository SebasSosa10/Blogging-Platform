package EAM.Blogging.repository;

import EAM.Blogging.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RepositoryUser extends JpaRepository<User, Long> {
    Optional<User> findByUserProfileUserName(String username);
}
