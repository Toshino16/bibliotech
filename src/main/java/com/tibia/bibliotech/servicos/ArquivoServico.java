package com.tibia.bibliotech.servicos;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArquivoServico {

  @Value("${media.upload.directory}")
  private String caminhoDiretorio;

  public String salvar(MultipartFile arquivo) throws IOException {
    iniciarDiretorio();
    String nomeArquivo = System.currentTimeMillis() + "_" + arquivo.getOriginalFilename();
    Path caminhoArquivo = Path.of(caminhoDiretorio, nomeArquivo);
    Files.copy(arquivo.getInputStream(), caminhoArquivo, StandardCopyOption.REPLACE_EXISTING);
    return nomeArquivo;
  }

  public void editar(MultipartFile arquivo, String nomeArquivo) throws IOException {
    iniciarDiretorio();
    Path caminhoArquivo = Path.of(caminhoDiretorio, nomeArquivo);
    Files.copy(arquivo.getInputStream(), caminhoArquivo, StandardCopyOption.REPLACE_EXISTING);
  }

  public void deletar(String nomeDoArquivo) {
    File arquivo = new File(nomeDoArquivo);
    arquivo.delete();
  }

  public ByteArrayResource carregar(String nomeArquivo) throws IOException {
    Path caminhoArquivo = Path.of(caminhoDiretorio, nomeArquivo);
    return new ByteArrayResource(Files.readAllBytes(caminhoArquivo));
  }

  private void iniciarDiretorio() {
    File diretorio = new File(caminhoDiretorio);
    if (!diretorio.exists()) {
      diretorio.mkdirs();
    }
  }
  
}