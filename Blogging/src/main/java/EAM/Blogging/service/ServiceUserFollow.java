package EAM.Blogging.service;

import EAM.Blogging.dto.DtoUserFollow;
import EAM.Blogging.model.UserFollow;
import EAM.Blogging.repository.RepositoryUserFollow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUserFollow {

    @Autowired
    private RepositoryUserFollow userFollowRepository;

    public List<UserFollow> findAllFollows() {
        return userFollowRepository.findAll();
    }

    public UserFollow findUserFollowById(Long id) {
        return userFollowRepository.findById(id).orElse(null);
    }

    public UserFollow createUserFollow(DtoUserFollow dtoUserFollow) {
        UserFollow userFollow = new UserFollow();
        userFollow.setFollower(dtoUserFollow.getFollower());
        userFollow.setFollowed(dtoUserFollow.getFollowed());
        return userFollowRepository.save(userFollow);
    }

    public boolean updateUserFollow(Long id, DtoUserFollow dtoUserFollow) {
        Optional<UserFollow> optionalUserFollow = userFollowRepository.findById(id);
        if (optionalUserFollow.isPresent()) {
            UserFollow userFollowToUpdate = optionalUserFollow.get();
            userFollowToUpdate.setFollower(dtoUserFollow.getFollower());
            userFollowToUpdate.setFollowed(dtoUserFollow.getFollowed());
            userFollowRepository.save(userFollowToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteUserFollow(Long id) {
        if (userFollowRepository.existsById(id)) {
            userFollowRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
