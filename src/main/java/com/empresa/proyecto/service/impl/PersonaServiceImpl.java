package com.empresa.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.proyecto.dao.PersonaDao;
import com.empresa.proyecto.model.Persona;
import com.empresa.proyecto.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	public PersonaDao perDao;

	public List<Persona> listarPersona() {
		return perDao.listarPersona();
	}

	public int crearPersona(Persona p) {
		return perDao.crearPersona(p);
	}
	
	public Persona buscarPersona(Persona p){
		return perDao.buscarPersona(p);
	}
	
	public int actualizarPersona(Persona p){
		return perDao.actualizarPersona(p);
	}
	
	public int borrarPersona(Persona p){
		return perDao.borrarPersona(p);
	}
}
