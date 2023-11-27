package com.tibia.bibliotech.servicos;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArquivoServico {

  @Value("${media.upload.directory}")
  private String diretorio;

  public String salvar(MultipartFile arquivo) throws IOException {
    File directory = new File(diretorio);
    if (!directory.exists()) {
      directory.mkdirs();
    }
    String nomeArquivo = System.currentTimeMillis() + "_" + arquivo.getOriginalFilename();
    Path caminhoArquivo = Path.of(diretorio, nomeArquivo);
    Files.copy(arquivo.getInputStream(), caminhoArquivo, StandardCopyOption.REPLACE_EXISTING);
    return "uploads/" + nomeArquivo;
  }

  public void deletar(String nomeDoArquivo) {
    File arquivo = new File(nomeDoArquivo);
    arquivo.delete();
  }
  
}