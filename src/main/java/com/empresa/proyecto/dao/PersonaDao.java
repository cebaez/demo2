package com.empresa.proyecto.dao;

import java.util.List;
import com.empresa.proyecto.model.Persona;

public interface PersonaDao {

	public List<Persona> listarPersona();
	
	public int crearPersona(Persona p);
	
	public Persona buscarPersona(Persona p);
	
	public int actualizarPersona(Persona p);
	
	public int borrarPersona(Persona p);
}
