package br.com.AppEsporteAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.AppEsporteAPI.model.Cliente;
import br.com.AppEsporteAPI.service.ClienteService;

@RestController
@RequestMapping("/api/cliente/")
public class ClienteController {
	
	@Autowired
	private ClienteService service;	

	@GetMapping 
	public List<Cliente> obterLista(){
		return service.obterLista();
	}
	
	@RequestMapping("{id}")
	public Optional<Cliente> obterPorId(@PathVariable Integer id) {
		return service.obterPorId(id);
	}	
	
	@PostMapping
	public void incluir(@RequestBody Cliente cliente) {
		service.incluir(cliente);	
	}
	
	@DeleteMapping("{id}")
	public void excluir(@PathVariable Integer id) {
		service.excluir(id);
	}	
}