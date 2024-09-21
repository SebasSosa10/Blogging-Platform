package EAM.Blogging.Service;

import EAM.Blogging.Dto.DtoUser;
import EAM.Blogging.Model.User;
import EAM.Blogging.Repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUser {
    @Autowired
    private RepositoryUser userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(DtoUser dtoUser) {
        User user = new User();
        user.setEmail(dtoUser.getEmail());
        user.setPassword(dtoUser.getPassword());
        user.setUserProfile(dtoUser.getUserProfile());
        user.setPosts(dtoUser.getPosts());
        user.setComments(dtoUser.getComments());
        user.setRole(dtoUser.getRole());
        return userRepository.save(user);
    }

    public boolean updateUser(Long id, DtoUser dtoUser) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User userToUpdate = optionalUser.get();
            userToUpdate.setEmail(dtoUser.getEmail());
            userToUpdate.setPassword(dtoUser.getPassword());
            userToUpdate.setUserProfile(dtoUser.getUserProfile());
            userToUpdate.setPosts(dtoUser.getPosts());
            userToUpdate.setComments(dtoUser.getComments());
            userToUpdate.setRole(dtoUser.getRole());
            userRepository.save(userToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
