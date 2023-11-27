package com.tibia.bibliotech.servicos;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArquivoServico {

  private Path root = Paths.get("./uploads");

  public ArquivoServico() throws IOException {
    Files.createDirectories(root);
  }

  public void salvar(MultipartFile arquivo) {
    try {
      Files.copy(arquivo.getInputStream(), root.resolve(arquivo.getOriginalFilename()));
    } catch (Exception e) {
      if (e instanceof FileAlreadyExistsException) {
        throw new RuntimeException("Um arquivo com esse nome já existe");
      }

      throw new RuntimeException(e.getMessage());
    }
  }

  public void deletar(String nomeDoArquivo) {
    File arquivo = new File("./uploads/" + nomeDoArquivo);
    arquivo.delete();
  }
  
}