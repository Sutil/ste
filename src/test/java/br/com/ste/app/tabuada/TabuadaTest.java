package br.com.ste.app.tabuada;

import static org.junit.Assert.*;

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
		assertTrue(a >= 0 && a <= 10 );
	}

	@Test
	public void testGetB() {
		Tabuada tabuada = Tabuada.newInstace();
		int b = tabuada.getB();
		assertTrue(b >= 0 && b <= 10 );
	}

	@Test
	public void testGetResultado() {
		Tabuada tabuada = Tabuada.newInstace();
		int b = tabuada.getB();
		int a = tabuada.getA();
		assertEquals(a*b, tabuada.getResultado());
	}

}
