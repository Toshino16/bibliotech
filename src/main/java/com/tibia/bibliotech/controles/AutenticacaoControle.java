package com.tibia.bibliotech.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tibia.bibliotech.modelos.Usuario;
import com.tibia.bibliotech.servicos.AutenticacaoServico;
import com.tibia.bibliotech.servicos.UsuarioServico;

@Controller @RequestMapping("/")
public class AutenticacaoControle {

  @Autowired
  private AutenticacaoServico autenticacaoServico;
  @Autowired
  private UsuarioServico usuarioServico;

  @GetMapping("/login")
  public String login(Model model) {
    model.addAttribute("usuario", new Usuario());
    return "/usuario/login";
  }

  @GetMapping("/cadastro")
  public String cadastro(Model model) {
    model.addAttribute("usuario", new Usuario());
    return "/usuario/cadastro";
  }

  @PostMapping("/login")
  public String login(@ModelAttribute Usuario usuario) {
    if(autenticacaoServico.autenticar(usuario)) {
      return "redirect:/jogo";
    }
    return "redirect:/login";
  }

  @PostMapping("/cadastro")
  public String cadastro(@ModelAttribute Usuario usuario) {
    autenticacaoServico.autenticar(usuarioServico.criar(usuario));
    return "redirect:/jogo";
  }

  @GetMapping("/logout")
  public String logout() {
    autenticacaoServico.sair();
    return "redirect:/login";
  }
  
}