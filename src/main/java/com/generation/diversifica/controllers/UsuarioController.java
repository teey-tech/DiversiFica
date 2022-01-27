package com.generation.diversifica.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.generation.diversifica.models.Usuario;
import com.generation.diversifica.repositories.UsuarioRepository;

import org.apache.catalina.connector.Response;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * Função que pega a informação da tabela pelo ID
 * 
 * @author Thiago Batista
 * @version 1.0
 * @since 27/01/2022
 * 
 */

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UsuarioController {

  @Autowired
  private UsuarioRepository repository;

  /**
 * Função que pega a informação da tabela pelo ID
 * 
 * @author Thiago Batista
 * @version 1.0
 * @since 27/01/2022
 * 
 */

@GetMapping
public ResponseEntity<List<Usuario>> getAll(){
  List<Usuario>list = repository.findAll();

  if(list.isEmpty()){
    return ResponseEntity.status(204).build();
  } else {
    return ResponseEntity.status(200).body(list)
  }
}

  /**
   * Função que pega a informação da tabela pelo id do Usuario
   * 
   * @author Thiago Batista
   * @version 1.0
   * @since 27/01/2022
   * 
   */

  @GetMapping("{idUsuario}")
  public ResponseEntity<Usuario> getId(@PathVariable Long idUsuario) {
    return repository.findById(idUsuario).map(resp -> {
      return ResponseEntity.status(200).body(resp);
    }).orElseGet(() -> {
      return ResponseEntity.status(400).build();
    });
  }

  /**
   * Função que pega a informação da tabela pelo nome de Usuario
   * 
   * @author Thiago Batista
   * @version 1.0
   * @since 27/01/2022
   * 
   */

  @GetMapping("/nome-usuario/{nomeUsuario}");
  public ResponseEntity<List<Usuario>> getByName(@PathVariable String nomeUsuario){
    List<Usuario> list = repository.findAllByNomeUsuarioContainingIgnoreCase(nomeUsuario);
    if (list.isEmpty()){
      return ResponseEntity.status(404).build();
    } else {
      return ResponseEntity.status(200).body(list);
    }
  }

  /**
   * Função que salva as informações no banco de dados
   * 
   * @author Thiago Batista
   * @version 1.0
   * @since 27/01/2022
   * 
   */

  @PostMapping("/save")
  public ResponseEntity<Usuario> savePost(@Valid @RequestBody Usuario usuario) {
    return ResponseEntity.status(201).body(repository.save(usuario));
  }

  /**
   * Função que altera as informações no banco de dados
   * 
   * @author Thiago Batista
   * @version 1.0
   * @since 27/01/2022
   * 
   */
}
