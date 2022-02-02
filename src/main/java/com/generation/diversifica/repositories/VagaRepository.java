package com.generation.diversifica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.diversifica.models.Vaga;
import com.generation.diversifica.utils.Etnia;
import com.generation.diversifica.utils.Experiencia;
import com.generation.diversifica.utils.Opcao;

/**
 * Criando a Interface Repositório para Vaga
 * 
 * @author Sarah Nani
 * @author Catarina Rinaldig
 * @author Igor Miramisawa
 * @since 1.0
 * 
 */

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
	public List<Vaga> findAllByNomeVagaContainingIgnoreCase(String nomeVaga);

	public List<Vaga> findAll();

	public List<Vaga> findAllByPcdAuditivaAndPcdVisualAndPcdFisicaAndPcdMultiplasAndPcdIntelectualAndConvenioAndDentalAndRemotoAndLgbiaAndExperienciaAndEtnia(
			Opcao pcdAuditiva, Opcao pcdVisual, Opcao pcdFisica, Opcao pcdMultiplas, Opcao pcdIntelectual,
			Opcao convenio, Opcao dental, Opcao remoto, Opcao lgbia, Experiencia experiencia, Etnia etnia);

	// @Query(value = "SELECT * FROM tb_vagas WHERE ")
	// public List<Vaga> search(Opcao pcdAuditiva, Opcao pcdVisual);

}
