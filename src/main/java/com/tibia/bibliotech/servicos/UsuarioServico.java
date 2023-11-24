package com.tibia.bibliotech.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tibia.bibliotech.modelos.Usuario;
import com.tibia.bibliotech.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServico {

  @Autowired
  private UsuarioRepositorio usuarioRepositorio;

  public List<Usuario> lista() {
    return usuarioRepositorio.findAll();
  }

  public Usuario buscarPeloId(Long id) {
    return usuarioRepositorio.findById(id).get();
  }

  public Usuario criar(Usuario usuario) {
    return usuarioRepositorio.save(usuario);
  }

  public Usuario editarPeloId(Usuario usuario, Long id) {
    usuario.setId(id);
    return usuarioRepositorio.save(usuario);
  }

  public void deletarPeloId(Long id) {
    usuarioRepositorio.deleteById(id);
  }
  
}