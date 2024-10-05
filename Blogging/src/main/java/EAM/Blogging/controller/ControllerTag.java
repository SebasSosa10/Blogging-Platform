package EAM.Blogging.controller;

import EAM.Blogging.model.Tag;
import EAM.Blogging.dto.DtoTag;
import EAM.Blogging.service.ServiceTag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tag")
public class ControllerTag {

    @Autowired
    private ServiceTag serviceTag;

    @GetMapping
    public ResponseEntity<List<Tag>> getAllTags() {
        List<Tag> tags = serviceTag.findAllTags();
        return ResponseEntity.ok(tags);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> getTagById(@PathVariable Long id) {
        Tag tag = serviceTag.findTagById(id);
        return (tag != null) ? ResponseEntity.ok(tag) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Tag> createTag(@Valid @RequestBody DtoTag dtoTag) {
        Tag createdTag = serviceTag.createTag(dtoTag);
        return ResponseEntity.ok(createdTag);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTag(@PathVariable Long id, @Valid @RequestBody DtoTag dtoTag) {
        boolean updated = serviceTag.updateTag(id, dtoTag);
        return (updated) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
        boolean deleted = serviceTag.deleteTag(id);
        return (deleted) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
