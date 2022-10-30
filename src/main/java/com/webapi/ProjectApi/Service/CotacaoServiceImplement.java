package com.webapi.ProjectApi.Service;

import com.webapi.ProjectApi.Entities.Cotacao;
import com.webapi.ProjectApi.Repository.CotacaoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CotacaoServiceImplement implements CotacaoService{

  @Autowired
  private CotacaoRepository cotacaoRepository;

  @Override
  public List<Cotacao> findAll() {
    return this.cotacaoRepository.findAll();
  }

  @Override
  public Optional<Cotacao> find(Long id) {
    return this.cotacaoRepository.findById(id);
  }

  @Override
  public Cotacao create(Cotacao cotacao) {
    this.cotacaoRepository.save(cotacao);
    return cotacao;
  }
}
