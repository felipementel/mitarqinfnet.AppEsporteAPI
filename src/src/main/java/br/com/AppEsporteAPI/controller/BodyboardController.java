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

import br.com.AppEsporteAPI.model.Bodyboard;
import br.com.AppEsporteAPI.service.BodyboardService;

@RestController
@RequestMapping("/api/bodyboard/")
public class BodyboardController {
	
	@Autowired
	private BodyboardService service;	

	@GetMapping 
	public List<Bodyboard> obterLista(){
		return service.obterLista();
	}
	
	@RequestMapping("{id}")
	public Optional<Bodyboard> obterPorId(@PathVariable Integer id) {
		return service.obterPorId(id);
	}	
	
	@PostMapping
	public void incluir(@RequestBody Bodyboard bodyboard) {
		service.incluir(bodyboard);	
	}
	
	@DeleteMapping("{id}")
	public void excluir(@PathVariable Integer id) {
		service.excluir(id);
	}	
}