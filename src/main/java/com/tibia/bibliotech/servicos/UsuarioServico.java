package com.tibia.bibliotech.servicos;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.tibia.bibliotech.modelos.Usuario;
import com.tibia.bibliotech.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServico implements UserDetailsService {

  @Autowired
  private UsuarioRepositorio usuarioRepositorio;

  public List<Usuario> lista() {
    return usuarioRepositorio.findAll();
  }

  public Usuario buscarPeloNomeESenha(Usuario usuario) {
    return usuarioRepositorio.findByNomeAndSenha(usuario.getNome(), usuario.getSenha());
  }

  public Usuario buscarPeloId(Long id) {
    return usuarioRepositorio.findById(id).get();
  }

  public Usuario criar(Usuario usuario) {
    usuario.setCriadoEm(new Date());
    return usuarioRepositorio.save(usuario);
  }

  public Usuario editarPeloId(Usuario usuario, Long id) {
    Usuario usuarioEncontrado = usuarioRepositorio.findById(id).get();
    usuario.setId(id);
    if(usuario.getSenha().isEmpty()) {
      usuario.setSenha(usuarioEncontrado.getSenha());
    }
    usuario.setCriadoEm(usuarioEncontrado.getCriadoEm());
    return usuarioRepositorio.save(usuario);
  }

  public void deletarPeloId(Long id) {
    usuarioRepositorio.deleteById(id);
  }

  @Override
  public Usuario loadUserByUsername(String username) {
    return usuarioRepositorio.findByNome(username);
  }
  
}