package EAM.Blogging.service;

import EAM.Blogging.model.CommentS;
import EAM.Blogging.dto.DtoCommentS;
import EAM.Blogging.repository.RepositoryCommentS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCommentS {
    @Autowired
    private RepositoryCommentS commentRepository;

    public List<CommentS> findAllComments() {
        return commentRepository.findAll();
    }

    public CommentS searchComment(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public CommentS createComment(DtoCommentS dtoCommentS) {
        CommentS comment = new CommentS();
        comment.setContent(dtoCommentS.getContent());
        comment.setApproved(dtoCommentS.isApproved());
        comment.setPublisheddate(dtoCommentS.getPublishedDate());
        comment.setUser(dtoCommentS.getUser());
        comment.setPost(dtoCommentS.getPost());
        return commentRepository.save(comment);
    }

    public boolean updateComment(Long id, DtoCommentS dtoCommentS) {
        Optional<CommentS> optionalComment = commentRepository.findById(id);
        if (optionalComment.isPresent()) {
            CommentS commentToUpdate = optionalComment.get();
            commentToUpdate.setContent(dtoCommentS.getContent());
            commentToUpdate.setApproved(dtoCommentS.isApproved());
            commentToUpdate.setPublisheddate(dtoCommentS.getPublishedDate());
            commentToUpdate.setUser(dtoCommentS.getUser());
            commentToUpdate.setPost(dtoCommentS.getPost());
            commentRepository.save(commentToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteComment(Long id) {
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
