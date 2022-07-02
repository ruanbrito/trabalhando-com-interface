package com.ruan.modelo.entidades;

import java.util.Date;

public class ParcelaContrato {
	
	private Date dataParcela;
	private Double valorParcela;
	
	public ParcelaContrato() {
	}

	public ParcelaContrato(Date dataParcela, Double valorParcela) {
		this.dataParcela = dataParcela;
		this.valorParcela = valorParcela;
	}

	public Date getDataParcela() {
		return dataParcela;
	}

	public void setDataParcela(Date dataParcela) {
		this.dataParcela = dataParcela;
	}

	public Double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}
	
	

}
