package br.com.AppEsporteAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.AppEsporteAPI.model.Cliente;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Integer> {

}
