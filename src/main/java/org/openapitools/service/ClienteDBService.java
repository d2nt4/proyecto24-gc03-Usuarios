package org.openapitools.service;

import org.openapitools.model.Cliente;
import org.openapitools.entity.ClienteDB;
import org.openapitools.repository.ClienteDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteDBService {
	private final ClienteDBRepository clienteDBRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public ClienteDBService(ClienteDBRepository clienteDBRepository, PasswordEncoder passwordEncoder) {
		this.clienteDBRepository = clienteDBRepository;
		this.passwordEncoder = passwordEncoder;
	}

	private Cliente convertToCliente(ClienteDB clienteDB) {
		return new Cliente(clienteDB);
	}

	public boolean createCliente(Cliente cliente) {
		try {
			ClienteDB clienteDB = new ClienteDB(cliente);
			String encodedPassword = passwordEncoder.encode(cliente.getPassword());

			clienteDB.setPassword(encodedPassword);
			clienteDBRepository.save(clienteDB);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateCliente(Integer id, Cliente Cliente) {
		Optional<ClienteDB> existingCliente = clienteDBRepository.findById(id);
		if (existingCliente.isPresent()) {
			ClienteDB updatedClienteDB = existingCliente.get();
			updatedClienteDB.setNombre(Cliente.getNombre());
			updatedClienteDB.setApellidos(Cliente.getApellidos());
			updatedClienteDB.setFechaDeNacimiento(LocalDate.parse(Cliente.getFechaDeNacimiento()));
			updatedClienteDB.setEmail(Cliente.getEmail());
			updatedClienteDB.setPassword(Cliente.getPassword());
			updatedClienteDB.setNumeroTarjetaDeCredito(Cliente.getNumeroTarjetaDeCredito());
			updatedClienteDB.setCcv(Cliente.getCcv());

			clienteDBRepository.save(updatedClienteDB);
			return true;
		}
		return false;
	}

	public Optional<Cliente> findClienteById(Integer id) {
		Optional<ClienteDB> ClienteDBOptional = clienteDBRepository.findById(id);
		return ClienteDBOptional.map(this::convertToCliente);
	}

	public List<Cliente> findAllClientes() {
		List<ClienteDB> ClienteDBs = (List<ClienteDB>) clienteDBRepository.findAll();
		return ClienteDBs.stream().map(this::convertToCliente)
				.collect(Collectors.toList());
	}

	public boolean deleteClienteById(Integer id) {
		Optional<ClienteDB> Cliente = clienteDBRepository.findById(id);
		if (Cliente.isPresent()) {
			clienteDBRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
