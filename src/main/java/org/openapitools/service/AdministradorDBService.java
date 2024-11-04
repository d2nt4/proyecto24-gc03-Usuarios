package org.openapitools.service;

import org.openapitools.model.Administrador;
import org.openapitools.entity.AdministradorDB;
import org.openapitools.repository.AdministradorDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdministradorDBService {
	private final AdministradorDBRepository adminDBRepository;

	@Autowired
	public AdministradorDBService(AdministradorDBRepository adminDBRepository) {
		this.adminDBRepository = adminDBRepository;
	}

	private Administrador convertToAdministrador(AdministradorDB adminDB) {
		return new Administrador(adminDB);
	}

	// Crear un Administrador
	public boolean postAdministrador(Administrador admin) {
		try {
			AdministradorDB adminDB = new AdministradorDB(admin);
			adminDBRepository.save(adminDB);
			return true; // Devuelve verdadero si se ha creado correctamente
		} catch (Exception e) {
			e.printStackTrace();
			return false; // Devuelve falso si ha habido un error
		}
	}

	// Actualizar un Administrador
	public boolean updateAdministrador(Integer id, Administrador admin) {
		Optional<AdministradorDB> existingAdmin = adminDBRepository.findById(id);
		if (existingAdmin.isPresent()) {
			AdministradorDB updatedAdminDB = existingAdmin.get();
			updatedAdminDB.setNombre(admin.getNombre());
			updatedAdminDB.setApellidos(admin.getApellidos());
			updatedAdminDB.setFechaDeNacimiento(admin.getFechaDeNacimiento());
			updatedAdminDB.setEmail(admin.getEmail());
			updatedAdminDB.setPassword(admin.getPassword());

			adminDBRepository.save(updatedAdminDB);
			return true; // Devuelve verdadero si se ha actualizado correctamente
		}
		return false; //Devuelve falso si no se ha encontrado el administrador
	}

	// Buscar por ID
	public Optional<Administrador> getAdministradorById(Integer id) {
		Optional<AdministradorDB> adminDBOptional = adminDBRepository.findById(id);
		return adminDBOptional.map(this::convertToAdministrador);
	}

	// Obtener todos los administradores
	public List<Administrador> getAllAdministradores() {
		List<AdministradorDB> listaAdminsDB = (List<AdministradorDB>) adminDBRepository.findAll();
		return listaAdminsDB.stream()
				.map(this::convertToAdministrador)
				.collect(Collectors.toList());
	}

	// Borra por ID
	public boolean deleteAdministradorById(Integer id) {
		Optional<AdministradorDB> admin = adminDBRepository.findById(id);
		if (admin.isPresent()) {
			adminDBRepository.deleteById(id);
			return true; // Devuelve verdadero si se ha borrado correctamente
		}
		return false; // Devuelve falso si no se ha encontrado el administrador
	}

	// Borra una entidad de administrador
	public void deleteAdministrador(AdministradorDB admin) {
		adminDBRepository.delete(admin);
	}
}
