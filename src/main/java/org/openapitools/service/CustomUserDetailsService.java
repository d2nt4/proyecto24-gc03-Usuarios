package org.openapitools.service;

import org.openapitools.entity.AdministradorDB;
import org.openapitools.entity.ClienteDB;
import org.openapitools.entity.GestorDB;
import org.openapitools.repository.AdministradorDBRepository;
import org.openapitools.repository.ClienteDBRepository;
import org.openapitools.repository.GestorDBRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AdministradorDBRepository administradorDBRepository;
    private final GestorDBRepository gestorDBRepository;
    private final ClienteDBRepository clienteDBRepository;

    public CustomUserDetailsService(AdministradorDBRepository administradorDBRepository, GestorDBRepository gestorDBRepository, ClienteDBRepository clienteDBRepository) {
        this.administradorDBRepository = administradorDBRepository;
        this.gestorDBRepository = gestorDBRepository;
        this.clienteDBRepository = clienteDBRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AdministradorDB administrador = administradorDBRepository.findByEmail(email);
        if (administrador != null) {
            return new User(administrador.getEmail(), administrador.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMINISTRADOR")));
        }

        GestorDB gestor = gestorDBRepository.findByEmail(email);
        if (gestor != null) {
            return new User(gestor.getEmail(), gestor.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_GESTOR")));
        }

        ClienteDB cliente = clienteDBRepository.findByEmail(email);
        if (cliente != null) {
            return new User(cliente.getEmail(), cliente.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_CLIENTE")));
        }

        throw new UsernameNotFoundException("Usuario no encontrado con el correo: " + email);
    }
}
