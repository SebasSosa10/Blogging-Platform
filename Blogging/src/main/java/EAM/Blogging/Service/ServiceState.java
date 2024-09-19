package EAM.Blogging.Service;

import EAM.Blogging.Model.State;
import EAM.Blogging.Repository.RepositoryState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceState {
    @Autowired
    private RepositoryState repositoryState;

    public List<State> findAll() {
        return repositoryState.findAll();
    }

    public Optional<State> findById(Long id) {
        return repositoryState.findById(id);
    }

    public State save(State state) {
        return repositoryState.save(state);
    }

    public void deleteById(Long id) {
        repositoryState.deleteById(id);
    }
}
