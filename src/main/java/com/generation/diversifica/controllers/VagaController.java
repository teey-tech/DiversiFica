package com.generation.diversifica.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.diversifica.models.Vaga;
import com.generation.diversifica.repositories.VagaRepository;
import com.generation.diversifica.utils.Opcao;

/**
 * Criando a Classe Controller para Vaga
 * 
 * @author Sarah Nani
 * @since 1.0
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
	 * @author Sarah Nani
	 * @since 1.0
	 * 
	 */

	@GetMapping
	public ResponseEntity<List<Vaga>> getAll() {
		List<Vaga> list = repository.findAll();

		if (list.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(201).body(list);
		}
	}

	@GetMapping("{idVaga}")
	public ResponseEntity<Vaga> getId(@PathVariable Long idVaga) {
		return repository.findById(idVaga).map(resp -> {
			return ResponseEntity.status(200).body(resp);
		}).orElseGet(() -> {
			return ResponseEntity.status(404).build();
		});
	}

	@GetMapping("/nome-vaga/{nomeVaga}")
	public ResponseEntity<List<Vaga>> getByName(@PathVariable String nomeVaga) {
		List<Vaga> list = repository.findAllByNomeVagaContainingIgnoreCase(nomeVaga);
		if (list.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(list);
		}
	}

	@GetMapping("/search")
	public ResponseEntity<List<Vaga>> search (
			@RequestParam(required = false) Opcao pcdAuditiva,
			@RequestParam(required = false) Opcao pcdVisual,
			@RequestParam(required = false) Opcao pcdFisica,
			@RequestParam(required = false) Opcao pcdMultiplas,
			@RequestParam(required = false) Opcao pcdIntelectual) {

		List<Vaga> list = repository.findAllByPcdAuditivaAndPcdVisualAndPcdFisicaAndPcdMultiplasAndPcdIntelectual(pcdAuditiva, pcdVisual, pcdFisica, pcdMultiplas, pcdIntelectual);
		if (list.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(list);
		}
	}

	@PostMapping("/save")
	public ResponseEntity<Vaga> savePost(@Valid @RequestBody Vaga vaga) {
		return ResponseEntity.status(201).body(repository.save(vaga));
	}

	@PutMapping("/update")
	public ResponseEntity<Vaga> updatePost(@Valid @RequestBody Vaga updatePost) {
		return repository.findById(updatePost.getIdVaga()).map(record -> {
			return ResponseEntity.status(201).body(repository.save(updatePost));
		}).orElseGet(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não encontrado");
		});
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping(value = "/delete/{idVaga}")
	public ResponseEntity deletePost(@PathVariable("idVaga") long idVaga) {
		Optional<Vaga> optional = repository.findById(idVaga);
		if (optional.isPresent()) {
			repository.deleteById(idVaga);
			return ResponseEntity.status(200).build();

		} else {
			return ResponseEntity.status(404).build();
		}
	}

}
