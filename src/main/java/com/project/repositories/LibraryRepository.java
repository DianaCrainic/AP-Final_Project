package com.project.repositories;

import com.project.entities.Library;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Library Repository
 */
public interface LibraryRepository extends CrudRepository<Library, Integer> {
    @Transactional
    @Modifying
    @Query("update Library l set l.name = :name where l.id = :id")
    void updateName(@Param("id") Integer id, @Param("name") String name);
}
