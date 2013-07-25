package br.com.ste.app.tabuada;

import static com.google.common.base.Preconditions.checkArgument;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.google.common.base.Objects;

@Entity
public class Estatistica implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private int respondidas;
	
	private int certas;
	
	Estatistica(){
	}
	
	private Estatistica(int respondidas, int certas) {
		this.respondidas = respondidas;
		this.certas = certas;
	}
	
	public static Estatistica newInstance(int respondidas, int certas) {
		checkArgument(respondidas >= 0);
		checkArgument(certas >= 0);
		return new Estatistica(respondidas, certas);
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
	

}
