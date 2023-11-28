package com.tibia.bibliotech.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tibia.bibliotech.BibliotechApplication;
import com.tibia.bibliotech.modelos.Usuario;
import com.tibia.bibliotech.repositorios.UsuarioRepositorio;

@Service
public class AutenticacaoServico {

  @Autowired
  private UsuarioRepositorio usuarioRepositorio;

  public boolean autenticar(Usuario usuario) {
    Usuario usuarioEncontrado = usuarioRepositorio.findByNomeAndSenha(usuario.getNome(), usuario.getSenha());
    if(usuarioEncontrado == null) {
      return false;
    }
    BibliotechApplication.auth = usuarioEncontrado;
    return true;
  }

  public void sair() {
    BibliotechApplication.auth = new Usuario();
  }
  
}