package com.generation.diversifica.service;

import java.nio.charset.Charset;
import java.util.Optional;

import com.generation.diversifica.models.Usuario;
import com.generation.diversifica.models.UsuarioLogin;
import com.generation.diversifica.repositories.UsuarioRepository;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * Classe responsável por validação do Usuario.
 * 
 * @author Bruno Ribeiro
 * @date 02/02/2022
 * @version 1.0
 * @see BCryptPasswordEncoder
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    /**
     * Private static method, used to encrypt with BCryptPasswordEncoder format a
     * string passed as a parameter.
     * 
     * @author Thiago Batista
     * @since 06/02/2022
     * @version 1.0
     * @see BCryptPasswordEncoder
     * @param senha
     * @return String
     * 
     */
    private String criptografarSenha(String senha) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaEncoder = encoder.encode(senha);
        return senhaEncoder;
    }

    /**
     * Private boolean method, used to compare the typed password and the password
     * stored in data base if matches the user can login into the system.
     * 
     * @author Thiago Batista
     * @since 06/02/2022
     * @version 1.0
     * @see Base64
     * @param senhaDigitada
     * @param senhaBanco
     * @return boolean
     * 
     */
    private boolean compararSenhas(String senhaDigitada, String senhaBanco) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(senhaDigitada, senhaBanco);
    }

    /**
     * Private static method, used to generate basic token.
     * 
     * @author Thiago Batista
     * @since 06/02/2022
     * @version 1.0
     * @see Base64
     * @param email
     * @param password
     * @return String
     * 
     */
    private String generatorBasicToken(String email, String password) {
        String structure = email + ":" + password;
        byte[] structureBase64 = Base64.encodeBase64(structure.getBytes(Charset.forName("US-ASCII")));
        return "Basic " + new String(structureBase64);
    }

    /**
     * Public method used to register a user in the system's database. This method
     * returns a BAD_REQUEST if the intention to register already has an email
     * registered in the system, to avoid duplication.
     * 
     * @author Thiago Batista
     * @since 06/02/2022
     * @version 1.0
     * @param usuario
     * @return ResponseEntity<UsuarioModel>
     * 
     */
    public Optional<Usuario> cadastrarUsuario(Usuario usuario) {
        if (repository.findByEmail(usuario.getEmail()).isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
        usuario.setSenha(criptografarSenha(usuario.getSenha()));
        return Optional.of(repository.save(usuario));
    }

    /**
     * Public method used to update a user in the system's database. This method
     * returns a BAD_REQUEST if the user tries to update a diferent user
     * registered in the system, to avoid errors.
     * 
     * @author Thiago Batista
     * @since 06/02/2022
     * @version 1.0
     * @param usuario
     * @return ResponseEntity<UsuarioModel>
     * 
     */
    public Optional<Usuario> atualizarUsuario(Usuario usuario) {
        if (repository.findById(usuario.getIdUsuario()).isPresent()) {
            Optional<Usuario> buscaUsuario = repository.findByEmail(usuario.getEmail());
            if (buscaUsuario.isPresent()) {
                if (buscaUsuario.get().getIdUsuario() != usuario.getIdUsuario())
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
            }
            usuario.setSenha(criptografarSenha(usuario.getSenha()));
            return Optional.of(repository.save(usuario));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!", null);
    }

    /**
     * Public method to login user into the system.
     * 
     * @author Thiago Batista
     * @since 06/02/2022
     * @version 1.0
     * @param usuarioLogin
     * @return Optional<UsuarioLoginDTO>
     * 
     * 
     */
    public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin> user) {
        Optional<Usuario> usuario = repository.findByEmail(user.get().getEmail());
        if (usuario.isPresent()) {
            if (compararSenhas(user.get().getSenha(), usuario.get().getSenha())) {
                user.get().setIdUsuario(usuario.get().getIdUsuario());
                user.get().setEmail(usuario.get().getEmail());
                user.get().setNomeUsuario(usuario.get().getNomeUsuario());
                user.get().setFoto(usuario.get().getFoto());
                user.get().setEtnia(usuario.get().getEtnia());
                user.get().setPcd(usuario.get().getPcd());
                user.get().setNegro(usuario.get().getNegro());
                user.get().setIndigena(usuario.get().getIndigena());
                user.get().setGenero(usuario.get().getGenero());
                user.get().setSexualidade(usuario.get().getSexualidade());
                user.get().setGeneroLgbtqia(usuario.get().getGeneroLgbtqia());
                user.get().setGeneroMulher(usuario.get().getGeneroMulher());
                user.get().setGeneroTrans(usuario.get().getGeneroTrans());
                user.get().setPcdAuditiva(usuario.get().getPcdAuditiva());
                user.get().setPcdFisica(usuario.get().getPcdFisica());
                user.get().setPcdIntelectual(usuario.get().getPcdIntelectual());
                user.get().setPcdMultiplas(usuario.get().getPcdMultiplas());
                user.get().setPcdVisual(usuario.get().getPcdVisual());
                user.get().setTipo(usuario.get().getTipo());
                user.get()
                        .setToken(generatorBasicToken(user.get().getEmail(), user.get().getSenha()));
                user.get().setSenha(usuario.get().getSenha());
                return user;
            }
        }
        throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED, "Usuário ou senha inválidos!", null);
    }
}
