package EAM.Blogging.Controller;

import EAM.Blogging.Model.Category;
import EAM.Blogging.Service.ServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/category")
public class ControllerCategory {
    @Autowired
    private ServiceCategory serviceCategory;

    @GetMapping
    public List<Category> getAllCategorys() {
        return serviceCategory.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Optional<Category> userProfile = serviceCategory.findById(id);
        return userProfile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Category createCategory(@RequestBody Category userProfile) {
        return serviceCategory.save(userProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
        Optional<Category> category = serviceCategory.findById(id);
        if (category.isPresent()) {
            Category updatedCategory = category.get();
            updatedCategory.setDescription(categoryDetails.getDescription());
            updatedCategory.setName(categoryDetails.getName());
            return ResponseEntity.ok(serviceCategory.save(updatedCategory));
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {
        if(serviceCategory.findById(id).isPresent()) {
            serviceCategory.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
