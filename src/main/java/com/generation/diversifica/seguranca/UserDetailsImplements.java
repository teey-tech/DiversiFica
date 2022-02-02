package com.generation.diversifica.seguranca;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.generation.diversifica.models.Usuario;

/**
 * Criando UserDetails Service Implements
 * 
 * @author Sarah Nani
 * @since 02/02/2022
 * @version 1.0
 * 
 */

public class UserDetailsImplements implements UserDetails {

	private static final long serialVersionUID = 1l;
	
	private String email;
	
	private String senha;
	
	public UserDetailsImplements (Usuario usuario) {
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
