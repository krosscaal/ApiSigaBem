package com.webapi.ProjectApi.Service;

import com.webapi.ProjectApi.Entities.Cotacao;
import java.util.List;
import java.util.Optional;

public interface CotacaoService {

  public List<Cotacao> findAll();
  public Optional<Cotacao> find(Long id);
  public Cotacao create(Cotacao cotacao);

}
