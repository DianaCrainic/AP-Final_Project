package com.project.repositories;

import com.project.entities.Author;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
    @Transactional
    @Modifying
    @Query("update Author a set a.name = :name where a.id = :id")
    void updateName(@Param("id") Integer id, @Param("name") String name);
}