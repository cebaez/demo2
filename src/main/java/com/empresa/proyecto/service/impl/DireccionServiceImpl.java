package com.empresa.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.proyecto.dao.DireccionDao;
import com.empresa.proyecto.model.Direccion;
import com.empresa.proyecto.model.Persona;
import com.empresa.proyecto.service.DireccionService;

@Service
public class DireccionServiceImpl implements DireccionService {

	@Autowired
	public DireccionDao dirDao;

	public List<Direccion> listarDireccion() {
		return dirDao.listarDireccion();
	}
	
	public int crearDireccion(Direccion d) {
		return dirDao.crearDireccion(d);
	}
	
	public Direccion buscarDireccion(Direccion d){
		return dirDao.buscarDireccion(d);
	}
	
	public int actualizarDireccion(Direccion d){
		return dirDao.actualizarDireccion(d);
	}
	
	public int borrarDireccion(Direccion d){
		return dirDao.borrarDireccion(d);
	}
}

