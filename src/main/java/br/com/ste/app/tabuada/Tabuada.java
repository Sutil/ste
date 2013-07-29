package br.com.ste.app.tabuada;

import java.io.Serializable;

public class Tabuada implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int a;
	private int b;
	
	private Tabuada(int a, int b){
		this.a = a;
		this.b = b;
	}
	
	public static Tabuada newInstace(){
		return new Tabuada(sorteiaNumero(), sorteiaNumero());
	}

	
	public int getA() {
		return a;
	}
	
	
	public int getB() {
		return b;
	}
	
	public int getResultado(){
		return a*b;
	}
	
	
	private static int sorteiaNumero(){
        int max = 10;
        double random = Math.random();
        int value = (int)(random*max);
        return value;
	}

}
