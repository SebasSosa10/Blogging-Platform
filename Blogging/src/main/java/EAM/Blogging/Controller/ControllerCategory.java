package EAM.Blogging.Controller;

import EAM.Blogging.Model.Category;
import EAM.Blogging.Dto.DtoCategory;
import EAM.Blogging.Service.ServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("api/category")
public class ControllerCategory {

    @Autowired
    private ServiceCategory serviceCategory;

    @GetMapping
    public List<Category> getAllCategories() {
        return serviceCategory.findAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = serviceCategory.searchCategory(id);
        return category != null ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody DtoCategory dtoCategory) {
        Category createdCategory = serviceCategory.createCategory(dtoCategory);
        return ResponseEntity.ok(createdCategory);  // Retornar la categoría creada
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody DtoCategory dtoCategory) {
        boolean updated = serviceCategory.updateCategory(id, dtoCategory);
        return updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        boolean deleted = serviceCategory.deleteCategory(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
