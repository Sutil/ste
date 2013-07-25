package br.com.ste.app.tabuada.web;

import java.io.Serializable;

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
		this.respondidas = 0;
		this.certas = 0;
		this.acessos = 0;
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
	public String toString() {
		return Objects.toStringHelper(this).add("id", id)
				.add("acessos", acessos)
				.add("certas", certas)
				.add("respostas", respondidas).toString();
		
	}
	
	public void atualizar(TabuadaBean tabuadaBean) {
		instance.respondidas += tabuadaBean.getRespondidas();
		instance.certas += tabuadaBean.getCertas();
	}

	public int getRespondidas() {
		return respondidas;
	}

	public void setRespondidas(int respondidas) {
		this.respondidas = respondidas;
	}

	public int getCertas() {
		return certas;
	}

	public void setCertas(int certas) {
		this.certas = certas;
	}
	
	public int getAcessos() {
		return acessos;
	}
	
	public void setAcessos(int acessos) {
		this.acessos = acessos;
	}
	
	public Long getId() {
		return id;
	}
	
	

}
