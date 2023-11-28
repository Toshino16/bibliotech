package com.tibia.bibliotech.controles;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

  @GetMapping("/detalhes/{id}")
  public String detalhes(Model model, @PathVariable Long id) {
    model.addAttribute("jogo", jogoServico.buscarPeloId(id));
    return "jogo/detalhes";
  }

  @GetMapping("/cadastro")
  public String cadastro(Model model) {
    model.addAttribute("jogo", new Jogo());
    return "/jogo/cadastro";
  }

  @GetMapping("/editar/{id}")
  public String editar(Model model, @PathVariable Long id) {
    model.addAttribute("jogo", jogoServico.buscarPeloId(id));
    return "/jogo/editar";
  }

  @PostMapping("/cadastro")
  public String cadastro(@ModelAttribute Jogo jogo, @RequestParam("arquivo") MultipartFile arquivo) throws IOException {
    jogoServico.criar(jogo, arquivo);
    return "redirect:/jogo";
  }

  @GetMapping("/deletar/{id}")
  public String deletar(@PathVariable Long id) {
    jogoServico.deletarPeloId(id);
    return "redirect:/jogo";
  }

  @PostMapping("/editar/{id}")
  public String editar(@ModelAttribute Jogo jogo, @PathVariable Long id, @RequestParam("arquivo") MultipartFile arquivo) throws IOException {
    jogoServico.editarPeloId(jogo, arquivo, id);
    return "redirect:/jogo";
  }
  
}