package com.ruan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import com.ruan.modelo.entidades.Contrato;
import com.ruan.modelo.entidades.ParcelaContrato;
import com.ruan.servico.ServicoCalcContrato;
import com.ruan.servico.ServicoTaxa;

public class Principal {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("ENTER CONTRACT DATA");
		System.out.print("NUMBER: ");
		int numero = scan.nextInt();
		scan.nextLine();
		System.out.print("DATE (dd/MM/yyyy): ");
		Date date = sdf.parse(scan.nextLine());
		System.out.println("CONTRACT VALUE: ");
		double valor = scan.nextDouble();
		
		Contrato cont = new Contrato(numero, date, valor);
		System.out.print("ENTER NUMBER OF INSTALLMENTS: ");
		int parc = scan.nextInt();
		
		ServicoCalcContrato sc = new ServicoCalcContrato(new ServicoTaxa());
		sc.processarParcela(cont, parc);
		System.out.println("INSTALLMENTS:");
		//ParcelaContrato p = new ParcelaContrato();
		for( ParcelaContrato p : cont.getParcelaContrato()) {
			
			System.out.println(sdf.format(p.getDataParcela()) + "    "+ p.getValorParcela());			
		}
		
		scan.close();
		
	}

}
