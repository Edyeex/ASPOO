package com.eder.demo.models;

import com.eder.demo.dtos.responses.requests.ClienteRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "clientes")// Já com um nome definido padrão para a tabela, se não colocar nada ela se chamará CLIENTES
//---------------------------
@Getter					//---LOMBOK
@Setter					//---Assim não precisa fazer todos aquele GETTER e SETTER de cada atributo da entidade criada
//---------------------------
public class Cliente {

  @Id // identificador unico
  @GeneratedValue(strategy = GenerationType.AUTO) // pra gerar um valor ID automaticamente, sem precisar passar no POSTMAM
  private long id;
  private String password;
  //*****************************
  private String name;       //**
  private Integer idade;     //** Só precisa passar o nome, idade e proficao no POSTMAM
  private String proficao;   //** O id vai ser gerado automaticamente, assim evita repeticao de id e erros
  private int salario;
  //*****************************

  public static Cliente converteParaCliente(ClienteRequest clienteRequest){
    Cliente cliente = new Cliente();
    cliente.setName(clienteRequest.getName());
    cliente.setIdade(clienteRequest.getIdade());
    cliente.setProficao(clienteRequest.getProficao());
    cliente.setSalario(clienteRequest.getSalario());
    cliente.setPassword(clienteRequest.getPassword());

    return cliente;
  }
}
