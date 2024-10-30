package org.openapitools.services;

import org.openapitools.model.Gestor;
import org.openapitools.modelDB.GestorDB;
import org.openapitools.repositories.GestorDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GestorDBService {
	private final GestorDBRepository gestorDBRepository;

	@Autowired
	public GestorDBService(GestorDBRepository gestorDBRepository) {
		this.gestorDBRepository = gestorDBRepository;
	}

	private Gestor convertToGestor(GestorDB gestorDB) {
		return new Gestor(gestorDB);
	}

	// Create a GestorDB
	public boolean createGestor(Gestor gestor) {
		try {
			// Convert Gestor to GestorDB if needed
			GestorDB gestorDB = new GestorDB(gestor);
			// Save the GestorDB entity
			gestorDBRepository.save(gestorDB);
			return true; // Indicate success
		} catch (Exception e) {
			// Log exception if needed
			return false; // Indicate failure
		}
	}
	// Update a GestorDB
	public boolean updateGestor(Integer id, Gestor gestor) {
		Optional<GestorDB> existingGestor = gestorDBRepository.findById(id);
		if (existingGestor.isPresent()) {
			GestorDB updatedGestorDB = existingGestor.get();
			updatedGestorDB.setNombre(gestor.getNombre());
			updatedGestorDB.setApellidos(gestor.getApellidos());
			updatedGestorDB.setFechaDeNacimiento(gestor.getFechaDeNacimiento());
			updatedGestorDB.setEmail(gestor.getEmail());
			updatedGestorDB.setPassword(gestor.getPassword());

			gestorDBRepository.save(updatedGestorDB); // Save the updated gestor
			return true; // Indicate successful update
		}
		return false; // Indicate that the gestor was not found
	}

	// Read (find by ID)
	public Optional<Gestor> findGestorById(Integer id) {
		Optional<GestorDB> gestorDBOptional = gestorDBRepository.findById(id);
		return gestorDBOptional.map(this::convertToGestor); // Convert if present
	}


	// Read (find all)
	public List<Gestor> findAllGestores() {
		List<GestorDB> gestorDBs = (List<GestorDB>) gestorDBRepository.findAll();
		return gestorDBs.stream()
				.map(this::convertToGestor) // Convert each GestorDB to Gestor
				.collect(Collectors.toList());
	}

	// Delete by ID
	public boolean deleteGestorById(Integer id) {
		Optional<GestorDB> gestor = gestorDBRepository.findById(id);
		if (gestor.isPresent()) {
			gestorDBRepository.deleteById(id); // Delete the gestor from the repository
			return true; // Indicate successful deletion
		}
		return false; // Indicate that the gestor was not found
	}

	// Delete (by entity)
	public void deleteGestor(GestorDB gestor) {
		gestorDBRepository.delete(gestor);
	}
}
