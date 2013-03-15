package br.com.ste.app.conteudo.web;

import java.io.Serializable;
import java.util.List;

import br.com.ste.app.conteudo.QConteudo;
import br.com.ste.app.topico.Topico;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;

public class ConteudoFiltro implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private List<Topico> topicos = Lists.newLinkedList();

	private String titulo;

	public String getTitulo() {
		return titulo;
	}

	public List<Topico> getTopicos() {
		return topicos;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setTopicos(List<Topico> topicos) {
		this.topicos = topicos;
	}
	
	public Predicate toPredicate(){
		QConteudo qConteudo = QConteudo.conteudo;
		BooleanBuilder builder = new BooleanBuilder();
		if(topicos != null && !topicos.isEmpty()){
			builder.and(qConteudo.topico.in(topicos));
		}
		if(!Strings.isNullOrEmpty(titulo)){
			builder.and(qConteudo.title.containsIgnoreCase(titulo));
		}
		return builder;
		
	}

}
