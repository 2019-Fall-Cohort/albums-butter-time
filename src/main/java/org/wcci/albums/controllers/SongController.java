package org.wcci.albums.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.albums.entities.Album;
import org.wcci.albums.entities.Artist;
import org.wcci.albums.entities.Song;
import org.wcci.albums.storages.AlbumStorage;
import org.wcci.albums.storages.SongStorage;

@RestController
@RequestMapping("/api/songs")
public class SongController {

	@Autowired
	private SongStorage songStorage;
	
	@Autowired
	private AlbumStorage albumStorage;
	
	@GetMapping("")
	public Iterable<Song> displayAllSongs(){		
		return songStorage.findAllSongs();
	}
	
	@GetMapping("/{id}")
	public Song getSingleSong(@PathVariable Long id) {
		return songStorage.findSongById(id);
	}
	
	@PostMapping("/{albumId}/{songTitle}/{songDuration}")
	public Song addSong(@PathVariable Long albumId, @PathVariable String songTitle, @PathVariable int songDuration) {
		Album album = albumStorage.findAlbumById(albumId);
		Song song = new Song(songTitle, songDuration, album);
		return songStorage.addSong(song);
	}
	
	@DeleteMapping("/{id}/remove")
	public void removeArtist(@PathVariable Long id) {
		Song song = songStorage.findSongById(id);
		songStorage.removeSong(song);
	}
}
