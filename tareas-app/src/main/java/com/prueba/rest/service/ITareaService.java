package com.prueba.rest.service;

import java.util.List;

import com.prueba.rest.entity.Tarea;

public interface ITareaService {
	
	public List<Tarea> findAll();

	public void save(Tarea tarea);
	
	public Tarea findOne(Long id);
	
	public void delete(Long id);

}
