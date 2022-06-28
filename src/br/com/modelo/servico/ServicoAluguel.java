package br.com.modelo.servico;

import br.com.modelo.entidades.AlugarCarro;
import br.com.modelo.entidades.Fatura;

public class ServicoAluguel {
	
	private Double precoHora;
	private Double precoDia;
	
	private TaxaServico taxaServico;

	public ServicoAluguel() {
	}

	public ServicoAluguel(Double precoHora, Double precoDia, TaxaServico taxaServico) {
		this.precoHora = precoHora;
		this.precoDia = precoDia;
		this.taxaServico = taxaServico;
	}
	
	public void processarFatura(AlugarCarro alugarCarro){
		long inicioAluguel = alugarCarro.getInicioAluguel().getTime();
		long fimAluguel = alugarCarro.getFimAluguel().getTime();
		double hora = (double) (fimAluguel - inicioAluguel) / 1000 / 60 / 60;
		
		double basePagamento;
		if(hora <= 12.0) {
			basePagamento = Math.ceil(hora) * precoHora;			
		} else {
			basePagamento = Math.ceil(hora / 24 ) * precoDia;
		}
		
		double taxa = taxaServico.taxa(basePagamento);
		alugarCarro.setFatura(new Fatura(basePagamento, taxa));
	}

		

}
