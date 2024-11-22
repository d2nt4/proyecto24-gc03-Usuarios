package org.openapitools.repository;

import org.openapitools.entity.GestorDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestorDBRepository extends CrudRepository<GestorDB, Integer> {
	GestorDB findById(int id);
	GestorDB findByEmail(String email);
}
