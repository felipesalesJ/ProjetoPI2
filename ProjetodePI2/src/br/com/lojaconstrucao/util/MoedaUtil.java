package br.com.lojaconstrucao.util;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class MoedaUtil {

	private MoedaUtil() {
	}
	
	public static String formatarMoeda(Double  valor) {
		BigDecimal bd = new BigDecimal(valor);
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		return nf.format(bd);
	}
	
}
