package org.openapitools.repository;

import org.openapitools.entity.AdministradorDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorDBRepository extends CrudRepository<AdministradorDB, Integer> {
	AdministradorDB findById(int id);
	AdministradorDB findByEmail(String email);
}
