package EAM.Blogging.Service;

import EAM.Blogging.Model.UserProfile;
import EAM.Blogging.Repository.RepositoryUserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUserProfile {

    @Autowired
    private RepositoryUserProfile repositoryUserProfile;

    public List<UserProfile> findAll() {
        return repositoryUserProfile.findAll();
    }

    public Optional<UserProfile> findById(Long id) {
        return repositoryUserProfile.findById(id);
    }

    public UserProfile save(UserProfile userProfile) {
        return repositoryUserProfile.save(userProfile);
    }

    public void deleteById(Long id) {
        repositoryUserProfile.deleteById(id);
    }

}
