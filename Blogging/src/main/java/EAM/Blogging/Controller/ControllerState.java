package EAM.Blogging.Controller;

import EAM.Blogging.Model.State;
import EAM.Blogging.Dto.DtoState;
import EAM.Blogging.Service.ServiceState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/state")
public class ControllerState {

    @Autowired
    private ServiceState serviceState;

    @GetMapping
    public ResponseEntity<List<State>> getAllStates() {
        List<State> states = serviceState.findAllStates();
        return ResponseEntity.ok(states);
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> getStateById(@PathVariable Long id) {
        State state = serviceState.findStateById(id);
        return (state != null) ? ResponseEntity.ok(state) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<State> createState(@RequestBody DtoState dtoState) {
        State createdState = serviceState.createState(dtoState);
        return ResponseEntity.ok(createdState);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateState(@PathVariable Long id, @RequestBody DtoState dtoState) {
        boolean updated = serviceState.updateState(id, dtoState);
        return (updated) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteState(@PathVariable Long id) {
        boolean deleted = serviceState.deleteState(id);
        return (deleted) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
