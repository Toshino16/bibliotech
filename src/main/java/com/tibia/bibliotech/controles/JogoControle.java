package com.tibia.bibliotech.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tibia.bibliotech.servicos.JogoServico;

@Controller @RequestMapping("/jogo")
public class JogoControle {

  @Autowired
  private JogoServico jogoServico;

  @GetMapping
  public String lista(Model model) {
    model.addAttribute("lista", jogoServico.lista());
    return "/jogo/lista";
  }
  
}