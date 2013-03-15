package br.com.ste.app.conteudo.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ch.qos.logback.core.filter.Filter;

import com.google.common.collect.Maps;

import br.com.ste.app.conteudo.Conteudo;
import br.com.ste.app.conteudo.repository.ConteudoRepository;
import br.com.ste.app.topico.Topico;
import br.com.ste.app.topico.repository.TopicoRepository;

@Controller
public class ConteudoController {

	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private ConteudoRepository conteudoRepository;
	
	public List<Topico> getTopicos(){
		return topicoRepository.findAll(); 
	}
	
	public Map<String, Topico> getMapTopicos(){
		List<Topico> topicos = topicoRepository.findAll();
		Map<String, Topico> mapTopicos = Maps.newHashMap();
		for(Topico t: topicos){
			mapTopicos.put(t.getTitle(), t);
		}
		return mapTopicos;
	}
	
	public Conteudo newConteudo(){
		return new Conteudo();
	}
	
	public void save(Conteudo conteudo){
		conteudoRepository.save(conteudo);
	}
	
	public ConteudoFiltro newFiltro(){
		return new ConteudoFiltro();
	} 
	
	public List<Conteudo> filtrar(ConteudoFiltro filtro){
		return conteudoRepository.findAll(filtro.toPredicate());
	}
	
}
