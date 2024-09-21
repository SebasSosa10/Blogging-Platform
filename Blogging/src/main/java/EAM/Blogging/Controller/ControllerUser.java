package EAM.Blogging.Controller;

import EAM.Blogging.Model.User;
import EAM.Blogging.Dto.DtoUser;
import EAM.Blogging.Service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<User> createUser(@RequestBody DtoUser dtoUser) {
        User newUser = serviceUser.createUser(dtoUser);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody DtoUser dtoUser) {
        boolean updated = serviceUser.updateUser(id, dtoUser);
        return updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean deleted = serviceUser.deleteUser(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
