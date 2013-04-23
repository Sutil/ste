package br.com.ste.app.academia.web;

import java.io.Serializable;
import java.util.List;

import br.com.ste.app.conteudo.Conteudo;
import br.com.ste.app.topico.Topico;

import com.google.common.collect.Lists;

public class AcademiaBean implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private List<Topico> topicos = Lists.newLinkedList();
	
	private List<Conteudo> conteudosSelecionados = Lists.newLinkedList();
	
	private List<Conteudo> conteudos = Lists.newLinkedList();
	
	private Topico topicoSelecionado;
	
	public AcademiaBean(List<Topico> topicos, List<Conteudo> conteudos){
		this.topicos = topicos;
		this.conteudos = conteudos;
	}
	
	public void selectTopico(Topico topico){
		conteudosSelecionados.clear();
		for (Conteudo c : conteudos){
			if(c.getTopico().equals(topico)){
				conteudosSelecionados.add(c);
			}
		}
	}

	public List<Topico> getTopicos() {
		return topicos;
	}

	public void setTopicos(List<Topico> topicos) {
		this.topicos = topicos;
	}

	public List<Conteudo> getConteudos() {
		return conteudos;
	}

	public void setConteudos(List<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}

	public Topico getTopicoSelecionado() {
		return topicoSelecionado;
	}

	public void setTopicoSelecionado(Topico topicoSelecionado) {
		this.topicoSelecionado = topicoSelecionado;
	}
	
	public List<Conteudo> getConteudosSelecionados() {
		return conteudosSelecionados;
	}
	
	public void setConteudosSelecionados(List<Conteudo> conteudosSelecionados) {
		this.conteudosSelecionados = conteudosSelecionados;
	}
	

}
