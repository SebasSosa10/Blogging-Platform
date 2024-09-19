package EAM.Blogging.Service;

import EAM.Blogging.Model.CommentS;
import EAM.Blogging.Repository.RepositoryComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceComments {
    @Autowired
    private RepositoryComments repositoryComments;

    public List<CommentS> findAll() {
        return repositoryComments.findAll();
    }

    public Optional<CommentS> findById(Long id) {
        return repositoryComments.findById(id);
    }

    public CommentS save(CommentS comment) {
        return repositoryComments.save(comment);
    }

    public void deleteById(Long id) {
        repositoryComments.deleteById(id);
    }
}
