package org.openapitools.services;

import org.openapitools.modelDB.ClienteDB;
import org.openapitools.repositories.ClienteDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ClienteDBService {

	private final ClienteDBRepository clienteDBRepository;
	@Autowired
	public ClienteDBService(ClienteDBRepository clienteDBRepository) {
		this.clienteDBRepository = clienteDBRepository;
	}

	public void printAllClientes() {
		clienteDBRepository.findAll().forEach(System.out::println);
		System.out.println(clienteDBRepository.findById(1));
		clienteDBRepository.findByNombre("Juan").forEach(System.out::println);
	}
}
