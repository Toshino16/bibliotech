package com.tibia.bibliotech.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping("/{id}")
  public String buscarPeloId(Model model, @PathVariable Long id) {
    model.addAttribute("usuario", usuarioServico.buscarPeloId(id));
    return "/usuario/detalhes";
  }

  @GetMapping("/criar")
  public String criar(Model model) {
    model.addAttribute("usuario", new Usuario());
    return "/usuario/criar";
  }

  @GetMapping("/editar/{id}")
  public String editar(Model model, @PathVariable Long id) {
    model.addAttribute("usuario", usuarioServico.buscarPeloId(id));
    return "/usuario/editar";
  }
  
}