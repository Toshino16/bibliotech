package com.tibia.bibliotech.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tibia.bibliotech.modelos.Usuario;
import com.tibia.bibliotech.servicos.UsuarioServico;

@Controller @RequestMapping("/usuario")
public class UsuarioControle {

  @Autowired
  private UsuarioServico usuarioServico;

  @GetMapping
  public String lista(Model model) {
    model.addAttribute("lista", usuarioServico.lista());
    return "/usuario/lista";
  }

  @GetMapping("/cadastro")
  public String cadastro(Model model) {
    model.addAttribute("usuario", new Usuario());
    return "/usuario/cadastro";
  }

  @GetMapping("/login")
  public String login(Model model) {
    model.addAttribute("usuario", new Usuario());
    return "/usuario/login";
  }

  @GetMapping("/editar/{id}")
  public String editar(Model model, @PathVariable Long id) {
    model.addAttribute("usuario", usuarioServico.buscarPeloId(id));
    return "/usuario/editar";
  }

  @PostMapping("/login")
  public String login(@ModelAttribute Usuario usuario) {
    // TODO: implementar sistema de login
    return "redirect:/jogo";
  }

  @PostMapping("/cadastro")
  public String cadastro(@ModelAttribute Usuario usuario) {
    usuarioServico.criar(usuario);
    return "redirect:/jogo";
  }

  @GetMapping("/deletar/{id}")
  public String deletar(@PathVariable Long id) {
    usuarioServico.deletarPeloId(id);
    return "redirect:/usuario/cadastro";
  }

  @PostMapping("/editar/{id}")
  public String editar(@ModelAttribute Usuario usuario, @PathVariable Long id) {
    usuarioServico.editarPeloId(usuario, id);
    return "redirect:/jogo";
  }
  
}