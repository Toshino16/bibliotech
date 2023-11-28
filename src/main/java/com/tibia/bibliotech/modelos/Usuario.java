package com.tibia.bibliotech.modelos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity @Data
public class Usuario {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String email;
  private String senha;
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private Date criadoEm;

  public boolean admin() {
    return nome != null && nome.equals("admin");
  }

}