package br.com.AppEsporteAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.AppEsporteAPI.model.Bicicleta;
import br.com.AppEsporteAPI.repository.IBicicletaRepository;

@Service
public class BicicletaService {
	
	@Autowired
	private IBicicletaRepository repository;
	
	public List<Bicicleta> obterLista(){
		return (List<Bicicleta>)repository.findAll();
	}	
	
	public Optional<Bicicleta> obterPorId(Integer id) {
		return repository.findById(id);
	}	
		
	public void incluir(Bicicleta bicicleta) {
		repository.save(bicicleta);		
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}

	public IBicicletaRepository getRepository() {
		return repository;
	}

	public void setRepository(IBicicletaRepository repository) {
		this.repository = repository;
	}
}