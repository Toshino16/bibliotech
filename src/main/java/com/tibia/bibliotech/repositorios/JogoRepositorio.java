package com.tibia.bibliotech.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tibia.bibliotech.modelos.Jogo;

@Repository
public interface JogoRepositorio extends JpaRepository<Jogo, Long> {
  
}