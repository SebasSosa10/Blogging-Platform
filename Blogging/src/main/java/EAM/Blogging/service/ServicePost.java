package EAM.Blogging.service;

import EAM.Blogging.dto.DtoPost;
import EAM.Blogging.model.Post;
import EAM.Blogging.repository.RepositoryPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePost {
    @Autowired
    private RepositoryPost postRepository;

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public Post findPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }


    public Post createPost(DtoPost dtoPost) {
        Post post = new Post();
        post.setTitle(dtoPost.getTitle());
        post.setContent(dtoPost.getContent());
        post.setLikes(dtoPost.getLikes());
        post.setPublisheddate(dtoPost.getPublisheddate());
        post.setUser(dtoPost.getUser());
        post.setState(dtoPost.getState());
        post.setPostTags(dtoPost.getPostTags());
        post.setComments(dtoPost.getComments());
        return postRepository.save(post);
    }


    public boolean updatePost(Long id, DtoPost dtoPost) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post postToUpdate = optionalPost.get();
            postToUpdate.setTitle(dtoPost.getTitle());
            postToUpdate.setContent(dtoPost.getContent());
            postToUpdate.setLikes(dtoPost.getLikes());
            postToUpdate.setPublisheddate(dtoPost.getPublisheddate());
            postToUpdate.setUser(dtoPost.getUser());
            postToUpdate.setState(dtoPost.getState());
            postToUpdate.setPostTags(dtoPost.getPostTags());
            postToUpdate.setComments(dtoPost.getComments());
            postRepository.save(postToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public boolean deletePost(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
