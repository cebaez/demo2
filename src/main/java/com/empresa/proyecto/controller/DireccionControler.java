package com.empresa.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.proyecto.model.Direccion;
import com.empresa.proyecto.model.Persona;
import com.empresa.proyecto.service.DireccionService;
import com.empresa.proyecto.service.PersonaService;

@Controller
@RequestMapping("direccion")
public class DireccionControler {
	
	@Autowired
	public DireccionService dirService;

	@PostMapping(value = "listarDireccion")
	@ResponseBody
	public List<Direccion> direccion() {
		return dirService.listarDireccion();
	}
	
	@PostMapping(value = "crearDireccion")
	@ResponseBody
	public int crearDireccion(@RequestBody Direccion d) {
		return dirService.crearDireccion(d);
	}
	
	@PostMapping(value = "buscarDireccion")
	@ResponseBody
	public Direccion buscarDireccion(@RequestBody Direccion d) {
		return dirService.buscarDireccion(d);
	}
	
	@PostMapping(value = "actualizarDireccion")
	@ResponseBody
	public int actualizarDireccion(@RequestBody Direccion d) {
		return dirService.actualizarDireccion(d);
	}
	
	@PostMapping(value = "borrarDireccion")
	@ResponseBody
	public int borrarDireccion(@RequestBody Direccion d) {
		return dirService.borrarDireccion(d);
	}

	
}
