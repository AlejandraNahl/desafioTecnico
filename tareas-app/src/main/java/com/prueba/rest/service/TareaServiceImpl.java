package com.prueba.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.rest.dao.ITareaDao;
import com.prueba.rest.entity.Tarea;

@Service
public class TareaServiceImpl implements ITareaService{
	
	@Autowired
	private ITareaDao tareaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Tarea> findAll() {
		return (List<Tarea>) tareaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Tarea tarea) {
		tareaDao.save(tarea);
	}

	@Override
	@Transactional(readOnly = true)
	public Tarea findOne(Long id) {
		return tareaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		tareaDao.deleteById(id);
		
	}

}
