package EAM.Blogging.Controller;

import EAM.Blogging.Model.PostTag;
import EAM.Blogging.Service.ServicePostTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/posttag")
public class ControllerPostTag {
    @Autowired
    private ServicePostTag servicePostTag;

    @GetMapping
    public List<PostTag> getAllPostTags() {
        return servicePostTag.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostTag> getPostTagById(@PathVariable Long id) {
        Optional<PostTag> userProfile = servicePostTag.findById(id);
        return userProfile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PostTag createPostTag(@RequestBody PostTag userProfile) {
        return servicePostTag.save(userProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostTag> updatePostTag(@PathVariable Long id, @RequestBody PostTag postTagDetails) {
        Optional<PostTag> postTag = servicePostTag.findById(id);
        if (postTag.isPresent()) {
            PostTag updatedPostTag = postTag.get();
            //No Se Que Poner Aqui
            return ResponseEntity.ok(servicePostTag.save(updatedPostTag));
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostTag> deletePostTag(@PathVariable Long id) {
        if(servicePostTag.findById(id).isPresent()) {
            servicePostTag.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
