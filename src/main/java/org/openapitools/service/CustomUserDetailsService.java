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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AdministradorDBRepository administradorDBRepository;
    private final GestorDBRepository gestorDBRepository;
    private final ClienteDBRepository clienteDBRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(AdministradorDBRepository administradorDBRepository, GestorDBRepository gestorDBRepository, ClienteDBRepository clienteDBRepository, PasswordEncoder passwordEncoder) {
        this.administradorDBRepository = administradorDBRepository;
        this.gestorDBRepository = gestorDBRepository;
        this.clienteDBRepository = clienteDBRepository;
        this.passwordEncoder = passwordEncoder;
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

    public void updatePassword(String email, String newPassword) throws UsernameNotFoundException {
        AdministradorDB administrador = administradorDBRepository.findByEmail(email);
        if (administrador != null) {
            administrador.setPassword(passwordEncoder.encode(newPassword));
            administradorDBRepository.save(administrador);
            return;
        }

        GestorDB gestor = gestorDBRepository.findByEmail(email);
        if (gestor != null) {
            gestor.setPassword(passwordEncoder.encode(newPassword));
            gestorDBRepository.save(gestor);
            return;
        }

        ClienteDB cliente = clienteDBRepository.findByEmail(email);
        if (cliente != null) {
            cliente.setPassword(passwordEncoder.encode(newPassword));
            clienteDBRepository.save(cliente);
            return;
        }

        throw new UsernameNotFoundException("Usuario no encontrado con el correo: " + email);
    }

    public Long getUserIdByEmail(String email) {
        AdministradorDB admin = administradorDBRepository.findByEmail(email);
        if (admin != null) return admin.getId().longValue();

        GestorDB gestor = gestorDBRepository.findByEmail(email);
        if (gestor != null) return gestor.getId().longValue();

        ClienteDB cliente = clienteDBRepository.findByEmail(email);
        if (cliente != null) return cliente.getId().longValue();

        throw new UsernameNotFoundException("Usuario no encontrado con el correo: " + email);
    }
}
