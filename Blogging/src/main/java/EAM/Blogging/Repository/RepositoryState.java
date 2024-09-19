package EAM.Blogging.Repository;

import EAM.Blogging.Model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryState extends JpaRepository<State, Long> {
}
