package EAM.Blogging.Controller;

import EAM.Blogging.Model.PostCategory;
import EAM.Blogging.Service.ServicePostCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/postcategory")
public class ControllerPostCategory {
    @Autowired
    private ServicePostCategory servicePostCategory;

    @GetMapping
    public List<PostCategory> getAllPostCategorys() {
        return servicePostCategory.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostCategory> getPostCategoryById(@PathVariable Long id) {
        Optional<PostCategory> userProfile = servicePostCategory.findById(id);
        return userProfile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PostCategory createPostCategory(@RequestBody PostCategory userProfile) {
        return servicePostCategory.save(userProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostCategory> updatePostCategory(@PathVariable Long id, @RequestBody PostCategory postCategoryDetails) {
        Optional<PostCategory> postCategory = servicePostCategory.findById(id);
        if (postCategory.isPresent()) {
            PostCategory updatedPostCategory = postCategory.get();
            //No Se Que Poner Aqui
            return ResponseEntity.ok(servicePostCategory.save(updatedPostCategory));
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostCategory> deletePostCategory(@PathVariable Long id) {
        if(servicePostCategory.findById(id).isPresent()) {
            servicePostCategory.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
