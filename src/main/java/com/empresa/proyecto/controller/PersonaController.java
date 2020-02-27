package com.empresa.proyecto.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.empresa.proyecto.model.Persona;
import com.empresa.proyecto.service.PersonaService;

@Controller
@RequestMapping("persona")
public class PersonaController {

	@Autowired
	public PersonaService perService;

	@PostMapping(value = "listarPersona")
	@ResponseBody
	public List<Persona> listarPersona() {
		return perService.listarPersona();
	}

	@PostMapping(value = "crearPersona")
	@ResponseBody
	public int crearPersona(@RequestBody Persona p) {
		return perService.crearPersona(p);
	}

	@PostMapping(value = "buscarPersona")
	@ResponseBody
	public Persona buscarPersona(@RequestBody Persona p) {
		return perService.buscarPersona(p);
	}

	@PostMapping(value = "actualizarPersona")
	@ResponseBody
	public int actualizarPersona(@RequestBody Persona p) {
		return perService.actualizarPersona(p);
	}

	@PostMapping(value = "borrarPersona")
	@ResponseBody
	public int borrarPersona(@RequestBody Persona p) {
		return perService.borrarPersona(p);
	}
}
