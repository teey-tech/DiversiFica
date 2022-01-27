package com.generation.diversifica.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.diversifica.models.Avaliacao;
import com.generation.diversifica.models.Avalicao;


/**
 * Criando a Classe Controller para Avaliação
 * 
 * @author Sarah Nani
 * @since 27/01/2022
 * @version 1.0
 * 
 */

@RestController
@RequestMapping("/avaliacoes")
@CrossOrigin("*")
public class AvaliacaoController {
	
	@Autowired
	private AvaliacaoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Avaliacao>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}

	@PutMapping("/update")
	public ResponseEntity<Avaliacao> updatePost(@Valid @RequestBody Avaliacao updatePost) {
		return repository.findById(updatePost.getIdAvaliacao()).map(record -> {
			return ResponseEntity.status(201).body(repository.save(updatePost));
		}).orElseGet(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não encontrado");
		});
	}
}
