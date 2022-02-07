package com.webapi.ProjectApi.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cotacao implements Serializable {

  private static final long serialVersionUID = 1l;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String cepOrigem;

  @Column
  private String cepDestino;

  @Column
  private Double peso;

  @Column
  private String nomeDestinatario;

  @Column
  private Double valorFrete;

  @Column
  private int diasPrevEntrega;

  @Column
  private Date dataConsulta;

  public Cotacao(){}

  public Cotacao(Long id, String cepOrigem, String cepDestino, Double peso,
      String nomeDestinatario, Double valorFrete, int diasPrevEntrega, Date dataConsulta) {
    this.id = id;
    this.cepOrigem = cepOrigem;
    this.cepDestino = cepDestino;
    this.peso = peso;
    this.nomeDestinatario = nomeDestinatario;
    this.valorFrete = valorFrete;
    this.diasPrevEntrega = diasPrevEntrega;
    this.dataConsulta = dataConsulta;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCepOrigem() {
    return cepOrigem;
  }

  public void setCepOrigem(String cepOrigem) {
    this.cepOrigem = cepOrigem;
  }

  public String getCepDestino() {
    return cepDestino;
  }

  public void setCepDestino(String cepDestino) {
    this.cepDestino = cepDestino;
  }

  public Double getPeso() {
    return peso;
  }

  public void setPeso(Double peso) {
    this.peso = peso;
  }

  public String getNomeDestinatario() {
    return nomeDestinatario;
  }

  public void setNomeDestinatario(String nomeDestinatario) {
    this.nomeDestinatario = nomeDestinatario;
  }

  public Double getValorFrete() {
    return valorFrete;
  }

  public void setValorFrete(Double valorFrete) {
    this.valorFrete = valorFrete;
  }

  public int getDiasPrevEntrega() {
    return diasPrevEntrega;
  }

  public void setDiasPrevEntrega(int diasPrevEntrega) {
    this.diasPrevEntrega = diasPrevEntrega;
  }

  public Date getDataConsulta() {
    return dataConsulta;
  }

  public void setDataConsulta(Date dataConsulta) {
    this.dataConsulta = dataConsulta;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Cotacao{");
    sb.append("id=").append(id);
    sb.append(", cepOrigem='").append(cepOrigem).append('\'');
    sb.append(", cepDestino='").append(cepDestino).append('\'');
    sb.append(", peso=").append(peso);
    sb.append(", nomeDestinatario='").append(nomeDestinatario).append('\'');
    sb.append(", valorFrete=").append(valorFrete);
    sb.append(", diasPrevEntrega=").append(diasPrevEntrega);
    sb.append(", dataConsulta=").append(dataConsulta);
    sb.append('}');
    return sb.toString();
  }
}
