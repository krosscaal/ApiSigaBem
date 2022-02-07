package com.webapi.ProjectApi.Resources;
import com.webapi.ProjectApi.CalculoFrete;
import com.webapi.ProjectApi.Entities.Cotacao;
import com.webapi.ProjectApi.Service.CotacaoService;
import com.webapi.ProjectApi.Utils.Converte;
import io.swagger.annotations.ApiOperation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

@Api(value = "REST API SigaBem")
@RestController
@RequestMapping("/Api")
public class CotacaoResource {

  @Autowired
  CotacaoService cotacaoService;

  public CotacaoResource(CotacaoService cotacaoService){
    this.cotacaoService=cotacaoService;
  }

  @ApiOperation(value = "Cálculo do frete e persistencia")
  @GetMapping(value = "/{peso}/{cep1}/{cep2}/{nome}")
  public ResponseEntity<Cotacao> pegarDados(@PathVariable(value = "peso") Double peso,
      @PathVariable(value = "cep1") String cep1,
      @PathVariable(value = "cep2") String cep2,
      @PathVariable(value = "nome") String nome)
      throws IOException {

    if(cep1.length()==8 && cep2.length()==8) {
      URL url = new URL("https://viacep.com.br/ws/" + cep1 + "/json/");
      URL url1 = new URL("https://viacep.com.br/ws/" + cep2 + "/json/");
      HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
      HttpURLConnection conexao1 = (HttpURLConnection) url1.openConnection();
      if ((conexao.getResponseCode() == 200) && (conexao1.getResponseCode() == 200)) {
        BufferedReader resp = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        BufferedReader resp1 = new BufferedReader(new InputStreamReader(conexao1.getInputStream()));

        String jsonToString = Converte.jsonToString(resp);
        String jsonToString1 = Converte.jsonToString(resp1);
        if(jsonToString.contains("erro")||jsonToString1.contains("erro")){
          //return "ERRO NA REQUISIÇÃO, UM DOS CEP(S) NÃO EXISTE, VERIFIQUE E TENTE NOVAMENTE";
          return ResponseEntity.notFound().build();
        }
        Cotacao novaCotacao = CalculoFrete.calculos(peso, jsonToString, jsonToString1, nome);
        Cotacao obj = cotacaoService.create(novaCotacao);
        return ResponseEntity.ok().body(obj);
        //return novaCotacao.toString();

      }
      //return "ERRO NA REQUISIÇÃO, O(S) CEP(S) DEVEM CONTER SOMENTE NUMEROS, TENTE NOVAMENTE";
      return ResponseEntity.badRequest().build();
    }else {
      //return "ERRO NA REQUISIÇÃO, VERIFIQUE OS CEP(S) E TENTE NOVAMENTE";
      return ResponseEntity.badRequest().build();
    }
  }

  @ApiOperation(value = "Listar todas as Consultas")
  @GetMapping
  public ResponseEntity<List<Cotacao>> listAll(){
    List<Cotacao> lista = cotacaoService.findAll();
    return ResponseEntity.ok().body(lista);
  }

  @ApiOperation(value = "Buscar por número de consulta")
  @GetMapping(value = "/{id}")
  public ResponseEntity<Optional<Cotacao>> findById(@PathVariable("id") Long id){
    Optional<Cotacao> obj = cotacaoService.find(id);
    return ResponseEntity.ok().body(obj);
  }


}
