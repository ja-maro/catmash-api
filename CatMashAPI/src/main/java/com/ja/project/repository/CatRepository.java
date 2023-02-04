package com.ja.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ja.project.model.Cat;

@Repository
public interface CatRepository extends CrudRepository<Cat, Integer> {

	
}
