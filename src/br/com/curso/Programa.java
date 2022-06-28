package br.com.curso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import br.com.modelo.entidades.AlugarCarro;
import br.com.modelo.entidades.Veiculo;
import br.com.modelo.servico.ServicoAluguel;
import br.com.modelo.servico.TaxaServicoBrasil;
import br.com.modelo.servico.TaxaServicoEUA;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("DATA DO ALUGUEL");
		System.out.print("MODELO DO CARRO: ");
		String modelo = scan.nextLine();
		System.out.print("SAIDA (dd/MM/yyy HH:ss): ");
		Date inicioAluguel = sdf.parse(scan.nextLine());
		System.out.print("RETORNO (dd/MM/yyy HH:ss): ");
		Date fimAluguel = sdf.parse(scan.nextLine());
		
		AlugarCarro alugarCarro = new AlugarCarro(inicioAluguel, fimAluguel, new Veiculo(modelo));
				
		System.out.print("PREÇO POR HORA: ");
		double precoHora = scan.nextDouble();
		System.out.print("PREÇO POR DIA: ");
		double precoDia = scan.nextDouble();
		
		ServicoAluguel servicoAluguel = new ServicoAluguel(precoHora, precoDia, new TaxaServicoBrasil());
		
		servicoAluguel.processarFatura(alugarCarro);
		
		System.out.println("FATURA");
		System.out.println("PAGAMENTO BASE: " + String.format("%.2f", alugarCarro.getFatura().getPagamentoBase()));
		System.out.println("TAXA: " + String.format("%.2f", alugarCarro.getFatura().getTaxa()));
		System.out.println("TOTAL A PAGAR: " + String.format("%.2f", alugarCarro.getFatura().getPagamento()));
		
		scan.close();
	}

}
