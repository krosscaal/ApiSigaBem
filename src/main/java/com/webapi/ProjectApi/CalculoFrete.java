package com.webapi.ProjectApi;

import com.webapi.ProjectApi.Entities.Cotacao;
import java.util.Date;
import org.json.JSONObject;

public class CalculoFrete {
  /**
   * Implementar para empresa de transporte de cargas SigaBem o endpoint para o cálculo do preço do frete:
   *
   * Você deve calcular o valor total do frete e a data prevista da entrega.
   *
   * Considerar regras para calcular o valor do frete:
   *
   *     CEPs com DDDs iguais tem 50% de desconto no valor do frete e entrega prevista de 1 dia
   *     CEPs de estados iguais tem 75% de desconto no valor do frete e entrega prevista de 3 dias
   *     CEPs de estados diferentes não deve ser aplicado o desconto no valor do frete e entrega prevista de 10 dias
   *     O valor do frete é cobrado pelo peso da encomenda, o valor para cada KG é R$1,00
   *
   * Seu input de entrada deve ser “peso”, “cepOrigem”, “cepDestino” e “nomeDestinatario“
   *
   * Você utilizará a API gratuita de consulta de CEP abaixo: Documentação da API: https://viacep.com.br/ Exemplo do GET: https://viacep.com.br/ws/<CEP_A_CONSULTAR>/json/
   *
   * Endpoint pode ser público Response/Output deve possuir: “vlTotalFrete” e “dataPrevistaEntrega”, “cepOrigem” e “cepDestino” Deve ser persistido no banco os valores da cotação os valores consultados: “peso”, “cepOrigem”, “cepDestino”, “nomeDestinatario”, “vlTotalFrete”, “dataPrevistaEntrega” e “dataConsulta”
   * **/
  public CalculoFrete(){}

  public static Cotacao calculos(Double peso, String jsonCep1, String jsonCep2, String nomeDestinatario){
    Cotacao resConsul = new Cotacao();
    Double valorKg = 1.00;
    Integer dias = 0;
    Double valorTotFrete = peso*valorKg;
    JSONObject cepOr = new JSONObject(jsonCep1);
    JSONObject cepdest = new JSONObject(jsonCep2);

    if( cepOr.get("ddd").equals(cepdest.get("ddd"))){
      valorTotFrete *= 0.50;
      dias=1;
    }else if(cepOr.get("cep").toString().charAt(0)==cepdest.get("cep").toString().charAt(0)){
      valorTotFrete -= (valorTotFrete*0.75);
      dias=3;
    }else {
      dias=10;
    }
    resConsul.setCepOrigem(cepOr.get("cep").toString());
    resConsul.setCepDestino(cepdest.get("cep").toString());
    resConsul.setPeso(peso);
    resConsul.setNomeDestinatario(nomeDestinatario);
    resConsul.setValorFrete(valorTotFrete);
    resConsul.setDiasPrevEntrega(dias);
    resConsul.setDataConsulta(new Date());
    return resConsul;
  }
}
