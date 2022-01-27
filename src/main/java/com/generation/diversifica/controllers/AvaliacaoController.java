package com.generation.diversifica.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.diversifica.models.Avaliacao;
import com.generation.diversifica.repositories.AvaliacaoRepository;



/**
 * Criando a Classe Controller para Avaliação
 * 
 * @author Sarah Nani
 * @author Catarina Rinaldi
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
	
	@PostMapping("/save")
	public ResponseEntity<Avaliacao> savePost(@Valid @RequestBody Avaliacao avaliacao) {
		return ResponseEntity.status(201).body(repository.save(avaliacao));
	}

	@PutMapping("/update")
	public ResponseEntity<Avaliacao> updatePost(@Valid @RequestBody Avaliacao updatePost) {
		return repository.findById(updatePost.getIdAvaliacao()).map(record -> {
			return ResponseEntity.status(201).body(repository.save(updatePost));
		}).orElseGet(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não encontrado");
		});
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping(value = "/delete/{idAvaliacao}")
	public ResponseEntity deletePost(@PathVariable("idAvaliacao") long idAvaliacao) {
		Optional<Avaliacao> optional = repository.findById(idAvaliacao);
		if (optional.isPresent()) {
			repository.deleteById(idAvaliacao);
			return ResponseEntity.status(200).build();

		} else {
			return ResponseEntity.status(404).build();
		}
	}

}
