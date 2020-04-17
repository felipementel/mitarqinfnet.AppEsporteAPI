package br.com.AppEsporteAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.AppEsporteAPI.model.Cliente;
import br.com.AppEsporteAPI.repository.IClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private IClienteRepository repository;
	
	public List<Cliente> obterLista(){
		return (List<Cliente>)repository.findAll();
	}	
	
	public Optional<Cliente> obterPorId(Integer id) {
		return repository.findById(id);
	}	
		
	public IClienteRepository getRepository() {
		return repository;
	}

	public void setRepository(IClienteRepository repository) {
		this.repository = repository;
	}

	public void incluir(Cliente cliente) {
		repository.save(cliente);		
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}
}
