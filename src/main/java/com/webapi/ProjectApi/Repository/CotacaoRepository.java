package com.webapi.ProjectApi.Repository;

import com.webapi.ProjectApi.Entities.Cotacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CotacaoRepository extends JpaRepository<Cotacao,Long> {

}
