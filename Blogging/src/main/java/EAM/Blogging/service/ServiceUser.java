package EAM.Blogging.service;

import EAM.Blogging.dto.DtoUser;
import EAM.Blogging.model.User;
import EAM.Blogging.repository.RepositoryUser;
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
        user.setPosts(dtoUser.getPosts());
        user.setUserName(dtoUser.getUserName());
        user.setBiography(dtoUser.getBiography());
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
            userToUpdate.setBiography(dtoUser.getBiography());
            userToUpdate.setUserName(dtoUser.getUserName());
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

    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
