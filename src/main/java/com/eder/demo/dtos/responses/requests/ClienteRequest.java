package com.eder.demo.dtos.responses.requests;

import com.eder.demo.dtos.responses.ClienteResponse;
import com.eder.demo.models.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ClienteRequest {
  private String name;
  private String password;
  private Integer idade;
  private String proficao;
  private int salario;


}
