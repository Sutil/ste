package br.com.ste.app.tabuada;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.ste.app.tabuada.web.EstatisticaBean;

import com.google.common.base.Objects;

@Entity
public class Estatistica implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private int respondidas;
	
	private int certas;
	
	private int acesso;
	
	Estatistica(){
	}
	
	private Estatistica(EstatisticaBean e) {
		this.respondidas = e.getRespondidas();
		this.certas = e.getCertas();
		this.id = e.getId();
		this.acesso = e.getAcessos();
	}
	
	public static Estatistica newInstance(EstatisticaBean e) {
		checkNotNull(e);
		return new Estatistica(e);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Estatistica) {
			Estatistica other = (Estatistica) obj;
			return Objects.equal(this.respondidas, other.respondidas) &&
				   Objects.equal(this.certas, other.certas)	;
		}
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(respondidas, certas);
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("respondidas", respondidas).add("certas", certas).toString();
	}
	
	public int getCertas() {
		return certas;
	}
	
	public int getRespondidas() {
		return respondidas;
	}
	
	public int getAcesso() {
		return acesso;
	}
	
	public Long getId() {
		return id;
	}

}
