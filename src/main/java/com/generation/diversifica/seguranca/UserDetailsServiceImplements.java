package com.generation.diversifica.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generation.diversifica.models.Usuario;
import com.generation.diversifica.repositories.UsuarioRepository;

/**
 * Criando UserDetails Service Implements
 * 
 * @author Catarina Rinaldi
 * @since 02/02/2022
 * @version 1.0
 * 
 */

@Service
public class UserDetailsServiceImplements implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> user = userRepository.findByEmail(email);
		user.orElseThrow(() -> new UsernameNotFoundException(email + "Não existe! "));
		
		return user.map(UserDetailsImplements::new).get();
	}

}
