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

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.AppEsporteAPI.model.Venda;
import br.com.AppEsporteAPI.service.VendaService;

@RestController
@RequestMapping("/api/venda/")
public class VendaController {

	@Autowired
	private VendaService service;

	@GetMapping
	public List<Venda> obterLista() {
		return service.obterLista();
	}

	@RequestMapping("{id}")
	public Optional<Venda> obterPorId(@PathVariable Integer id) throws JsonProcessingException {

		/*
		 * Venda s = service.obterPorId(id).get(); ObjectMapper mapper = new
		 * ObjectMapper(); String json = mapper.writeValueAsString(s);
		 * 
		 * System.out.println(json);
		 */

		return service.obterPorId(id);
	}

	@PostMapping
	public void incluir(@RequestBody Venda solicitacao) {
		service.incluir(solicitacao);
	}

	@DeleteMapping("{id}")
	public void excluir(@PathVariable Integer id) {
		service.excluir(id);
	}

}
