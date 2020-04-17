package br.com.AppEsporteAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.AppEsporteAPI.model.Bodyboard;
import br.com.AppEsporteAPI.repository.IBodyboardRepository;

@Service
public class BodyboardService {
	
	@Autowired
	private IBodyboardRepository repository;
	
	public List<Bodyboard> obterLista(){
		return (List<Bodyboard>)repository.findAll();
	}	
	
	public Optional<Bodyboard> obterPorId(Integer id) {
		return repository.findById(id);
	}	
		
	public void incluir(Bodyboard bodyboard) {
		repository.save(bodyboard);		
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}

	public IBodyboardRepository getRepository() {
		return repository;
	}

	public void setRepository(IBodyboardRepository repository) {
		this.repository = repository;
	}
}