package com.tibia.bibliotech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tibia.bibliotech.modelos.Usuario;

@SpringBootApplication
public class BibliotechApplication {

  public static Usuario auth = new Usuario();

  public static String redirecionarSeNaoTemPermissao(String rota) {
    return auth.admin() ? rota : "redirect:/login";
  }

  public static String redirecionarSeNaoEstiverLogado(String rota) {
    return auth.getNome() != null ? rota : "redirect:/login";
  }

  public static void main(String[] args) {
    // Will esteve por aqui
    SpringApplication.run(BibliotechApplication.class, args);
  }

}