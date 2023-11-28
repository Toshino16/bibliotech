package com.tibia.bibliotech.controles;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tibia.bibliotech.servicos.ArquivoServico;

@RestController @RequestMapping("/uploads")
public class UploadControle {

  @Autowired
  private ArquivoServico arquivoServico;

  @GetMapping("/{imagem}")
  public ByteArrayResource buscarImage(@PathVariable String imagem) throws IOException {
    return arquivoServico.carregar(imagem);
  }
  
}