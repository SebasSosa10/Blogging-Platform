package EAM.Blogging.Controller;

import EAM.Blogging.Model.UserProfile;
import EAM.Blogging.Service.ServiceUserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/userprofile")
public class ControllerUserProfile {
    @Autowired
    private ServiceUserProfile serviceUserProfile;

    @GetMapping
    public List<UserProfile> getAllUserProfiles() {
        return serviceUserProfile.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserProfileById(@PathVariable Long id) {
        Optional<UserProfile> userProfile = serviceUserProfile.findById(id);
        return userProfile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserProfile createUserProfile(@RequestBody UserProfile userProfile) {
        return serviceUserProfile.save(userProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfile> updateUserProfile(@PathVariable Long id, @RequestBody UserProfile userProfileDetails) {
        Optional<UserProfile> userProfile = serviceUserProfile.findById(id);
        if (userProfile.isPresent()) {
            UserProfile updatedUserProfile = userProfile.get();
            updatedUserProfile.setUserName(userProfileDetails.getUserName());
            updatedUserProfile.setBiography(userProfileDetails.getBiography());
            return ResponseEntity.ok(serviceUserProfile.save(updatedUserProfile));
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserProfile> deleteUserProfile(@PathVariable Long id) {
        if(serviceUserProfile.findById(id).isPresent()) {
            serviceUserProfile.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
