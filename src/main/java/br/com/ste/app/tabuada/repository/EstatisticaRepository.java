package br.com.ste.app.tabuada.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ste.app.repository.ListQueryDslPredicateExecutor;
import br.com.ste.app.tabuada.Estatistica;

public interface EstatisticaRepository extends JpaRepository<Estatistica, Long>, ListQueryDslPredicateExecutor<Estatistica> {

}
