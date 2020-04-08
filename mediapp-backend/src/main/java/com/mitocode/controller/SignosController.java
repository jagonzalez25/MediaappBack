package com.mitocode.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.mitocode.model.Signos;
import com.mitocode.service.ISignoService;

@RestController
@RequestMapping("/signos")
public class SignosController {

	@Autowired
	private ISignoService service;

	@GetMapping
	public ResponseEntity<List<Signos>> listar() {
		List<Signos> lista = service.listar();
		return new ResponseEntity<List<Signos>>(lista, HttpStatus.OK);
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<Signos>> listarPageable(Pageable pageable) {
		Page<Signos> lista = service.listarPageable(pageable);
		return new ResponseEntity<Page<Signos>>(lista, HttpStatus.OK);
	}

	@GetMapping("listar/{id}")
	public ResponseEntity<Signos> listarPorId(@PathVariable("id") Integer id) {
		Signos signo = service.listarPorId(id);
		return new ResponseEntity<Signos>(signo, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Signos> guardar(@Valid @RequestBody Signos objeto) {
		Signos signo = service.registrar(objeto);
		return new ResponseEntity<Signos>(signo, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Signos> editar(@Valid @RequestBody Signos objeto) {
		Signos signo = service.modificar(objeto);
		return new ResponseEntity<Signos>(signo, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
