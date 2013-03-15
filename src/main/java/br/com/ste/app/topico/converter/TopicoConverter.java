package br.com.ste.app.topico.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import br.com.ste.app.topico.Topico;
import br.com.ste.app.topico.repository.TopicoRepository;

@Configurable
@FacesConverter(value="topicoConverter", forClass = Topico.class)
public class TopicoConverter implements Converter{
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if(value != null){
			System.err.println("ret obj");
			Long id = Long.parseLong(value);
			return topicoRepository.findOne(id);
		}
		return null;
	}
	
	
	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if(value != null){
			System.err.println("ret str");
			Topico topico = (Topico) value;
			return String.valueOf(topico.getId());
		}
		return null;
	}

}
