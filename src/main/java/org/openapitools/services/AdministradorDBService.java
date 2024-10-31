package org.openapitools.services;

import org.openapitools.model.Administrador;
import org.openapitools.modelDB.AdministradorDB;
import org.openapitools.repositories.AdministradorDBRepository;
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
}
