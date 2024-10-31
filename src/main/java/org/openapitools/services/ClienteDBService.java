package org.openapitools.services;

import org.openapitools.model.Cliente;
import org.openapitools.modelDB.ClienteDB;
import org.openapitools.repositories.ClienteDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteDBService {

	private final ClienteDBRepository clienteDBRepository;

	@Autowired
	public ClienteDBService(ClienteDBRepository clienteDBRepository) {
		this.clienteDBRepository = clienteDBRepository;
	}

	private Cliente convertToCliente(ClienteDB clienteDB) {
		return new Cliente(clienteDB);
	}

	// Create a new Cliente
	public boolean createCliente(Cliente Cliente) {
		try {
			// Convert Cliente to ClienteDB
			ClienteDB ClienteDB = new ClienteDB(Cliente);
			// Save the ClienteDB entity
			clienteDBRepository.save(ClienteDB);
			return true; // Indicate success
		} catch (Exception e) {
			// Log exception if needed
			return false; // Indicate failure
		}
	}

	// Update an existing ClienteDB
	public boolean updateCliente(Integer id, Cliente Cliente) {
		Optional<ClienteDB> existingCliente = clienteDBRepository.findById(id);
		if (existingCliente.isPresent()) {
			ClienteDB updatedClienteDB = existingCliente.get();
			updatedClienteDB.setNombre(Cliente.getNombre());
			updatedClienteDB.setApellidos(Cliente.getApellidos());
			updatedClienteDB.setFechaDeNacimiento(LocalDate.parse(Cliente.getFechaDeNacimiento()));
			updatedClienteDB.setEmail(Cliente.getEmail());
			updatedClienteDB.setPassword(Cliente.getPassword());

			clienteDBRepository.save(updatedClienteDB); // Save the updated ClienteDB
			return true; // Indicate successful update
		}
		return false; // Indicate that the Cliente was not found
	}

	// Read (find by ID)
	public Optional<Cliente> findClienteById(Integer id) {
		Optional<ClienteDB> ClienteDBOptional = clienteDBRepository.findById(id);
		return ClienteDBOptional.map(this::convertToCliente); // Convert if present
	}

	// Read (find all)
	public List<Cliente> findAllClientes() {
		List<ClienteDB> ClienteDBs = (List<ClienteDB>) clienteDBRepository.findAll();
		return ClienteDBs.stream().map(this::convertToCliente) // Convert each ClienteDB to Cliente
				.collect(Collectors.toList());
	}

	// Delete by ID
	public boolean deleteClienteById(Integer id) {
		Optional<ClienteDB> Cliente = clienteDBRepository.findById(id);
		if (Cliente.isPresent()) {
			clienteDBRepository.deleteById(id); // Delete the ClienteDB from the repository
			return true; // Indicate successful deletion
		}
		return false; // Indicate that the Cliente was not found
	}

}
