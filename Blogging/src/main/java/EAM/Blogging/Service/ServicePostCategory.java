package EAM.Blogging.Service;

import EAM.Blogging.Model.PostCategory;
import EAM.Blogging.Model.PostTag;
import EAM.Blogging.Repository.RepositoryPostCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePostCategory {
    @Autowired
    private RepositoryPostCategory repositoryPostCategory;

    public List<PostCategory> findAll() {
        return repositoryPostCategory.findAll();
    }

    public Optional<PostCategory> findById(Long id) {
        return repositoryPostCategory.findById(id);
    }

    public PostCategory save(PostCategory postCategory) {
        return repositoryPostCategory.save(postCategory);
    }

    public void deleteById(Long id) {
        repositoryPostCategory.deleteById(id);
    }
}
