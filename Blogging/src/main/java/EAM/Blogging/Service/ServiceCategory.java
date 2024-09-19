package EAM.Blogging.Service;

import EAM.Blogging.Model.Category;
import EAM.Blogging.Repository.RepositoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCategory {
    @Autowired
    private RepositoryCategory repositoryCategory;

    public List<Category> findAll() {
        return repositoryCategory.findAll();
    }

    public Optional<Category> findById(Long id) {
        return repositoryCategory.findById(id);
    }

    public Category save(Category category) {
        return repositoryCategory.save(category);
    }

    public void deleteById(Long id) {
        repositoryCategory.deleteById(id);
    }
}
