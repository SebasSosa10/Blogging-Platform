package EAM.Blogging.Controller;

import EAM.Blogging.Model.Tag;
import EAM.Blogging.Service.ServiceTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/tag")
public class ControllerTag {
    @Autowired
    private ServiceTag serviceTag;

    @GetMapping
    public List<Tag> getAllTags() {
        return serviceTag.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> getTagById(@PathVariable Long id) {
        Optional<Tag> userProfile = serviceTag.findById(id);
        return userProfile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tag createTag(@RequestBody Tag userProfile) {
        return serviceTag.save(userProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tag> updateTag(@PathVariable Long id, @RequestBody Tag tagDetails) {
        Optional<Tag> tag = serviceTag.findById(id);
        if (tag.isPresent()) {
            Tag updatedTag = tag.get();
            updatedTag.setName(tagDetails.getName());
            return ResponseEntity.ok(serviceTag.save(updatedTag));
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tag> deleteTag(@PathVariable Long id) {
        if(serviceTag.findById(id).isPresent()) {
            serviceTag.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
