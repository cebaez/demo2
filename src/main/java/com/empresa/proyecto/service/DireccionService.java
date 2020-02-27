package com.empresa.proyecto.service;

import java.util.List;

import com.empresa.proyecto.model.Direccion;


public interface DireccionService {

	public List<Direccion> listarDireccion();
	
	public int crearDireccion(Direccion d);
	
	public Direccion buscarDireccion(Direccion d);
	
	public int actualizarDireccion(Direccion d);
	
	public int borrarDireccion(Direccion d);

}
