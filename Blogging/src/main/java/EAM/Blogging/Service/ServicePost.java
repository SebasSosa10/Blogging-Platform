package EAM.Blogging.Service;

import EAM.Blogging.Model.Post;
import EAM.Blogging.Repository.RepositoryPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePost {
    @Autowired
    private RepositoryPost repositoryPost;

    public List<Post> findAll() {
        return repositoryPost.findAll();
    }

    public Optional<Post> findById(Long id) {
        return repositoryPost.findById(id);
    }

    public Post save(Post postCategory) {
        return repositoryPost.save(postCategory);
    }

    public void deleteById(Long id) {
        repositoryPost.deleteById(id);
    }
}
