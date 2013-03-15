package br.com.ste.app.home.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mysema.query.types.OrderSpecifier;

import br.com.ste.app.conteudo.Conteudo;
import br.com.ste.app.conteudo.QConteudo;
import br.com.ste.app.conteudo.repository.ConteudoRepository;
import br.com.ste.app.topico.Topico;
import br.com.ste.app.topico.repository.TopicoRepository;

@Controller
public class HomeController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private ConteudoRepository conteudoRepository;
	
	public List<Topico> getTopicos(){
		return topicoRepository.findAll();
	}
	
	public List<Conteudo> getConteudos(Topico topico){
		return conteudoRepository.findAll(QConteudo.conteudo.topico.eq(topico));
		
	}
	
}
