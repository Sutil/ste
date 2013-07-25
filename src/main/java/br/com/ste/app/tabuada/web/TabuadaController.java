package br.com.ste.app.tabuada.web;

import org.springframework.stereotype.Controller;

@Controller
public class TabuadaController {
	
	
	public TabuadaBean getTabuadaBean(){
		return TabuadaBean.newInstance();
	}

}
