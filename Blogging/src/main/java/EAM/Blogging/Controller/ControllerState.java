package EAM.Blogging.Controller;

import EAM.Blogging.Model.State;
import EAM.Blogging.Service.ServiceState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/state")
public class ControllerState {
    @Autowired
    private ServiceState serviceState;

    @GetMapping
    public List<State> getAllStates() {
        return serviceState.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> getStateById(@PathVariable Long id) {
        Optional<State> userProfile = serviceState.findById(id);
        return userProfile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public State createState(@RequestBody State userProfile) {
        return serviceState.save(userProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<State> updateState(@PathVariable Long id, @RequestBody State stateDetails) {
        Optional<State> state = serviceState.findById(id);
        if (state.isPresent()) {
            State updatedState = state.get();
            updatedState.setName(stateDetails.getName());
            return ResponseEntity.ok(serviceState.save(updatedState));
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<State> deleteState(@PathVariable Long id) {
        if(serviceState.findById(id).isPresent()) {
            serviceState.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
