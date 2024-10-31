package org.openapitools.repositories;

import org.openapitools.modelDB.AdministradorDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorDBRepository extends CrudRepository<AdministradorDB, Integer> {
	AdministradorDB findById(int id);
}
