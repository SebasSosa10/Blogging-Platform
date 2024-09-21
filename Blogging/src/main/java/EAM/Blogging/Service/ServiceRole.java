package EAM.Blogging.Service;

import EAM.Blogging.Dto.DtoRole;
import EAM.Blogging.Model.Role;
import EAM.Blogging.Repository.RepositoryRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceRole {
    @Autowired
    private RepositoryRole roleRepository;

    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    public Role findRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public Role createRole(DtoRole dtoRole) {
        Role role = new Role();
        role.setName(dtoRole.getName());
        role.setUser(dtoRole.getUser());
        return roleRepository.save(role);
    }

    public boolean updateRole(Long id, DtoRole dtoRole) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            Role roleToUpdate = optionalRole.get();
            roleToUpdate.setName(dtoRole.getName());
            roleToUpdate.setUser(dtoRole.getUser());
            roleRepository.save(roleToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteRole(Long id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
