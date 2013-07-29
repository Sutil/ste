package br.com.ste.app;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class PercentualTest {

	@Test
	public void testFormatScreen() {
		Percentual p = Percentual.newInstance(new BigDecimal("50.50"));
		assertEquals("50,5%" ,p.formatScreen());
		
		Percentual p2 = Percentual.newInstance(new BigDecimal("50.60"));
		assertEquals("50,6%" ,p2.formatScreen());
	}
	
	
	@Test
	public void testPercentual() {
		Percentual p = Percentual.newInstance(200, 50);
		assertEquals("25,0%" ,p.formatScreen());
		
	}
	
	@Test
	public void testPercentualDois() {
		Percentual p = Percentual.newInstance(66, 5);
		assertEquals("8,0%" ,p.formatScreen());
		
	}

}
