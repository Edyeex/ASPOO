package com.eder.demo.dtos.responses;

import com.eder.demo.models.Cliente;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClienteResponse {
  private String name;
  private Integer idade;
  private String proficao;
  private int salario;

  public static ClienteResponse converteParaClienteResponse(Cliente cliente){
    ClienteResponse clienteResponse = new ClienteResponse();
    clienteResponse.setName(cliente.getName());
    clienteResponse.setIdade(cliente.getIdade());
    clienteResponse.setProficao(cliente.getProficao());
    clienteResponse.setSalario(cliente.getSalario());
    return clienteResponse;
  }
}
