package EAM.Blogging.Service;

import EAM.Blogging.Model.PostTag;
import EAM.Blogging.Repository.RepositoryPostTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePostTag {

    @Autowired
    private RepositoryPostTag repositoryPostTag;

    public List<PostTag> findAll() {
        return repositoryPostTag.findAll();
    }

    public Optional<PostTag> findById(Long id) {
        return repositoryPostTag.findById(id);
    }

    public PostTag save(PostTag postTag) {
        return repositoryPostTag.save(postTag);
    }

    public void deleteById(Long id) {
        repositoryPostTag.deleteById(id);
    }
}
