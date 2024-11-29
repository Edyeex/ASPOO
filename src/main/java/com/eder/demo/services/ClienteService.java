package com.eder.demo.services;

import com.eder.demo.dtos.responses.ClienteResponse;
import com.eder.demo.dtos.responses.requests.ClienteRequest;
import com.eder.demo.models.Cliente;
import com.eder.demo.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
//***************** injecao de dependencia do ClienteController foi passada pra ca *
  final																		//******
  ClienteRepository repository;												//******
																			//******
  public ClienteService(ClienteRepository repository) {						//******
																			//******
	this.repository = repository;											//******
  }																			//******
//**********************************************************************************
  public List<ClienteResponse> findAll(){

	List<ClienteResponse> clientes = repository.findAll()
			 .stream()
			 .map(item -> ClienteResponse.converteParaClienteResponse(item))
			 .toList();
	return clientes;
  }

  public Cliente save(ClienteRequest clienteRequest){

	return repository.save(Cliente.converteParaCliente(clienteRequest));
  }
  public void deletarCliente(Long id) {
	repository.deleteById(id);
  }

  public Cliente atualizarCliente(Long id, ClienteRequest clienteAtualizado){
	Cliente cliente = repository.findById(id).get();

	cliente.setName(clienteAtualizado.getName());
	cliente.setIdade(clienteAtualizado.getIdade());
	cliente.setPassword(clienteAtualizado.getPassword());
	cliente.setProficao(clienteAtualizado.getProficao());

	return repository.save(cliente);
  }

  public Cliente listarClientePorId(Long id) {
	return repository.findById(id)
			.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
  }



}
