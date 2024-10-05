package EAM.Blogging.repository;

import EAM.Blogging.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryState extends JpaRepository<State, Long> {
}
