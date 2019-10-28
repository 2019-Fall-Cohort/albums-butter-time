package org.wcci.albums;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	private int publishYear;
	private String title;
	@JsonIgnore
	@ManyToOne
	private Artist artist;

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

	public int getPublishYear() {
		return publishYear;
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
	
	
}
