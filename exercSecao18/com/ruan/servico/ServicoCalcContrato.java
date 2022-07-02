package com.ruan.servico;

import java.util.Calendar;
import java.util.Date;

import com.ruan.modelo.entidades.Contrato;
import com.ruan.modelo.entidades.ParcelaContrato;

public class ServicoCalcContrato {
	
	private ServicoOnlinePagamento servicoOnlinePagamento;
	
	public ServicoCalcContrato() {}

	public ServicoCalcContrato(ServicoOnlinePagamento servicoTaxa) {
		this.servicoOnlinePagamento = servicoTaxa;
	}
	
	public void processarParcela(Contrato contrato, int numeroParcelas) {
		double parcela = contrato.getValorTotal() / numeroParcelas;
		int cont = 1;
		while(cont <= numeroParcelas) {
			double valor = servicoOnlinePagamento.taxa(parcela, cont);
			Date date = calendario(contrato, cont);
			contrato.getParcelaContrato().add(new ParcelaContrato(date , valor));
			cont++;
		}
	}
	
	private static Date calendario(Contrato contrato, int cont) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(contrato.getDataContrato());
		cal.add(Calendar.MONTH, cont);
	    return cal.getTime();
	    
	}
	

}
