package br.com.AppEsporteAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.AppEsporteAPI.model.Skate;

@Repository
public interface ISkateRepository extends CrudRepository<Skate, Integer> {

}