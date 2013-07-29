package br.com.ste.app.tabuada.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import br.com.ste.app.tabuada.Estatistica;
import br.com.ste.app.tabuada.repository.EstatisticaRepository;

@Controller
public class TabuadaController {
	
	@Autowired
	EstatisticaRepository estatisticaRepository;
	
	
	
	public TabuadaBean getTabuadaBean(){
		return TabuadaBean.newInstance();
	}
	
	@Transactional
	public EstatisticaBean getEstatistica() {
		List<Estatistica> lista = estatisticaRepository.findAll();
		if(!lista.isEmpty()) {
			System.out.println("JA EXISTE ESTATISTICA");
			Estatistica estatistica = lista.get(0);
			EstatisticaBean bean = EstatisticaBean.instance(estatistica);
			bean.addAcesso();
			System.out.println(bean.toString());
			estatistica = Estatistica.newInstance(bean);
			estatisticaRepository.save(estatistica);
			return bean;
		}
		System.out.println("AINDA NÃO EXISTE");
		EstatisticaBean bean = EstatisticaBean.instance();
		bean.addAcesso();
		System.out.println(bean.toString());
		Estatistica estatistica = Estatistica.newInstance(bean);
		estatisticaRepository.save(estatistica);
		return bean;
	}
	
	public void atualizarEstatistica(EstatisticaBean e) {
		Estatistica estatistica = Estatistica.newInstance(e);
		estatisticaRepository.save(estatistica);
	}
	
	public void atualizar(TabuadaBean bean) {
		EstatisticaBean.instance().atualizar(bean);
	}
	
	public TabuadaBean parar() {
		return TabuadaBean.newInstance("");
	}

}
