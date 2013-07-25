package br.com.ste.app.tabuada.web;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import br.com.ste.app.tabuada.Estatistica;

public class EstatisticaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int respondidas;
	
	private int certas;
	
	private static EstatisticaBean instance;
	
	private EstatisticaBean(Estatistica e){
		this.respondidas = e.getRespondidas();
		this.certas = e.getCertas();
	}
	
	public static EstatisticaBean instance(Estatistica e) {
		checkNotNull(e);
		if(instance == null) {
			instance = new EstatisticaBean(e);
		}
		return instance;
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

}
