package org.openapitools.service;

import org.openapitools.model.Gestor;
import org.openapitools.entity.GestorDB;
import org.openapitools.repository.GestorDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GestorDBService {
	private final GestorDBRepository gestorDBRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public GestorDBService(GestorDBRepository gestorDBRepository, PasswordEncoder passwordEncoder) {
		this.gestorDBRepository = gestorDBRepository;
		this.passwordEncoder = passwordEncoder;
	}

	private Gestor convertToGestor(GestorDB gestorDB) {
		return new Gestor(gestorDB);
	}

	public boolean createGestor(Gestor gestor) {
		try {
			GestorDB gestorDB = new GestorDB(gestor);
			String encodedPassword = passwordEncoder.encode(gestor.getPassword());

			gestorDB.setPassword(encodedPassword);
			gestorDBRepository.save(gestorDB);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateGestor(Integer id, Gestor gestor) {
		Optional<GestorDB> existingGestor = gestorDBRepository.findById(id);
		if (existingGestor.isPresent()) {
			GestorDB updatedGestorDB = existingGestor.get();
			updatedGestorDB.setNombre(gestor.getNombre());
			updatedGestorDB.setApellidos(gestor.getApellidos());
			updatedGestorDB.setFechaDeNacimiento(gestor.getFechaDeNacimiento());
			updatedGestorDB.setEmail(gestor.getEmail());
			updatedGestorDB.setPassword(gestor.getPassword());

			gestorDBRepository.save(updatedGestorDB);
			return true;
		}
		return false;
	}

	public Optional<Gestor> findGestorById(Integer id) {
		Optional<GestorDB> gestorDBOptional = gestorDBRepository.findById(id);
		return gestorDBOptional.map(this::convertToGestor);
	}

	public List<Gestor> findAllGestores() {
		List<GestorDB> gestorDBs = (List<GestorDB>) gestorDBRepository.findAll();
		return gestorDBs.stream()
				.map(this::convertToGestor)
				.collect(Collectors.toList());
	}

	public boolean deleteGestorById(Integer id) {
		Optional<GestorDB> gestor = gestorDBRepository.findById(id);
		if (gestor.isPresent()) {
			gestorDBRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public void deleteGestor(GestorDB gestor) {
		gestorDBRepository.delete(gestor);
	}
}
