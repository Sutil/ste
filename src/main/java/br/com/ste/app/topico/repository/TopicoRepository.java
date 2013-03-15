package br.com.ste.app.topico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ste.app.repository.ListQueryDslPredicateExecutor;
import br.com.ste.app.topico.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>, ListQueryDslPredicateExecutor<Topico>{

}
