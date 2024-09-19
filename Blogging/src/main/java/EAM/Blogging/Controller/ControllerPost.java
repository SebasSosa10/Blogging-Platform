package EAM.Blogging.Controller;

import EAM.Blogging.Model.Post;
import EAM.Blogging.Service.ServicePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/post")
public class ControllerPost {
    @Autowired
    private ServicePost servicePost;

    @GetMapping
    public List<Post> getAllPosts() {
        return servicePost.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Optional<Post> userProfile = servicePost.findById(id);
        return userProfile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Post createPost(@RequestBody Post userProfile) {
        return servicePost.save(userProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post postDetails) {
        Optional<Post> post = servicePost.findById(id);
        if (post.isPresent()) {
            Post updatedPost = post.get();
            updatedPost.setTitle(postDetails.getTitle());
            updatedPost.setContent(postDetails.getContent());
            updatedPost.setLikes(postDetails.getLikes());
            updatedPost.setPublisheddate(postDetails.getPublisheddate());
            return ResponseEntity.ok(servicePost.save(updatedPost));
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable Long id) {
        if(servicePost.findById(id).isPresent()) {
            servicePost.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
