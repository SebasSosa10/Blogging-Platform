package EAM.Blogging.Controller;

import EAM.Blogging.Model.CommentS;
import EAM.Blogging.Service.ServiceComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/comments")
public class ControllerComments {
    @Autowired
    private ServiceComments serviceComments;

    @GetMapping
    public List<CommentS> getAllCommentSs() {
        return serviceComments.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentS> getCommentSById(@PathVariable Long id) {
        Optional<CommentS> userProfile = serviceComments.findById(id);
        return userProfile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CommentS createCommentS(@RequestBody CommentS userProfile) {
        return serviceComments.save(userProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentS> updateCommentS(@PathVariable Long id, @RequestBody CommentS commentSDetails) {
        Optional<CommentS> commentS = serviceComments.findById(id);
        if (commentS.isPresent()) {
            CommentS updatedCommentS = commentS.get();
            updatedCommentS.setContent(commentSDetails.getContent());
            updatedCommentS.setPublisheddate(commentSDetails.getPublisheddate());
            updatedCommentS.setApproved(commentSDetails.isApproved());
            return ResponseEntity.ok(serviceComments.save(updatedCommentS));
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommentS> deleteCommentS(@PathVariable Long id) {
        if(serviceComments.findById(id).isPresent()) {
            serviceComments.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
