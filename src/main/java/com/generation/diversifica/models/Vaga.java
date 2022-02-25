package com.generation.diversifica.models;

import java.time.LocalDate;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe Modelo para persistencia no Banco de Dados
 * 
 * @author Thiago Batista da Graça
 * @since 1.0
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
	private LocalDate datePostagem = LocalDate.now();

	private String convenio;

	private String dental;

	private String remoto;

	private String pcdIntelectual;

	private String pcdFisica;

	private String pcdVisual;

	private String pcdAuditiva;

	private String pcdMultiplas;

	private String lgbia;

	private String trans;

	private String experiencia;

	private String etnia;

	@ManyToOne
	@JoinColumn(name = "fk_empresa")
	@JsonIgnoreProperties("vaga")
	private Usuario usuario;

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

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public String getDental() {
		return dental;
	}

	public void setDental(String dental) {
		this.dental = dental;
	}

	public String getRemoto() {
		return remoto;
	}

	public void setRemoto(String remoto) {
		this.remoto = remoto;
	}

	public String getPcdIntelectual() {
		return pcdIntelectual;
	}

	public void setPcdIntelectual(String pcdIntelectual) {
		this.pcdIntelectual = pcdIntelectual;
	}

	public String getPcdFisica() {
		return pcdFisica;
	}

	public void setPcdFisica(String pcdFisica) {
		this.pcdFisica = pcdFisica;
	}

	public String getPcdVisual() {
		return pcdVisual;
	}

	public void setPcdVisual(String pcdVisual) {
		this.pcdVisual = pcdVisual;
	}

	public String getPcdAuditiva() {
		return pcdAuditiva;
	}

	public void setPcdAuditiva(String pcdAuditiva) {
		this.pcdAuditiva = pcdAuditiva;
	}

	public String getPcdMultiplas() {
		return pcdMultiplas;
	}

	public void setPcdMultiplas(String pcdMultiplas) {
		this.pcdMultiplas = pcdMultiplas;
	}

	public String getLgbia() {
		return lgbia;
	}

	public void setLgbia(String lgbia) {
		this.lgbia = lgbia;
	}

	public String getTrans() {
		return trans;
	}

	public void setTrans(String trans) {
		this.trans = trans;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public String getEtnia() {
		return etnia;
	}

	public void setEtnia(String etnia) {
		this.etnia = etnia;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
