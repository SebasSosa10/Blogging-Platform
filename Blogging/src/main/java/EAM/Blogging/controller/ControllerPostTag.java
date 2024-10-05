package EAM.Blogging.controller;

import EAM.Blogging.model.PostTag;
import EAM.Blogging.dto.DtoPostTag;
import EAM.Blogging.service.ServicePostTag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/posttag")
public class ControllerPostTag {

    @Autowired
    private ServicePostTag servicePostTag;

    @GetMapping
    public List<PostTag> getAllPostTags() {
        return servicePostTag.findAllPostTags();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostTag> getPostTagById(@PathVariable Long id) {
        PostTag postTag = servicePostTag.findPostTagById(id);
        return postTag != null ? ResponseEntity.ok(postTag) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PostTag> createPostTag(@Valid @RequestBody DtoPostTag dtoPostTag) {
        PostTag createdPostTag = servicePostTag.createPostTag(dtoPostTag);
        return ResponseEntity.ok(createdPostTag);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostTag> updatePostTag(@PathVariable Long id, @Valid @RequestBody DtoPostTag dtoPostTag) {
        boolean updated = servicePostTag.updatePostTag(id, dtoPostTag);
        return updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostTag(@PathVariable Long id) {
        boolean deleted = servicePostTag.deletePostTag(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
