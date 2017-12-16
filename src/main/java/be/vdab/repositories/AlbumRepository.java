package be.vdab.repositories;

import java.util.List;
import java.util.Optional;

import be.vdab.entities.Album;

public class AlbumRepository extends AbstractRepository {

	public List<Album> findAllMetArtiest () {
		return getEntityManager().createNamedQuery("Album.findAll", Album.class)
			.setHint("javax.persistence.loadgraph", 
				getEntityManager().createEntityGraph(Album.MET_ARTIEST))
			.getResultList();
	}
	
	public Optional<Album> readMetArtiestEnTracks (long id) {
		return Optional.ofNullable(getEntityManager()
			.createNamedQuery("Album.findById", Album.class)
			.setParameter("id", id)
			.setHint("javax.persistence.loadgraph", 
				getEntityManager().createEntityGraph(Album.MET_ARTIEST_EN_TRACKS))
			.getSingleResult());
	}
} 
