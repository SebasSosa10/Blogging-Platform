package EAM.Blogging.Service;

import EAM.Blogging.Model.Role;
import EAM.Blogging.Repository.RepositoryRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceRole {
    @Autowired
    private RepositoryRole repositoryRole;

    public List<Role> findAll() {
        return repositoryRole.findAll();
    }

    public Optional<Role> findById(Long id) {
        return repositoryRole.findById(id);
    }

    public Role save(Role role) {
        return repositoryRole.save(role);
    }

    public void deleteById(Long id) {
        repositoryRole.deleteById(id);
    }
}
