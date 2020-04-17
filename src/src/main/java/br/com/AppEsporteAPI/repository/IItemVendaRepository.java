package br.com.AppEsporteAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.AppEsporteAPI.model.ItemVenda;

@Repository
public interface IItemVendaRepository extends CrudRepository<ItemVenda, Integer> {

}
