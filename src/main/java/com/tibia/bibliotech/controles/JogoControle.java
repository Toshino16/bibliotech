package com.tibia.bibliotech.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tibia.bibliotech.modelos.Jogo;
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

  @GetMapping("/cadastro")
  public String cadastro(Model model) {
    model.addAttribute("jogo", new Jogo());
    return "/jogo/cadastro";
  }

  @GetMapping("/deletar/{id}")
  public String deletar(@PathVariable Long id) {
    jogoServico.deletarPeloId(id);
    return "redirect:/jogo";
  }
  
}