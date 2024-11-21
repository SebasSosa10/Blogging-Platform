package EAM.Blogging.service;

import EAM.Blogging.model.CommentS;
import EAM.Blogging.dto.DtoCommentS;
import EAM.Blogging.repository.RepositoryCommentS;
import EAM.Blogging.repository.RepositoryUser;
import EAM.Blogging.repository.RepositoryPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCommentS {
    @Autowired
    private RepositoryCommentS commentRepository;

    @Autowired
    private RepositoryUser userRepository;

    @Autowired
    private RepositoryPost postRepository;

    public List<CommentS> findAllComments() {
        return commentRepository.findAll();
    }

    public CommentS searchComment(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public CommentS createComment(DtoCommentS dtoCommentS) {
        if (userRepository.existsById(dtoCommentS.getUser().getIdUser())) {
            if (postRepository.existsById(dtoCommentS.getPost().getIdPost())) {
                CommentS comment = new CommentS();
                comment.setContent(dtoCommentS.getContent());
                comment.setApproved(dtoCommentS.isApproved());
                comment.setPublisheddate(dtoCommentS.getPublishedDate());
                comment.setUser(dtoCommentS.getUser());
                comment.setPost(dtoCommentS.getPost());
                return commentRepository.save(comment);
            }
        }
        return null;
    }

    public boolean updateComment(Long id, DtoCommentS dtoCommentS) {
        Optional<CommentS> optionalComment = commentRepository.findById(id);
        if (optionalComment.isPresent()) {
            if (userRepository.existsById(dtoCommentS.getUser().getIdUser())) {
                if (postRepository.existsById(dtoCommentS.getPost().getIdPost())) {
                    CommentS commentToUpdate = optionalComment.get();
                    commentToUpdate.setContent(dtoCommentS.getContent());
                    commentToUpdate.setApproved(dtoCommentS.isApproved());
                    commentToUpdate.setPublisheddate(dtoCommentS.getPublishedDate());
                    commentToUpdate.setUser(dtoCommentS.getUser());
                    commentToUpdate.setPost(dtoCommentS.getPost());
                    commentRepository.save(commentToUpdate);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteComment(Long commentId, Long currentUserId, String currentUserRole) {
        Optional<CommentS> optionalComment = commentRepository.findById(commentId);
        if (optionalComment.isPresent()) {
            CommentS comment = optionalComment.get();
            if (comment.getUser().getIdUser().equals(currentUserId) || "ADMIN".equalsIgnoreCase(currentUserRole)) {
                commentRepository.deleteById(commentId);
                return true;
            }
        }
        return false;
    }

}