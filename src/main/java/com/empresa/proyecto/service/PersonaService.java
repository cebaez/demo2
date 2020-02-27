package com.empresa.proyecto.service;

import java.util.List;

import com.empresa.proyecto.model.Persona;

public interface PersonaService {
	
	public List<Persona> listarPersona();
	
	public int crearPersona(Persona p);
	
	public Persona buscarPersona(Persona p);
	
	public int actualizarPersona(Persona p);
	
	public int borrarPersona(Persona p);

}
