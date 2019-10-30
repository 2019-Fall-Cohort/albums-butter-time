package org.wcci.albums.storages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.wcci.albums.entities.Tag;
import org.wcci.albums.repositories.TagRepository;

@Service 
public class TagStorage {

	@Autowired
	private TagRepository tagRepo;
	
	public void addTag(Tag tag) {
		tagRepo.save(tag);
	}
		
	public void removeTag(Tag tag) {
		tagRepo.delete(tag);
	}

	public Iterable<Tag> findAllTags() {
		return tagRepo.findAll();
	}
	
	public Tag findTagById(Long id) {
		return tagRepo.findById(id).get();
	}

}