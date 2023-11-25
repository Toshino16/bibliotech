package com.tibia.bibliotech.modelos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity @Data
public class Jogo {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private Float preco;
  private String url;
  private String imagem;
  private String descricao;
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private Date cadastradoEm;
  
}