package br.com.AppEsporteAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.AppEsporteAPI.model.Bicicleta;

@Repository
public interface IBicicletaRepository extends CrudRepository<Bicicleta, Integer> {

}