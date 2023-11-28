package com.tibia.bibliotech.controles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tibia.bibliotech.BibliotechApplication;
import com.tibia.bibliotech.modelos.Usuario;

@ControllerAdvice(annotations = Controller.class)
public class PadraoControle {

  @ModelAttribute("auth")
  public Usuario auth() {
    return BibliotechApplication.auth;
  }
  
}