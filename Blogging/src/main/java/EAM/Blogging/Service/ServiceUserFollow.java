package EAM.Blogging.Service;

import EAM.Blogging.Model.UserFollow;
import EAM.Blogging.Repository.RepositoryUserFollow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUserFollow {
    @Autowired
    private RepositoryUserFollow repositoryUserFollow;

    public List<UserFollow> findAll() {
        return repositoryUserFollow.findAll();

    }

    public Optional<UserFollow> findById(Long id) {
        return repositoryUserFollow.findById(id);
    }

    public UserFollow save(UserFollow userFollow) {
        return repositoryUserFollow.save(userFollow);
    }

    public void deleteById(Long id) {
        repositoryUserFollow.deleteById(id);
    }
}
