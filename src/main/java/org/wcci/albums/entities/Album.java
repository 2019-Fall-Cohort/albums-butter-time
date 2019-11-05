package org.wcci.albums.entities;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Album {

	@Id
	@GeneratedValue
	private Long id;
	@OneToMany
	private List<Song> songList;
	private String publishYear;
	private String title;
	@JsonIgnore
	@ManyToOne
	private Artist artist;
	@ManyToMany
	private List<Rating> ratings;
	@ManyToMany
	private List<Tag> tags;
	@ElementCollection
	private List<Comment> comments;

	protected Album () {}
	
	public Album(String title, Artist artist) {
		this.title = title;
		this.artist = artist;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Artist getArtist() {
		return artist;
	}
	public Long getId() {
		return id;
	}
	
	public List<Song> getSongList() {
		return songList;
	}

	public String getPublishYear() {
		return publishYear;
	}
	
	public List<Rating> getRatings() {
		return ratings;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void addTag(Tag tag) {
		this.tags.add(tag);
	}
	
	public void addRating(Rating rating) {
		this.ratings.add(rating);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


	public void addComment(Comment comment) {
		comments.add(comment);
	}

	public void updateYear(String year) {
		this.publishYear = year;
		
	}

	public void updateTitle(String title) {
		this.title = title;
		
	}
	
}
