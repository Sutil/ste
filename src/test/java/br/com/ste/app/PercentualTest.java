package br.com.ste.app;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class PercentualTest {

	@Test
	public void testFormatScreen() {
		Percentual p = Percentual.newInstance(new BigDecimal("50.50"));
		assertEquals("50%" ,p.formatScreen());
		
		Percentual p2 = Percentual.newInstance(new BigDecimal("50.60"));
		assertEquals("51%" ,p2.formatScreen());
	}

}
