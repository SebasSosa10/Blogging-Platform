package EAM.Blogging.Repository;

import EAM.Blogging.Model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUserProfile extends JpaRepository<UserProfile, Long> {
}
