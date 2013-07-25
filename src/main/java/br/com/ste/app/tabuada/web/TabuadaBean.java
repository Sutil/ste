package br.com.ste.app.tabuada.web;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.ste.app.tabuada.Tabuada;

public class TabuadaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Tabuada tabuada;
	
	private String resposta;
	
	private int respondidas;
	
	private int certas;
	
	private TabuadaBean(Tabuada tabuada) {
		this.tabuada = tabuada;
	}
	
	public static TabuadaBean newInstance(){
		return new TabuadaBean(Tabuada.newInstace());
	}
	
	public Tabuada getTabuada() {
		return tabuada;
	}
	
	public String getResposta() {
		return resposta;
	}
	
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	public int getRespondidas() {
		return respondidas;
	}
		
	public int getCertas() {
		return certas;
	}
	
	public int getErradas(){
		return respondidas - certas;
	}
	
	public boolean isCorreto(){
		int resp = 0;
		try {
		 resp = Integer.valueOf(resposta);
		 return tabuada.getResultado() == resp;
		}catch (Exception e) {
			System.err.println("Erro de conversão de numero.");
			return false;
		}
	}
	
	public void responder(ActionEvent actionEvent) {
		respondidas ++;
		if(isCorreto()) {
			certas++;
		}
		else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resposta errada!", tabuada.getA()+" x "+tabuada.getB()+" = "+tabuada.getResultado());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		this.tabuada = Tabuada.newInstace();
		this.resposta = "";
	}  
	

}
