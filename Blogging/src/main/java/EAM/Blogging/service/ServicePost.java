package EAM.Blogging.service;

import EAM.Blogging.dto.DtoPost;
import EAM.Blogging.model.Post;
import EAM.Blogging.model.User;
import EAM.Blogging.repository.RepositoryPost;
import EAM.Blogging.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePost {
    @Autowired
    private RepositoryPost postRepository;
    @Autowired
    private RepositoryUser userRepository;

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public Post findPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }


    public Post createPost(DtoPost dtoPost) {
        Post post = new Post();
        Optional<User> optionalUser = userRepository.findById(dtoPost.getUser().getIdUser());
        if(optionalUser.isPresent() && optionalUser.get().getRole().getName().equals("AUTHOR")){
            post.setTitle(dtoPost.getTitle());
            post.setContent(dtoPost.getContent());
            post.setPublisheddate(dtoPost.getPublisheddate());
            post.setUser(optionalUser.get());
            post.setIsPublished(dtoPost.isPublished());
            return postRepository.save(post);
        }
        return null;
    }


    public boolean updatePost(Long id, DtoPost dtoPost) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            if(optionalPost.get().getUser().equals(dtoPost.getUser())){
                Post postToUpdate = optionalPost.get();
                postToUpdate.setTitle(dtoPost.getTitle());
                postToUpdate.setContent(dtoPost.getContent());
                postToUpdate.setLikes(dtoPost.getLikes());
                postToUpdate.setPublisheddate(dtoPost.getPublisheddate());
                postToUpdate.setUser(dtoPost.getUser());
                postToUpdate.setIsPublished(dtoPost.isPublished());
                postRepository.save(postToUpdate);
                return true;
            }
        }
        return false;
    }

    public boolean deletePost(Long id, Long idUser) {
        Optional<User> optionalUser = userRepository.findById(idUser);
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalUser.isPresent() && optionalPost.isPresent() &&
                (optionalUser.get().equals(optionalPost.get().getUser()) || optionalUser.get().getRole().getName().equals("ADMIN"))) {
            postRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    //a
    public boolean changePostState(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post postToUpdate = optionalPost.get();
            postToUpdate.setIsPublished(!postToUpdate.getIsPublished());
            postRepository.save(postToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public Post addPostLike(Long idPost) {
        Optional<Post> optionalPost = postRepository.findById(idPost);
        if (optionalPost.isPresent()) {
            Post postToUpdate = optionalPost.get();
            postToUpdate.addLike();
            postRepository.save(postToUpdate);
            return optionalPost.get();
        } else {
            return null;
        }
    }
}
