package com.ruan.servico;

public class ServicoTaxa implements ServicoOnlinePagamento {
	
	public double taxa(double valorParcela, int parcela) {
			double taxa_1 = 0.01;
			double taxa_2 = 0.02;
			double valor = (valorParcela * taxa_1 * parcela) + valorParcela;
			valor = (valor * taxa_2) + valor;
			return valor;
		
	}
}
