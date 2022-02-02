package com.generation.diversifica.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.diversifica.models.Usuario;

/**
 * Criando a Interface Repositório para Usuário
 *  
 *  @author Sarah Nani
 *  @since 27/01/2022
 *  @version 1.0
 *  
 */

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
	public List<Usuario> findAllByNomeUsuarioContainingIgnoreCase (String nomeUsuario);
	public List<Usuario> findAll();
	public Optional<Usuario> findByEmail(String email);

}
