package com.tareauno.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tareauno.model.Venta;
import com.tareauno.service.IVentaService;

@RestController
@RequestMapping("/ventas")
public class VentaController {
	@Autowired
	IVentaService ventaService;

	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody Venta venta) throws Exception {
		Venta obj = ventaService.registrarTransaccional(venta);
		URI localtion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdVenta()).toUri();
		return ResponseEntity.created(localtion).build();
	}
}
