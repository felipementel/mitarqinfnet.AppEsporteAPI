package br.com.AppEsporteAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.AppEsporteAPI.model.Venda;

@Repository
public interface IVendaRepository extends CrudRepository<Venda, Integer> {

}
