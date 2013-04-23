package br.com.ste.app.tabuada;

public class Tabuada {
	
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
		int min = 0;
        int max = 10;
        return new Integer((int)Math.random() * (max - min) + min);
	}

}
