package com.generation.diversifica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.diversifica.models.Vaga;
import com.generation.diversifica.repositories.VagaRepository;

/**
 * Criando a Classe Controller para Vaga
 *  
 *  @author Sarah Nani
 *  @since 1.0
 *  
 */

@RestController
@RequestMapping("/vagas")
@CrossOrigin("*")

public class VagaController {

	@Autowired
	private VagaRepository repository;
	
	/**
	 * Pega informação da tabela pelo ID
	 *  
	 *  @author Sarah Nani
	 *  @since 1.0
	 *  
	 */
	
	@GetMapping("{id}")
	public ResponseEntity<Vaga> getId(@PathVariable Long id) {
		return repository.findById(id).map(resp -> {
			return ResponseEntity.status(200).body(resp);
		}).orElseGet(() -> {
			return ResponseEntity.status(404).build();
		});
	}
	
}
