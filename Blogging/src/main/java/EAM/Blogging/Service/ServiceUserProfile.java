package EAM.Blogging.Service;

import EAM.Blogging.Dto.DtoUserProfile;
import EAM.Blogging.Model.UserProfile;
import EAM.Blogging.Repository.RepositoryUserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUserProfile {

    @Autowired
    private RepositoryUserProfile userProfileRepository;

    public List<UserProfile> findAllUserProfiles() {
        return userProfileRepository.findAll();
    }

    public UserProfile findUserProfileById(Long id) {
        return userProfileRepository.findById(id).orElse(null);
    }

    public UserProfile createUserProfile(DtoUserProfile dtoUserProfile) {
        UserProfile userProfile = new UserProfile();
        userProfile.setUser(dtoUserProfile.getUser());
        userProfile.setUserName(dtoUserProfile.getUserName());
        userProfile.setBiography(dtoUserProfile.getBiography());
        return userProfileRepository.save(userProfile);
    }

    public boolean updateUserProfile(Long id, DtoUserProfile dtoUserProfile) {
        Optional<UserProfile> optionalUserProfile = userProfileRepository.findById(id);
        if (optionalUserProfile.isPresent()) {
            UserProfile userProfileToUpdate = optionalUserProfile.get();
            userProfileToUpdate.setUser(dtoUserProfile.getUser());
            userProfileToUpdate.setUserName(dtoUserProfile.getUserName());
            userProfileToUpdate.setBiography(dtoUserProfile.getBiography());
            userProfileRepository.save(userProfileToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteUserProfile(Long id) {
        if (userProfileRepository.existsById(id)) {
            userProfileRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
