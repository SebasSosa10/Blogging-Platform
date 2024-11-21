package EAM.Blogging.controller;

import EAM.Blogging.model.Post;
import EAM.Blogging.dto.DtoPost;
import EAM.Blogging.service.ServicePost;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/post")
public class ControllerPost {

    @Autowired
    private ServicePost servicePost;

    @GetMapping
    public List<Post> getAllPosts() {
        return servicePost.findAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = servicePost.findPostById(id);
        return post != null ? ResponseEntity.ok(post) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@Valid @RequestBody DtoPost dtoPost) {
        Post createdPost = servicePost.createPost(dtoPost);
        return ResponseEntity.ok(createdPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @Valid @RequestBody DtoPost dtoPost) {
        boolean updated = servicePost.updatePost(id, dtoPost);
        return updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/published/{id}")
    public ResponseEntity<Post> publishPost(@PathVariable Long id) {
        boolean updated = servicePost.changePostState(id);
        return updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id, @Valid @RequestBody Long userId) {
        boolean deleted = servicePost.deletePost(id, userId);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/like/{id}")
    public ResponseEntity<Void> likePost(@PathVariable Long id){
        Post likedPost = servicePost.addPostLike(id);
        return likedPost != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
