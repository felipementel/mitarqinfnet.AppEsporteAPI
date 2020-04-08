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

import br.com.AppEsporteAPI.model.Skate;
import br.com.AppEsporteAPI.service.SkateService;

@RestController
@RequestMapping("/api/skate/")
public class SkateController {
	
	@Autowired
	private SkateService service;	

	@GetMapping 
	public List<Skate> obterLista(){
		return service.obterLista();
	}
	
	@RequestMapping("{id}")
	public Optional<Skate> obterPorId(@PathVariable Integer id) {
		return service.obterPorId(id);
	}	
	
	@PostMapping
	public void incluir(@RequestBody Skate skate) {
		service.incluir(skate);	
	}
	
	@DeleteMapping("{id}")
	public void excluir(@PathVariable Integer id) {
		service.excluir(id);
	}	
}