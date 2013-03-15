package br.com.ste.app.conteudo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import br.com.ste.app.conteudo.Conteudo;
import br.com.ste.app.conteudo.repository.ConteudoRepository;


@Configurable
@FacesConverter(value="ConteudoConverter", forClass=Conteudo.class)
public class ConteudoConverter implements Converter {
	
	@Autowired
	private ConteudoRepository conteudoRepository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null){
			Long id = Long.parseLong(value);
			return conteudoRepository.findOne(id);
		}
		return null;
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			Conteudo conteudo = (Conteudo) value;
			return String.valueOf(conteudo.getId());
		}
		return null;
	}

}
