package com.yoandypv.ejemplos.springcrud.repository;

import com.yoandypv.ejemplos.springcrud.entities.Auto;
import org.springframework.data.repository.CrudRepository;

public interface AutoRepository extends CrudRepository<Auto, Long> {
}
