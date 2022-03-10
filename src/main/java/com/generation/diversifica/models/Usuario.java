package com.generation.diversifica.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Model de Avaliação
 * 
 * @author Bruno Ribeiro
 * @author Catarina Rinaldi
 * @since 27/01/2022
 * @version 1.0
 * 
 */

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

	// Ambos
	@NotNull
	private String nomeUsuario;

	@NotNull
	private String email;

	@NotNull
	private String senha;

	@Size(max = 5000)
	@NotNull
	private String foto;

	@NotNull
	private String tipo;

	private String sexualidade;

	private String pcdIntelectual;

	private String pcdFisica;

	private String pcdVisual;

	private String pcdAuditiva;

	private String pcdMultiplas;

	// Pessoa Fisica
	private String genero;

	private String etnia;

	private String pcd;

	// Pessoa Juridica
	private String generoLgbtqia;

	private String generoMulher;

	private String generoTrans;

	private String negro;

	private String indigena;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Vaga> vaga;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Avaliacao> avaliacao;

	public Usuario(Long idUsuario, String nomeUsuario, String email, String senha, String foto, String tipo,
			String sexualidade, String pcdIntelectual, String pcdFisica, String pcdVisual, String pcdAuditiva,
			String pcdMultiplas, String genero, String etnia, String pcd, String generoLgbtqia, String generoMulher,
			String generoTrans, String negro, String indigena) {
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.senha = senha;
		this.foto = foto;
		this.tipo = tipo;
		this.sexualidade = sexualidade;
		this.pcdIntelectual = pcdIntelectual;
		this.pcdFisica = pcdFisica;
		this.pcdVisual = pcdVisual;
		this.pcdAuditiva = pcdAuditiva;
		this.pcdMultiplas = pcdMultiplas;
		this.genero = genero;
		this.etnia = etnia;
		this.pcd = pcd;
		this.generoLgbtqia = generoLgbtqia;
		this.generoMulher = generoMulher;
		this.generoTrans = generoTrans;
		this.negro = negro;
		this.indigena = indigena;
	}

	public Usuario() {
	}

	public Long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return this.nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSexualidade() {
		return this.sexualidade;
	}

	public void setSexualidade(String sexualidade) {
		this.sexualidade = sexualidade;
	}

	public String getPcdIntelectual() {
		return this.pcdIntelectual;
	}

	public void setPcdIntelectual(String pcdIntelectual) {
		this.pcdIntelectual = pcdIntelectual;
	}

	public String getPcdFisica() {
		return this.pcdFisica;
	}

	public void setPcdFisica(String pcdFisica) {
		this.pcdFisica = pcdFisica;
	}

	public String getPcdVisual() {
		return this.pcdVisual;
	}

	public void setPcdVisual(String pcdVisual) {
		this.pcdVisual = pcdVisual;
	}

	public String getPcdAuditiva() {
		return this.pcdAuditiva;
	}

	public void setPcdAuditiva(String pcdAuditiva) {
		this.pcdAuditiva = pcdAuditiva;
	}

	public String getPcdMultiplas() {
		return this.pcdMultiplas;
	}

	public void setPcdMultiplas(String pcdMultiplas) {
		this.pcdMultiplas = pcdMultiplas;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEtnia() {
		return this.etnia;
	}

	public void setEtnia(String etnia) {
		this.etnia = etnia;
	}

	public String getPcd() {
		return this.pcd;
	}

	public void setPcd(String pcd) {
		this.pcd = pcd;
	}

	public String getGeneroLgbtqia() {
		return this.generoLgbtqia;
	}

	public void setGeneroLgbtqia(String generoLgbtqia) {
		this.generoLgbtqia = generoLgbtqia;
	}

	public String getGeneroMulher() {
		return this.generoMulher;
	}

	public void setGeneroMulher(String generoMulher) {
		this.generoMulher = generoMulher;
	}

	public String getGeneroTrans() {
		return this.generoTrans;
	}

	public void setGeneroTrans(String generoTrans) {
		this.generoTrans = generoTrans;
	}

	public String getNegro() {
		return this.negro;
	}

	public void setNegro(String negro) {
		this.negro = negro;
	}

	public String getIndigena() {
		return this.indigena;
	}

	public void setIndigena(String indigena) {
		this.indigena = indigena;
	}

	public List<Vaga> getVaga() {
		return this.vaga;
	}

	public void setVaga(List<Vaga> vaga) {
		this.vaga = vaga;
	}

	public List<Avaliacao> getAvaliacao() {
		return this.avaliacao;
	}

	public void setAvaliacao(List<Avaliacao> avaliacao) {
		this.avaliacao = avaliacao;
	}

}
