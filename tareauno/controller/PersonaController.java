package com.tareauno.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tareauno.model.Persona;
import com.tareauno.service.IPersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {
	@Autowired
	IPersonaService personaService;

	@GetMapping
	public ResponseEntity<List<Persona>> listar() throws Exception {
		List<Persona> lista = personaService.listar();
		return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Persona> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Persona persona = personaService.listarPorId(id);
		if (persona == null)
			throw new Exception("ID NO ENCONTRADO " + id);
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody Persona persona) throws Exception {
		persona = personaService.registrar(persona);
		URI localtion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(persona.getIdPersona()).toUri();
		return ResponseEntity.created(localtion).build();
	}

	@PutMapping
	public ResponseEntity<Persona> modificar(@Valid @RequestBody Persona persona) throws Exception {
		persona = personaService.modificar(persona);
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Persona persona = personaService.listarPorId(id);
		if (persona.getIdPersona() == null)
			throw new Exception("ID NO ENCONTRADO " + id);
		personaService.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
