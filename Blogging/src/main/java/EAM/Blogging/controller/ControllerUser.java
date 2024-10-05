package EAM.Blogging.controller;

import EAM.Blogging.model.User;
import EAM.Blogging.dto.DtoUser;
import EAM.Blogging.service.ServiceUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class ControllerUser {
    @Autowired
    private ServiceUser serviceUser;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = serviceUser.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = serviceUser.findUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody DtoUser dtoUser) {
        User newUser = serviceUser.createUser(dtoUser);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody DtoUser dtoUser) {
        boolean updated = serviceUser.updateUser(id, dtoUser);
        return updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean deleted = serviceUser.deleteUser(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
