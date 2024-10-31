package org.openapitools.repositories;

import org.openapitools.modelDB.GestorDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestorDBRepository extends CrudRepository<GestorDB, Integer> {
	GestorDB findById(int id);
}
