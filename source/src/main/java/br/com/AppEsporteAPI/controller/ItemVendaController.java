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

import br.com.AppEsporteAPI.model.ItemVenda;
import br.com.AppEsporteAPI.service.ItemVendaService;

@RestController
@RequestMapping("/api/itemvenda/")
public class ItemVendaController {

	@Autowired
	private ItemVendaService service;

	@GetMapping
	public List<ItemVenda> obterLista() {
		return service.obterLista();
	
	}

	@RequestMapping("{id}")
	public Optional<ItemVenda> obterPorId(@PathVariable Integer id) {
		return service.obterPorId(id);
	}

	@PostMapping
	public void incluir(@RequestBody ItemVenda itemVenda) {
		service.incluir(itemVenda);
	}

	@DeleteMapping("{id}")
	public void excluir(@PathVariable Integer id) {
		service.excluir(id);
	}

}
