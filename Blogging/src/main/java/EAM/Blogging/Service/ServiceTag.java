package EAM.Blogging.Service;

import EAM.Blogging.Model.Tag;
import EAM.Blogging.Repository.RepositoryTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTag {
    @Autowired
    private RepositoryTag repositoryTag;

    public List<Tag> findAll() {
        return repositoryTag.findAll();

    }

    public Optional<Tag> findById(Long id) {
        return repositoryTag.findById(id);
    }

    public Tag save(Tag tag) {
        return repositoryTag.save(tag);
    }

    public void deleteById(Long id) {
        repositoryTag.deleteById(id);
    }
}
