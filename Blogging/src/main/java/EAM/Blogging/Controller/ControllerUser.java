package EAM.Blogging.Controller;

import EAM.Blogging.Model.User;
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
    public List<User> getAllUsers() {
        return serviceUser.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> userProfile = serviceUser.findById(id);
        return userProfile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public User createUser(@RequestBody User userProfile) {
        return serviceUser.save(userProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        Optional<User> userProfile = serviceUser.findById(id);
        if (userProfile.isPresent()) {
            User updatedUser = userProfile.get();
            updatedUser.setPassword(userDetails.getPassword());
            updatedUser.setEmail(userDetails.getEmail());
            updatedUser.setRole(userDetails.getRole());
            return ResponseEntity.ok(serviceUser.save(updatedUser));
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        if(serviceUser.findById(id).isPresent()) {
            serviceUser.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
