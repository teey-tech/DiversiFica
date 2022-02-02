package com.generation.diversifica.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.generation.diversifica.utils.TipoUsuario;

/**
 *  Model de Avaliação
 *  
 *  @author Bruno Ribeiro
 *  @author Catarina Rinaldi
 *  @since 27/01/2022
 *  @version 1.0
 *  
 */

@Entity
@Table(name = "tb_usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

    @NotNull
	@Size(max = 60)
	private String nomeUsuario;

    @NotNull
	@Size(max = 45)
	private String email;

    @NotNull
	@Size(max = 45)
	private String senha;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo = TipoUsuario.PESSOA_FISICA;

    @NotNull
	@Size(max = 45)
	private String comunidade;

	@Size(max = 45)
	private String sexualidade;

	@Size(max = 45)
	private String genero;

	@Size(max = 45)
	private String pcds;

	@Size(max = 45)
	private String etnia;

	@Size(max = 500)
	private String foto;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Vaga> Vaga;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
   	@JsonIgnoreProperties("usuario")
   	private List<Avaliacao> Avaliacao;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public String getComunidade() {
		return comunidade;
	}

	public void setComunidade(String comunidade) {
		this.comunidade = comunidade;
	}

	public String getSexualidade() {
		return sexualidade;
	}

	public void setSexualidade(String sexualidade) {
		this.sexualidade = sexualidade;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPcds() {
		return pcds;
	}

	public void setPcds(String pcds) {
		this.pcds = pcds;
	}

	public String getEtnia() {
		return etnia;
	}

	public void setEtnia(String etnia) {
		this.etnia = etnia;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Vaga> getVaga() {
		return Vaga;
	}

	public void setVaga(List<Vaga> vaga) {
		Vaga = vaga;
	}

	public List<Avaliacao> getAvaliacao() {
		return Avaliacao;
	}

	public void setAvaliacao(List<Avaliacao> avaliacao) {
		Avaliacao = avaliacao;
	}

}
