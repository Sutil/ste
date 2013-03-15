package br.com.ste.app.conteudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ste.app.conteudo.Conteudo;
import br.com.ste.app.repository.ListQueryDslPredicateExecutor;

public interface ConteudoRepository extends JpaRepository<Conteudo, Long>, ListQueryDslPredicateExecutor<Conteudo> {

}
