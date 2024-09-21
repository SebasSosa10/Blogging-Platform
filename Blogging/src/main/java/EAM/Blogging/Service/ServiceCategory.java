package EAM.Blogging.Service;

import EAM.Blogging.Model.Category;
import EAM.Blogging.Dto.DtoCategory;
import EAM.Blogging.Repository.RepositoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCategory {

    @Autowired
    private RepositoryCategory categoryRepository;

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Category searchCategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category createCategory(DtoCategory dtoCategory) {
        Category category = new Category();
        category.setName(dtoCategory.getName());
        category.setDescription(dtoCategory.getDescription());
        category.setPostCategories(dtoCategory.getPostCategories());
        return categoryRepository.save(category);
    }

    public boolean updateCategory(Long id, DtoCategory dtoCategory) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category categoryToUpdate = optionalCategory.get();
            categoryToUpdate.setName(dtoCategory.getName());
            categoryToUpdate.setDescription(dtoCategory.getDescription());
            categoryToUpdate.setPostCategories(dtoCategory.getPostCategories());
            categoryRepository.save(categoryToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
