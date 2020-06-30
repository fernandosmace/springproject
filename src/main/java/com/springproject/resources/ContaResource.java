package com.springproject.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.domain.Conta;
import com.springproject.services.ContaService;

@RestController
@RequestMapping(value = "/conta")
public class ContaResource {
	
	@Autowired
	private ContaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Conta> find(@PathVariable Integer id) {
		
		Conta obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
