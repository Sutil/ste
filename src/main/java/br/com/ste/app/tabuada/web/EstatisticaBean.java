package br.com.ste.app.tabuada.web;

import java.io.Serializable;

import br.com.ste.app.Percentual;
import br.com.ste.app.tabuada.Estatistica;

import com.google.common.base.Objects;


public class EstatisticaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private int respondidas;
	
	private int certas;
	
	private int acessos = 1;
	
	private static EstatisticaBean instance;
	
	private EstatisticaBean(Estatistica e){
			this.id = e.getId();
			this.respondidas = e.getRespondidas();
			this.certas = e.getCertas();
			this.acessos = e.getAcesso();
	}
	
	private EstatisticaBean(){
	}
	
	public static EstatisticaBean instance() {
		if(instance == null) {
			System.out.println("igual a null");
			instance = new EstatisticaBean();
		}
		return instance;
	}
	
	public static EstatisticaBean instance(Estatistica e) {
		if(instance == null) {
			System.out.println("igual a null");
			instance = new EstatisticaBean(e);
		}
		return instance;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof EstatisticaBean) {
			EstatisticaBean other = (EstatisticaBean) obj;
			return Objects.equal(this.respondidas, other.respondidas);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(respondidas);
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("id", id)
				.add("acessos", acessos)
				.add("certas", certas)
				.add("respostas", respondidas).toString();
		
	}
	
	public void atualizar(TabuadaBean TBean) {
		this.respondidas ++;
		this.certas = TBean.isCorreto() ? certas + 1 : certas;
		System.out.println("respondidas = "+this.respondidas);
		System.out.println("certas = "+this.certas);
	}
	
	public void addAcesso() {
		this.acessos++;
		System.out.println("acessos = "+this.acessos);
	}
	
	public String getPercentualAcerto(){
		return Percentual.newInstance(respondidas, certas).formatScreen();
	}
	
	public String getPercentualErro() {
		int erros = respondidas - certas;
		return Percentual.newInstance(respondidas, erros).formatScreen();
	}

	public int getRespondidas() {
		return respondidas;
	}

	
	public int getCertas() {
		return certas;
	}
	
	public int getAcessos() {
		return acessos;
	}
	
	
	public Long getId() {
		return id;
	}
	
	

}
