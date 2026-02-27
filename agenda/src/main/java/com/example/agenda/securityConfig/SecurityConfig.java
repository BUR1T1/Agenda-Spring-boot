package com.example.agenda.securityConfig;

import com.example.agenda.UTIL.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod; // IMPORTANTE: Adicione este import
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;


    @Configuration
    @EnableWebSecurity
    public class SecurityConfig {

        private final JwtFilter jwtFilter; // Injete o seu filtro

        public SecurityConfig(JwtFilter jwtFilter) {
            this.jwtFilter = jwtFilter;
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .csrf(csrf -> csrf.disable())
                    .sessionManagement(session ->
                            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    )
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/auth/**").permitAll() // Login liberado
                            .requestMatchers("/usuarios/cadastro").permitAll() // Cadastro liberado
                            .requestMatchers("/admin/**").hasRole("ADMIN")
                            .anyRequest().authenticated() // Bloqueia registros se não houver token
                    )
                    // ESSA LINHA É A CHAVE PARA O TOKEN FUNCIONAR:
                    .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);


            return http.build();
        }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}