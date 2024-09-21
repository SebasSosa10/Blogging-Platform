package EAM.Blogging.Service;

import EAM.Blogging.Dto.DtoState;
import EAM.Blogging.Model.State;
import EAM.Blogging.Repository.RepositoryState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceState {
    @Autowired
    private RepositoryState stateRepository;

    public List<State> findAllStates() {
        return stateRepository.findAll();
    }

    public State findStateById(Long id) {
        return stateRepository.findById(id).orElse(null);
    }

    public State createState(DtoState dtoState) {
        State state = new State();
        state.setName(dtoState.getName());
        state.setPost(dtoState.getPost());
        return stateRepository.save(state);
    }

    public boolean updateState(Long id, DtoState dtoState) {
        Optional<State> optionalState = stateRepository.findById(id);
        if (optionalState.isPresent()) {
            State stateToUpdate = optionalState.get();
            stateToUpdate.setName(dtoState.getName());
            stateToUpdate.setPost(dtoState.getPost());
            stateRepository.save(stateToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteState(Long id) {
        if (stateRepository.existsById(id)) {
            stateRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
