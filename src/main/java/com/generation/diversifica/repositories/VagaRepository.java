package com.generation.diversifica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.diversifica.models.Vaga;

/**
 * Criando a Interface Repositório para Vaga
 *  
 *  @author Sarah Nani
 *  @since 1.0
 *  
 */

@Repository
public interface VagaRepository extends JpaRepository <Vaga, Long> {
	public List<Vaga> findAllByVaga_Nome_VagaContainingIgnoreCase (String nome_vaga);
}
