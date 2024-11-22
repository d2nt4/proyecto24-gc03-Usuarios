package org.openapitools.repository;

import org.openapitools.entity.ClienteDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteDBRepository extends CrudRepository<ClienteDB, Integer> {
	List<ClienteDB> findByNombre(String nombre);
	ClienteDB findById(int id);
	ClienteDB findByEmail(String email);
}
