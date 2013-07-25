package br.com.ste.app.tabuada;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TabuadaTest {

	@Test
	public void testNewInstace() {
		Tabuada.newInstace();
	}

	@Test
	public void testGetA() {
		Tabuada tabuada = Tabuada.newInstace();
		int a = tabuada.getA();
		System.out.println("valor de a > "+a);
		assertTrue(a >= 0 && a <= 10 );
	}

	@Test
	public void testGetB() {
		Tabuada tabuada = Tabuada.newInstace();
		int b = tabuada.getB();
		System.out.println("valor de b > "+b);
		assertTrue(b >= 0 && b <= 10 );
	}

	@Test
	public void testGetResultado() {
		Tabuada tabuada = Tabuada.newInstace();
		int b = tabuada.getB();
		int a = tabuada.getA();
		System.out.println("axb = "+a*b);
		assertEquals(a*b, tabuada.getResultado());
	}
	
//	@Test
//	public void teste() {
//		int max = 0;
//		int min = 10;
//		for(int i = 0; i< 100;i++) {
//			double random = Math.random();
//			
//			System.out.println("random = "+random) ;
//			
//			int value = (int)(random*11);
//			System.out.println(value);
//			if(value > max) {
//				max = value;
//			}
//			if(value < min) {
//				min = value;
//			}
//		}
//		System.out.println("max = "+max);
//		System.out.println("min = "+min);
//	}

}
