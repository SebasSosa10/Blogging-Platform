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
        //Por revisar - Uso el optional como por ver como sirve mas que todo
        //En el documento pone que las etiquetas y categoria se pone inmediato pero como no es una aplicacion con interfaz lo dejo asi
        if(optionalUser.isPresent() && optionalUser.get().getRole().getName().equals("AUTHOR")){
            post.setTitle(dtoPost.getTitle());
            post.setContent(dtoPost.getContent());
            post.setPublisheddate(dtoPost.getPublisheddate());
            post.setUser(optionalUser.get());
            post.setIsPublished(dtoPost.isPublished());
            return postRepository.save(post);
        }
        //No se si este bien asi??
        return null;
    }

    //Añadir verificacion de si es el mismo autor
    public boolean updatePost(Long id, DtoPost dtoPost) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post postToUpdate = optionalPost.get();
            postToUpdate.setTitle(dtoPost.getTitle());
            postToUpdate.setContent(dtoPost.getContent());
            postToUpdate.setLikes(dtoPost.getLikes());
            postToUpdate.setPublisheddate(dtoPost.getPublisheddate());
            postToUpdate.setUser(dtoPost.getUser());
            postToUpdate.setIsPublished(dtoPost.isPublished());
            postRepository.save(postToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public boolean deletePost(Long id) {
        //Verificar el usuario?
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    //a
    public boolean changePostState(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        //Verificar si es el autor? no se bien como hacer este
        if (optionalPost.isPresent()) {
            Post postToUpdate = optionalPost.get();
            postToUpdate.setIsPublished(!postToUpdate.getIsPublished());
            postRepository.save(postToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public Post addUserLike(Long idPost, Long idUser) {
        Optional<Post> optionalPost = postRepository.findById(idPost);
        if (optionalPost.isPresent()) {
            Post postToUpdate = optionalPost.get();
            //Con fe
            postToUpdate.addLike();
            postRepository.save(postToUpdate);
            return optionalPost.get();
        } else {
            return null;
        }
    }
}
