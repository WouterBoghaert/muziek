package be.vdab.services;

import java.util.List;
import java.util.Optional;

import be.vdab.entities.Album;
import be.vdab.repositories.AlbumRepository;

public class AlbumService extends AbstractService {
	private final AlbumRepository albumRepository = new AlbumRepository();
	
	public List<Album> findAllMetArtiest() {
		return albumRepository.findAllMetArtiest();
	}
	
	public Optional<Album> readMetArtiestEnTracks(long id) {
		return albumRepository.readMetArtiestEnTracks(id);
	}
}
