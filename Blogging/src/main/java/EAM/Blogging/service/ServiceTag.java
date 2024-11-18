package EAM.Blogging.service;

import EAM.Blogging.model.Tag;
import EAM.Blogging.dto.DtoTag;
import EAM.Blogging.repository.RepositoryTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ServiceTag {
    @Autowired
    private RepositoryTag tagRepository;

    public List<Tag> findAllTags() {
        return tagRepository.findAll();
    }

    public Tag findTagById(Long id) {
        return tagRepository.findById(id).orElse(null);
    }

    public Tag createTag(DtoTag dtoTag) {
        Tag tag = new Tag();
        tag.setName(dtoTag.getName());
        return tagRepository.save(tag);
    }

    public boolean updateTag(Long id, DtoTag dtoTag) {
        Optional<Tag> optionalTag = tagRepository.findById(id);
        if (optionalTag.isPresent()) {
            Tag tagToUpdate = optionalTag.get();
            tagToUpdate.setName(dtoTag.getName());
            tagRepository.save(tagToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteTag(Long id) {
        if (tagRepository.existsById(id)) {
            tagRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
