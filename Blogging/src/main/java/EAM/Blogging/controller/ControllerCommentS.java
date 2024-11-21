package EAM.Blogging.controller;

import EAM.Blogging.model.CommentS;
import EAM.Blogging.dto.DtoCommentS;
import EAM.Blogging.service.ServiceCommentS;
import jakarta.validation.Valid;
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
    public ResponseEntity<?> createComment(@Valid @RequestBody DtoCommentS dtoCommentS) {
        try {
            CommentS createdComment = serviceComments.createComment(dtoCommentS);
            return ResponseEntity.ok(createdComment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateComment(@PathVariable Long id, @Valid @RequestBody DtoCommentS dtoCommentS) {
        try {
            boolean updated = serviceComments.updateComment(id, dtoCommentS);
            return updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(
            @PathVariable Long id,
            @RequestParam Long currentUserId,
            @RequestParam String currentUserRole) {
        boolean deleted = serviceComments.deleteComment(id, currentUserId, currentUserRole);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.status(403).build(); // 403 Forbidden si no tiene permisos
    }
}
