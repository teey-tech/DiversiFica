package com.generation.diversifica.models;

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
public class Vagas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_vaga;
	
	@NotNull
	@Size(max = 45)
	private String nome_vaga;
	
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
	
	@Temporal(TemporalType.TIMESTAMP)
	private  Date date_postagem = new java.sql.Date(System.currentTimeMillis());;
	

	//Enuns
	@Enumerated(EnumType.STRING)
	private Opcao convenio;
	
	@Enumerated(EnumType.STRING)
	private Opcao dental;
	
	@Enumerated(EnumType.STRING)
	private Opcao remoto;
	
	@Enumerated(EnumType.STRING)
	private Opcao pcd_intelectual;
	
	@Enumerated(EnumType.STRING)
	private Opcao pcd_fisica;
	
	@Enumerated(EnumType.STRING)
	private Opcao pcd_visual;
	
	@Enumerated(EnumType.STRING)
	private Opcao pcd_auditiva;
	
	@Enumerated(EnumType.STRING)
	private Opcao pcd_multiplas;
	
	@Enumerated(EnumType.STRING)
	private Opcao lgbia;
	
	@Enumerated(EnumType.STRING)
	private Opcao trans;
	
	
	@Enumerated(EnumType.STRING)
	private Experiencia experiencia;
	
	@Enumerated(EnumType.STRING)
	private Etnia etnia;
	
	public Long getId() {
		return id_vaga;
	}

	public void setId(Long id_vaga) {
		this.id_vaga = id_vaga;
	}

	public String getNome_vaga() {
		return nome_vaga;
	}

	public void setNome_vaga(String nome_vaga) {
		this.nome_vaga = nome_vaga;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	public String getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	public Date getDate_postagem() {
		return date_postagem;
	}

	public void setDate_postagem(Date date_postagem) {
		this.date_postagem = date_postagem;
	}

	public Opcao getConvenio() {
		return convenio;
	}

	public void setConvenio(Opcao convenio) {
		this.convenio = convenio;
	}

	public Opcao getDental() {
		return dental;
	}

	public void setDental(Opcao dental) {
		this.dental = dental;
	}

	public Opcao getRemoto() {
		return remoto;
	}

	public void setRemoto(Opcao remoto) {
		this.remoto = remoto;
	}

	public Opcao getPcd_intelectual() {
		return pcd_intelectual;
	}

	public void setPcd_intelectual(Opcao pcd_intelectual) {
		this.pcd_intelectual = pcd_intelectual;
	}

	public Opcao getPcd_fisica() {
		return pcd_fisica;
	}

	public void setPcd_fisica(Opcao pcd_fisica) {
		this.pcd_fisica = pcd_fisica;
	}

	public Opcao getPcd_visual() {
		return pcd_visual;
	}

	public void setPcd_visual(Opcao pcd_visual) {
		this.pcd_visual = pcd_visual;
	}

	public Opcao getPcd_auditiva() {
		return pcd_auditiva;
	}

	public void setPcd_auditiva(Opcao pcd_auditiva) {
		this.pcd_auditiva = pcd_auditiva;
	}

	public Opcao getPcd_multiplas() {
		return pcd_multiplas;
	}

	public void setPcd_multiplas(Opcao pcd_multiplas) {
		this.pcd_multiplas = pcd_multiplas;
	}

	public Opcao getLgbia() {
		return lgbia;
	}

	public void setLgbia(Opcao lgbia) {
		this.lgbia = lgbia;
	}

	public Opcao getTrans() {
		return trans;
	}

	public void setTrans(Opcao trans) {
		this.trans = trans;
	}

	public Experiencia getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}

	public Etnia getEtnia() {
		return etnia;
	}

	public void setEtnia(Etnia etnia) {
		this.etnia = etnia;
	}

	
	
}
