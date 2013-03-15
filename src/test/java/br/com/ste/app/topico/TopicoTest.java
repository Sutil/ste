package br.com.ste.app.topico;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;


public class TopicoTest {

	
	@Test
	public void testNewInstance() {
		Topico t = Topico.newInstance("teste");
		assertNotNull(t);
		assertEquals("teste", t.getTitle());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTitleVazio(){
		Topico.newInstance("");
	}

	@Test
	public void testEqualsObject() {
		Topico t = Topico.newInstance("teste");
		assertNotNull(t);
		assertEquals("teste", t.getTitle());
		
		
	}

}
