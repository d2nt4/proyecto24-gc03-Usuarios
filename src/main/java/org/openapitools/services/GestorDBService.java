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
}
