package br.com.ste.app.conteudo;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.PersistenceConstructor;

import br.com.ste.app.topico.Topico;

import com.google.common.base.Objects;

@Entity
public class Conteudo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Version
	Integer version;
	
	@ManyToOne
	@JoinColumn(name="topico_fk")
	private Topico topico;
	
	private String title;
	
	@Column(columnDefinition="TEXT")
	private String texto;
	
	/**
	 * somente para hibernate
	 */
	public Conteudo(){}

	@PersistenceConstructor
	private Conteudo(Long id, Topico topico, String title, String texto) {
		this.id = id;
		this.topico = topico;
		this.title = title;
		this.texto = texto;
	}
	
	
	public Conteudo newInstance(Long id, Topico topico, String title, String texto){
		checkNotNull(topico);
		checkNotNull(title);
		checkNotNull(texto);
		return new Conteudo(null, topico, title, texto);
	}
	
	

	public Topico getTopico() {
		return topico;
	}

	public String getTitle() {
		return title;
	}

	public String getTexto() {
		return texto;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setTopico(Topico topico) {
		this.topico = topico;
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("topico", topico).add("title", title).add("texto", texto).toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Conteudo){
			Conteudo other = (Conteudo) obj;
			return Objects.equal(other.texto, this.texto);
		}
		return false;
	}
	
	
	
	

}
