package com.prueba.rest.dao;

import org.springframework.data.repository.CrudRepository;

import com.prueba.rest.entity.Tarea;

public interface ITareaDao extends CrudRepository<Tarea, Long>{
	
}
