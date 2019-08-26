package com.spring.study.config.security;

import com.spring.study.model.Usuario;
import com.spring.study.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(userName);

        if(usuarioRepository.findByEmail(userName).isPresent()){
            return usuario.get();
        }

        throw new UsernameNotFoundException("Dados inválidos");
    }
}
