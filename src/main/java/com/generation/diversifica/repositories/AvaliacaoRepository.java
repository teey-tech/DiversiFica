package com.generation.diversifica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.diversifica.models.Avaliacao;

/**
 * Criando a interface Repository para Avaliação
 * 
 * @author Igor Miramisawa
 * @since 27/01/2022
 * @version 1.0
 * 
 */

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
	public List<Avaliacao> findAllByComentarioContainingIgnoreCase(String comentario);

}
