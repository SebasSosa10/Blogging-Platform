package EAM.Blogging.controller;

import EAM.Blogging.model.PostCategory;
import EAM.Blogging.dto.DtoPostCategory;
import EAM.Blogging.service.ServicePostCategory;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/postcategory")
public class ControllerPostCategory {

    @Autowired
    private ServicePostCategory servicePostCategory;

    @GetMapping
    public List<PostCategory> getAllPostCategories() {
        return servicePostCategory.findAllPostCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostCategory> getPostCategoryById(@PathVariable Long id) {
        PostCategory postCategory = servicePostCategory.findPostCategoryById(id);
        return postCategory != null ? ResponseEntity.ok(postCategory) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PostCategory> createPostCategory(@Valid @RequestBody DtoPostCategory dtoPostCategory) {
        PostCategory createdPostCategory = servicePostCategory.createPostCategory(dtoPostCategory);
        return ResponseEntity.ok(createdPostCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostCategory> updatePostCategory(@PathVariable Long id, @Valid @RequestBody DtoPostCategory dtoPostCategory) {
        boolean updated = servicePostCategory.updatePostCategory(id, dtoPostCategory);
        return updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostCategory(@PathVariable Long id) {
        boolean deleted = servicePostCategory.deletePostCategory(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
