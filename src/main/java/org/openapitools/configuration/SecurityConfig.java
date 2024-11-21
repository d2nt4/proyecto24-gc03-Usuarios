package org.openapitools.configuration;

import org.openapitools.service.CustomUserDetailsService;
import org.openapitools.util.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtRequestFilter jwtRequestFilter;
    private final CustomUserDetailsService customUserDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(JwtRequestFilter jwtRequestFilter, CustomUserDetailsService customUserDetailsService, PasswordEncoder passwordEncoder) {
        this.jwtRequestFilter = jwtRequestFilter;
        this.customUserDetailsService = customUserDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .cors()
                .and()
                .authorizeRequests()
                .antMatchers("/authenticate", "/register", "/request", "/reset-password").permitAll()
                .antMatchers(HttpMethod.GET,
                        "/swagger-resources/**",
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/webjars/**"
                ).permitAll() // Permitir acceso a Swagger
                .antMatchers("/StreamHub/administrador/**").hasAuthority("ROLE_ADMINISTRADOR") // Ruta para administradores
                .antMatchers("/StreamHub/gestor/**").hasAuthority("ROLE_GESTOR") // Ruta para gestores
                .antMatchers(HttpMethod.POST, "/StreamHub/cliente").permitAll() // Ruta para crear un cliente
                .antMatchers("/StreamHub/cliente/**").hasAuthority("ROLE_CLIENTE") // Ruta para clientes
                .antMatchers(HttpMethod.GET, "/StreamHub/administradores").hasAuthority("ROLE_ADMINISTRADOR") // Ruta para obtener todos los administradores
                .antMatchers(HttpMethod.GET, "/StreamHub/gestores").hasAuthority("ROLE_ADMINISTRADOR") // Ruta para obtener todos los gestores
                .antMatchers("/StreamHub/gestor/**").hasAuthority("ROLE_ADMINISTRADOR") // Ruta para gestionar gestores
                .anyRequest().authenticated() // Cualquier otra ruta requiere autenticación
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
