package EAM.Blogging.Controller;

import EAM.Blogging.Model.UserProfile;
import EAM.Blogging.Dto.DtoUserProfile;
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
        return serviceUserProfile.findAllUserProfiles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserProfileById(@PathVariable Long id) {
        UserProfile userProfile = serviceUserProfile.findUserProfileById(id);
        return userProfile != null ? ResponseEntity.ok(userProfile) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public UserProfile createUserProfile(@RequestBody DtoUserProfile dtoUserProfile) {
        return serviceUserProfile.createUserProfile(dtoUserProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfile> updateUserProfile(@PathVariable Long id, @RequestBody DtoUserProfile dtoUserProfile) {
        boolean updated = serviceUserProfile.updateUserProfile(id, dtoUserProfile);
        if (updated) {
            UserProfile updatedUserProfile = serviceUserProfile.findUserProfileById(id);
            return ResponseEntity.ok(updatedUserProfile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserProfile(@PathVariable Long id) {
        boolean deleted = serviceUserProfile.deleteUserProfile(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
