package EAM.Blogging.Service;

import EAM.Blogging.Model.User;
import EAM.Blogging.Repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUser {
    @Autowired
    private RepositoryUser repositoryUser;

    public List<User> findAll() {
        return repositoryUser.findAll();

    }

    public Optional<User> findById(Long id) {
        return repositoryUser.findById(id);
    }

    public User save(User user) {
        return repositoryUser.save(user);
    }

    public void deleteById(Long id) {
        repositoryUser.deleteById(id);
    }
}
