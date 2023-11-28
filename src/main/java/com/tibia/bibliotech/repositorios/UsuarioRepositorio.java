package com.tibia.bibliotech.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tibia.bibliotech.modelos.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario,Long>{

  public Usuario findByNomeAndSenha(String nome, String senha);
  public Usuario findByNome(String nome);
    
}