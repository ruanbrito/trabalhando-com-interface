package br.com.modelo.entidades;

import java.util.Date;

public class AlugarCarro {
	
	private Date inicioAluguel;
	private Date fimAluguel;
	
	private Veiculo veiculo;
	private Fatura fatura;
	
	public AlugarCarro() {
	}

	public AlugarCarro(Date inicioAluguel, Date fimAluguel, Veiculo veiculo) {
		this.inicioAluguel = inicioAluguel;
		this.fimAluguel = fimAluguel;
		this.veiculo = veiculo;
	}

	public Date getInicioAluguel() {
		return inicioAluguel;
	}

	public void setInicioAluguel(Date inicioAluguel) {
		this.inicioAluguel = inicioAluguel;
	}

	public Date getFimAluguel() {
		return fimAluguel;
	}

	public void setFimAluguel(Date fimAluguel) {
		this.fimAluguel = fimAluguel;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}
		

}
