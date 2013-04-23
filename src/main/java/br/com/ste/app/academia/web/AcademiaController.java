package br.com.ste.app.academia.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.ste.app.conteudo.Conteudo;
import br.com.ste.app.conteudo.repository.ConteudoRepository;
import br.com.ste.app.topico.Topico;
import br.com.ste.app.topico.repository.TopicoRepository;

@Controller
public class AcademiaController {
	
	@Autowired
	TopicoRepository topicoRepository;
	
	@Autowired
	ConteudoRepository conteudoRepository;
	
	public AcademiaBean newBean(){
		List<Topico> topicos = topicoRepository.findAll();
		List<Conteudo> conteudos = conteudoRepository.findAll();
		return new AcademiaBean(topicos, conteudos);
	}
	
	

}
