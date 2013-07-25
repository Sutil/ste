package br.com.ste.app;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Percentual implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private BigDecimal valor;
	
	private static Percentual ZERO_POR_CENTO = new Percentual(new BigDecimal("0.00"));
	
	private Percentual(BigDecimal valor) {
		this.valor = valor;
	}
	
	public static Percentual newInstance(BigDecimal valor) {
		checkNotNull(valor);
		if(valor.setScale(2, RoundingMode.HALF_EVEN).equals(new BigDecimal("0.00"))) {
			return ZERO_POR_CENTO;
		}
		return new Percentual(valor);
	}
	
	public boolean isZero() {
		return this == ZERO_POR_CENTO;
	}
	
	public String formatScreen(){
		DecimalFormat format = new DecimalFormat("#,##0");
		return format.format(valor)+"%";
	}

}
