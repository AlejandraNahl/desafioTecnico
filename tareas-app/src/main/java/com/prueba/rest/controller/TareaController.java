package com.prueba.rest.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.prueba.rest.entity.Tarea;
import com.prueba.rest.service.ITareaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Controller
@SessionAttributes("tarea")
@Api(tags = "tarea")
public class TareaController {
	
	public static final String VISTA_LISTA = "listar";
    public static final String VISTA_FORMULARIO = "form";
	
	@Autowired
	private ITareaService tareaService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@ApiOperation(value = "Listar todas las tareas")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de tareas");
		model.addAttribute("tareas", tareaService.findAll());
		return VISTA_LISTA;
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	@ApiOperation(value = "Crear una tareas")
	public String crear(Map<String, Object> model) {
		Tarea tarea = new Tarea();
		model.put("tarea", tarea);
		model.put("titulo", "Formulario de Tarea");
		return VISTA_FORMULARIO;
	}
	
	@RequestMapping(value="/form/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Editar tarea")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Tarea tarea = null;
		
		if(id > 0) {
			tarea = tareaService.findOne(id);
		} else {
			return "redirect:/" + VISTA_LISTA;
		}
		model.put("tarea", tarea);
		model.put("titulo", "Editar Tarea");
		return VISTA_FORMULARIO;
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	@ApiOperation(value = "Guardar tarea")
	public String guardar(@Valid Tarea tarea, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Tareas");
			return VISTA_FORMULARIO;
		}
		
		tareaService.save(tarea);
		status.setComplete();
		return "redirect:/"+ VISTA_LISTA;
	}
	
	@RequestMapping(value="/eliminar/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Eliminar tarea")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id > 0) {
			tareaService.delete(id);
		}
		return "redirect:/"+ VISTA_LISTA;
	}
	
	
	

}
