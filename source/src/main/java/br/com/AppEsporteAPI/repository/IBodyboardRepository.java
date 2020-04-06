package br.com.AppEsporteAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.AppEsporteAPI.model.Bodyboard;

@Repository
public interface IBodyboardRepository extends CrudRepository<Bodyboard, Integer> {

}