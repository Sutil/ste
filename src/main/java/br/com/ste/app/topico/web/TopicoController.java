package br.com.ste.app.topico.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.ste.app.topico.Topico;
import br.com.ste.app.topico.repository.TopicoRepository;

@Controller
public class TopicoController {

	@Autowired
	private TopicoRepository topicoRepository;
	
	
	public void save(Topico topico) {
		topicoRepository.save(topico);
	}
	
	public Topico newTopico(){
		return Topico.newInstance("Novo tópico");
	}
	
	
	
}
