package EAM.Blogging.controller;

import EAM.Blogging.model.UserFollow;
import EAM.Blogging.dto.DtoUserFollow;
import EAM.Blogging.service.ServiceUserFollow;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/userfollow")
public class ControllerUserFollow {
    
    @Autowired
    private ServiceUserFollow serviceUserFollow;

    @GetMapping
    public List<UserFollow> getAllUserFollows() {
        return serviceUserFollow.findAllFollows();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserFollow> getUserFollowById(@PathVariable Long id) {
        UserFollow userFollow = serviceUserFollow.findUserFollowById(id);
        return userFollow != null ? ResponseEntity.ok(userFollow) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public UserFollow createUserFollow(@Valid @RequestBody DtoUserFollow dtoUserFollow) {
        return serviceUserFollow.createUserFollow(dtoUserFollow);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserFollow> updateUserFollow(@PathVariable Long id, @Valid @RequestBody DtoUserFollow dtoUserFollow) {
        boolean updated = serviceUserFollow.updateUserFollow(id, dtoUserFollow);
        if (updated) {
            UserFollow updatedUserFollow = serviceUserFollow.findUserFollowById(id);
            return ResponseEntity.ok(updatedUserFollow);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserFollow(@PathVariable Long id) {
        boolean deleted = serviceUserFollow.deleteUserFollow(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
