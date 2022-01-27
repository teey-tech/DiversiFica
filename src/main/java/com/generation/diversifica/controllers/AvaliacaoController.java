package com.generation.diversifica.controllers;

<<<<<<< HEAD
import java.util.List;
=======
import java.util.Optional;
>>>>>>> 0c344b11a3b639edac4284d49d41aac0b4d254b0

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
=======
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> 0c344b11a3b639edac4284d49d41aac0b4d254b0
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.diversifica.models.Avaliacao;
<<<<<<< HEAD
import com.generation.diversifica.models.Avalicao;
=======
import com.generation.diversifica.repositories.AvaliacaoRepository;

>>>>>>> 0c344b11a3b639edac4284d49d41aac0b4d254b0


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
	

	@GetMapping
	public ResponseEntity<List<Avaliacao>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}

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
