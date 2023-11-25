package com.tibia.bibliotech.servicos;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tibia.bibliotech.modelos.Jogo;
import com.tibia.bibliotech.repositorios.JogoRepositorio;

@Service
public class JogoServico {

  @Autowired
  private JogoRepositorio jogoRepositorio;

  public List<Jogo> lista() {
    return jogoRepositorio.findAll();
  }

  public Jogo buscarPeloId(Long id) {
    return jogoRepositorio.findById(id).get();
  }

  public Jogo criar(Jogo jogo) {
    jogo.setCadastradoEm(new Date());
    return jogoRepositorio.save(jogo);
  }

  public Jogo editarPeloId(Jogo usuario, Long id) {
    Jogo jogoEncontrado = jogoRepositorio.findById(id).get();
    usuario.setId(id);
    usuario.setCadastradoEm(jogoEncontrado.getCadastradoEm());
    return jogoRepositorio.save(usuario);
  }

  public void deletarPeloId(Long id) {
    jogoRepositorio.deleteById(id);
  }
  
}