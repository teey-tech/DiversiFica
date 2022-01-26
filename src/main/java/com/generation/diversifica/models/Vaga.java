package com.generation.diversifica.models;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.generation.diversifica.utils.Etnia;
import com.generation.diversifica.utils.Experiencia;
import com.generation.diversifica.utils.Opcao;


/**
 *  Classe Modelo para persistencia no Banco de Dados
 *  
 *  @author Thiago Batista da Graça
 *  @since 1.0
 *  
 */
@Entity
@Table(name = "tb_vagas")
public class Vaga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVaga;
	
	@NotNull
	@Size(max = 45)
	private String nomeVaga;
	
	@NotNull
	@Size(max = 500)
	private String descricao;
	
	@Size(max = 100)
	private String cargo;
	
	@NotNull
	private Float salario;
	
	@NotNull
	@Size(max = 500)
	private String beneficios;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private  LocalDate datePostagem = LocalDate.now();
	
	//Enuns
	@Enumerated(EnumType.STRING)
	private Opcao convenio;
	
	@Enumerated(EnumType.STRING)
	private Opcao dental;
	
	@Enumerated(EnumType.STRING)
	private Opcao remoto;
	
	@Enumerated(EnumType.STRING)
	private Opcao pcdIntelectual;
	
	@Enumerated(EnumType.STRING)
	private Opcao pcdFisica;
	
	@Enumerated(EnumType.STRING)
	private Opcao pcdVisual;
	
	@Enumerated(EnumType.STRING)
	private Opcao pcdAuditiva;
	
	@Enumerated(EnumType.STRING)
	private Opcao pcdMultiplas;
	
	@Enumerated(EnumType.STRING)
	private Opcao lgbia;
	
	@Enumerated(EnumType.STRING)
	private Opcao trans;
	
	
	@Enumerated(EnumType.STRING)
	private Experiencia experiencia;
	
	@Enumerated(EnumType.STRING)
	private Etnia etnia;
	

	public Long getIdVaga() {
		return this.idVaga;
	}

	public void setIdVaga(Long idVaga) {
		this.idVaga = idVaga;
	}

	public String getNomeVaga() {
		return this.nomeVaga;
	}

	public void setNomeVaga(String nomeVaga) {
		this.nomeVaga = nomeVaga;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Float getSalario() {
		return this.salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	public String getBeneficios() {
		return this.beneficios;
	}

	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	public LocalDate getDatePostagem() {
		return this.datePostagem;
	}

	public void setDatePostagem(LocalDate datePostagem) {
		this.datePostagem = datePostagem;
	}

	public Opcao getConvenio() {
		return this.convenio;
	}

	public void setConvenio(Opcao convenio) {
		this.convenio = convenio;
	}

	public Opcao getDental() {
		return this.dental;
	}

	public void setDental(Opcao dental) {
		this.dental = dental;
	}

	public Opcao getRemoto() {
		return this.remoto;
	}

	public void setRemoto(Opcao remoto) {
		this.remoto = remoto;
	}

	public Opcao getPcdIntelectual() {
		return this.pcdIntelectual;
	}

	public void setPcdIntelectual(Opcao pcdIntelectual) {
		this.pcdIntelectual = pcdIntelectual;
	}

	public Opcao getPcdFisica() {
		return this.pcdFisica;
	}

	public void setPcdFisica(Opcao pcdFisica) {
		this.pcdFisica = pcdFisica;
	}

	public Opcao getPcdVisual() {
		return this.pcdVisual;
	}

	public void setPcdVisual(Opcao pcdVisual) {
		this.pcdVisual = pcdVisual;
	}

	public Opcao getPcdAuditiva() {
		return this.pcdAuditiva;
	}

	public void setPcdAuditiva(Opcao pcdAuditiva) {
		this.pcdAuditiva = pcdAuditiva;
	}

	public Opcao getPcdMultiplas() {
		return this.pcdMultiplas;
	}

	public void setPcdMultiplas(Opcao pcdMultiplas) {
		this.pcdMultiplas = pcdMultiplas;
	}

	public Opcao getLgbia() {
		return this.lgbia;
	}

	public void setLgbia(Opcao lgbia) {
		this.lgbia = lgbia;
	}

	public Opcao getTrans() {
		return this.trans;
	}

	public void setTrans(Opcao trans) {
		this.trans = trans;
	}

	public Experiencia getExperiencia() {
		return this.experiencia;
	}

	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}

	public Etnia getEtnia() {
		return this.etnia;
	}

	public void setEtnia(Etnia etnia) {
		this.etnia = etnia;
	}

}
