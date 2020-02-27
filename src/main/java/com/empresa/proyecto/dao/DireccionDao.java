package com.empresa.proyecto.dao;

import java.util.List;

import com.empresa.proyecto.model.Direccion;
import com.empresa.proyecto.model.Persona;

public interface DireccionDao {

	public List<Direccion> listarDireccion();
	
	public int crearDireccion(Direccion d);
	
	public Direccion buscarDireccion(Direccion d);
	
	public int actualizarDireccion(Direccion d);
	
	public int borrarDireccion(Direccion d);
}
