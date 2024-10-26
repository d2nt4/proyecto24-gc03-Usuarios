package org.openapitools.repositories;

import org.openapitools.modelDB.ClienteDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteDBRepository extends CrudRepository<ClienteDB, Integer> {
	List<ClienteDB> findByNombre(String nombre);

	ClienteDB findById(int id);
}
