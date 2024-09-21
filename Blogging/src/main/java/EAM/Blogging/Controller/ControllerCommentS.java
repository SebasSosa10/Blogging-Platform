package EAM.Blogging.Controller;

import EAM.Blogging.Model.CommentS;
import EAM.Blogging.Dto.DtoCommentS;
import EAM.Blogging.Service.ServiceCommentS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("api/comments")
public class ControllerCommentS {

    @Autowired
    private ServiceCommentS serviceComments;

    @GetMapping
    public List<CommentS> getAllComments() {
        return serviceComments.findAllComments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentS> getCommentById(@PathVariable Long id) {
        CommentS comment = serviceComments.searchComment(id);
        return comment != null ? ResponseEntity.ok(comment) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CommentS> createComment(@RequestBody DtoCommentS dtoCommentS) {
        CommentS createdComment = serviceComments.createComment(dtoCommentS);
        return ResponseEntity.ok(createdComment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentS> updateComment(@PathVariable Long id, @RequestBody DtoCommentS dtoCommentS) {
        boolean updated = serviceComments.updateComment(id, dtoCommentS);
        return updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        boolean deleted = serviceComments.deleteComment(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
