package br.com.ste.app.tabuada.web;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import br.com.ste.app.tabuada.Tabuada;

public class TabuadaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Tabuada tabuada;
	
	private int resposta;
	
	private TabuadaBean(Tabuada tabuada) {
		this.tabuada = tabuada;
	}
	
	public static TabuadaBean newInstance(Tabuada tabuada){
		checkNotNull(tabuada);
		return new TabuadaBean(tabuada);
	}
	
	public Tabuada getTabuada() {
		return tabuada;
	}
	
	public int getResposta() {
		return resposta;
	}
	
	public void setResposta(int resposta) {
		this.resposta = resposta;
	}
	
	public boolean isCorreto(){
		return tabuada.getResultado() == this.resposta;
	}
	

}
