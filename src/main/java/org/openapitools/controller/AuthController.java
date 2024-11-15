package org.openapitools.controller;

import org.apache.commons.mail.EmailException;
import org.openapitools.model.AuthRequest;
import org.openapitools.model.AuthResponse;
import org.openapitools.model.PasswordRequest;
import org.openapitools.model.PasswordResetRequest;
import org.openapitools.service.CustomUserDetailsService;
import org.openapitools.service.EmailService;
import org.openapitools.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
                          CustomUserDetailsService userDetailsService, PasswordEncoder passwordEncoder, EmailService emailService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    @PostMapping("/authenticate")
    public AuthResponse createToken(@RequestBody AuthRequest authRequest) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());
        Long userId = userDetailsService.getUserIdByEmail(authRequest.getEmail());

        if (!passwordEncoder.matches(authRequest.getPassword(), userDetails.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        final String jwt = jwtUtil.generateToken(userDetails, userId);
        return new AuthResponse(jwt);
    }

    @PostMapping("/request")
    public String requestPasswordReset(@RequestBody PasswordRequest passwordRequest) {
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(passwordRequest.getEmail());

            if (userDetails == null) {
                return "El correo electrónico no está registrado.";
            }

            String resetToken = jwtUtil.generatePasswordResetToken(passwordRequest.getEmail());

            emailService.sendPasswordResetEmail(passwordRequest.getEmail(), resetToken);

            return "Correo de restablecimiento enviado. Revisa tu bandeja de entrada.";
        } catch (UsernameNotFoundException e) {
            return "El correo electrónico no está registrado.";
        } catch (EmailException e) {
            throw new RuntimeException("Error al enviar el correo de restablecimiento.", e);
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado al procesar la solicitud.", e);
        }
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam("token") String token, @RequestBody PasswordResetRequest passwordResetRequest) {
        String email;
        try {
            email = jwtUtil.extractEmail(token);
        } catch (Exception e) {
            return "Token inválido.";
        }

        if (email == null || jwtUtil.isTokenExpired(token)) {
            return "El enlace de restablecimiento ha expirado o es inválido.";
        }

        System.out.println("New Password: " + passwordResetRequest.getNewPassword());

        userDetailsService.updatePassword(email, passwordResetRequest.getNewPassword());

        return "Contraseña restablecida con éxito.";
    }
}