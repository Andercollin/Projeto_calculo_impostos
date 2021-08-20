package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuintes;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Contribuintes> list = new ArrayList<>();
		Double soma = 0.0;
		
		System.out.print("Digite o número de contribuintes: ");		
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println();
			System.out.println("Dados do contribuinte #" + i);
			System.out.print("Pessoa física ou jurídica? f/j: ");
			char ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Renda Anual: ");
			Double rendaAnual = sc.nextDouble();
			if(ch == 'f') {
				System.out.print("Gastos com saúde: ");
				Double gastosSaude = sc.nextDouble();
				Contribuintes cont = new PessoaFisica(name, rendaAnual, gastosSaude);
				list.add(cont);
			}
			else {
				System.out.print("Número de funcionários: ");
				int numeroFuncionarios = sc.nextInt();
				Contribuintes cont = new PessoaJuridica(name, rendaAnual, numeroFuncionarios);
				list.add(cont);
			}
		}
		System.out.println();
		System.out.println();
		System.out.println("Taxas pagas");
		for(Contribuintes cont: list) {
			soma += cont.impostos();
			System.out.println(cont.getName() + ": $ " + String.format("%.2f", cont.impostos())); 
		}
		System.out.println();
		System.out.println();
		System.out.print("Contribuição total: $" + String.format("%.2f", soma));
		
		sc.close();
	}

}
