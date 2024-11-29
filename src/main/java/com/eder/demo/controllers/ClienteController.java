package com.eder.demo.controllers;

import com.eder.demo.dtos.responses.ClienteResponse;
import com.eder.demo.dtos.responses.requests.ClienteRequest;
import com.eder.demo.models.Cliente;
import com.eder.demo.repositories.ClienteRepository;
import com.eder.demo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {


	final//************************Construtor do @Autowried
	ClienteService service;//******

  public ClienteController(ClienteService service) {
	this.service = service;
  }


  @GetMapping
  List<ClienteResponse> listaTodosClientes(){
	return service.findAll();

  }

  @GetMapping("/{id}")
  Cliente listarClientePorId(@PathVariable Long id){
	return service.listarClientePorId(id);
  }

  @PostMapping
  Cliente salvarCliente(@RequestBody ClienteRequest cliente){

	return service.save(cliente);
  }
  @DeleteMapping("/{id}")
  public void deletarCliente(@PathVariable Long id) {
	service.deletarCliente(id);

  }

  @PutMapping("/{id}")
  Cliente atualizarCliente(@PathVariable Long id, @RequestBody ClienteRequest cliente){
	return service.atualizarCliente(id, cliente);
  }

}
