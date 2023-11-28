package com.tibia.bibliotech.configuracoes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration @EnableWebSecurity
public class SegurancaConfiguracao {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
      .authorizeHttpRequests(requests -> requests
        .requestMatchers("/autenticacao/**", "/assets/**", "/bootstrap/**", "/css/**").permitAll()
        .anyRequest().authenticated())
      .formLogin(form -> form.disable())
      .logout(logout -> logout.disable())
      .csrf(csrf -> csrf.disable())
      .build();
  }

  @Bean
  public PasswordEncoder getBCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
}