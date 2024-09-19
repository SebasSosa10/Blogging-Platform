package EAM.Blogging.Controller;

import EAM.Blogging.Model.UserFollow;
import EAM.Blogging.Service.ServiceUserFollow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/userfollow")
public class ControllerUserFollow {
    @Autowired
    private ServiceUserFollow serviceUserFollow;

    @GetMapping
    public List<UserFollow> getAllUserProfiles() {
        return serviceUserFollow.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserFollow> getUserProfileById(@PathVariable Long id) {
        Optional<UserFollow> userProfile = serviceUserFollow.findById(id);
        return userProfile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserFollow createUserProfile(@RequestBody UserFollow userProfile) {
        return serviceUserFollow.save(userProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserFollow> updateUserProfile(@PathVariable Long id, @RequestBody UserFollow userProfileDetails) {
        Optional<UserFollow> userProfileFollow = serviceUserFollow.findById(id);
        if (userProfileFollow.isPresent()) {
            UserFollow updatedUserFollow = userProfileFollow.get();
            updatedUserFollow.setFollower(userProfileDetails.getFollower());
            updatedUserFollow.setFollowed(userProfileDetails.getFollowed());
            return ResponseEntity.ok(serviceUserFollow.save(userProfileDetails));
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserFollow> deleteUserProfile(@PathVariable Long id) {
        if(serviceUserFollow.findById(id).isPresent()) {
            serviceUserFollow.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
