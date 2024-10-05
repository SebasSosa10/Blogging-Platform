package EAM.Blogging.controller;

import EAM.Blogging.model.Role;
import EAM.Blogging.dto.DtoRole;
import EAM.Blogging.service.ServiceRole;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/role")
public class ControllerRole {

    @Autowired
    private ServiceRole serviceRole;

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = serviceRole.findAllRoles();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Role role = serviceRole.findRoleById(id);
        return (role != null) ? ResponseEntity.ok(role) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@Valid @RequestBody DtoRole dtoRole) {
        Role createdRole = serviceRole.createRole(dtoRole);
        return ResponseEntity.ok(createdRole);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRole(@PathVariable Long id, @Valid @RequestBody DtoRole dtoRole) {
        boolean updated = serviceRole.updateRole(id, dtoRole);
        return (updated) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        boolean deleted = serviceRole.deleteRole(id);
        return (deleted) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}