import java.util.*;

public class Exerc5_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leia = new Scanner(System.in);
		String placaVeiculo, dataMulta;
		int valorMulta, somaMultas = 0, menorMulta = 9999999, contador = 0, i;
		float mediaMultas;
		String anoAtual;
		boolean dataValida = false, placaValida = false;
		
		do {
			
			// Recebendo ano atual e settando flag
			
			// toda vez que vamos colocar uma nova multa ele pede o ano, 
			// deveriamos fazer com que o ano atual seja digitado uma vez só
			// o que acha?
			// Primeiro vamos conseguir a validação da placa, depois preocupamos com UX
			System.out.print("Digite '0' ao invés de digitar o ano para sair.\nSerá que poderia me dizer em que ano estamos?: ");
			anoAtual = leia.next();
			
			if (anoAtual.equals("0")){
				System.out.println("Tudo bem. Até mais.");
				break;
			}
			
			while(anoAtual.length() != 4){
				System.out.print("Valor para ano inválido, formato: [YYYY]. Tente novamente: ");
				anoAtual = leia.next();
			}
			
			
			do {
				System.out.print("Olá, digite a placa do veículo: ");
				placaVeiculo = leia.next();
				// consistência da placa
				// 3 LETRAS + 4 NUMEROS
				// Para letras ver se está entre 65 e 90 ASCII
				// Para números, tentar converter em digito
				for (i = 0; i < placaVeiculo.length(); i++){
					
					if (i <= 2){ // testando letras
						if (placaVeiculo.charAt(i) >= 65 && placaVeiculo.charAt(i) <= 90){
							// é uma letra
							placaValida = true;
							
						}else {
							placaValida = false;
							break;
						}
					}else {
						// testar se podem ser transformados em dígitos
						if (Character.digit(placaVeiculo.charAt(i),10) != -1){
							placaValida = true;
						}else {
							placaValida = false;
							break;
						}
					}
				}
				if (!placaValida){
					System.out.println("Placa inválida, digite novamente!");
				}
			}while(!placaValida);
			
			
			// Recebendo data da multa e validando
			do {
				System.out.print("Digite a data da multa [DD/MM/YYYY]: ");
				dataMulta = leia.next();
				dataValida = dataEhValida(dataMulta, anoAtual);
				if (!dataValida){
					System.out.println("Data inválida!");
				}
			}while(!dataValida);
			
			
			
			// Recebendo valor da multa e validando
			do {
				System.out.print("Digite o valor da multa: ");
				valorMulta = leia.nextInt();
				
				if (valorMulta <= 0){
					System.out.println("Valor inválido!");
				}
			}while (valorMulta <= 0);
			
			
			// preparando variáveis para resultado final
			// pegando menorMulta
			if (valorMulta < menorMulta){
				menorMulta = valorMulta;
			}
			// somando multas
			somaMultas += valorMulta;
			// criando nosso contador para fazer a média de valores de multas
			contador++;
			
		}while(true);
		
		// Resultados Finais:
		System.out.println("\nSoma das multas R$"+somaMultas);
		System.out.println("Valor da menor multa R$"+menorMulta);
		mediaMultas = (float) somaMultas / contador;
		System.out.println("Média das multas R$"+ mediaMultas);
		
	}
	
	public static boolean dataEhValida (String data, String anoAtual){
		//	data.length == 10
		//  data["2"] == "/" && data["5"] == /
		// 01,03,05,07,08,10,12 min day = 1 max day = 31
		// 02,04,06,09,11 min day = 1 max day = 30
		int dia = Integer.parseInt(data.substring(0,2));
		
		int mes = Integer.parseInt(data.substring(3,5));
		int ano = Integer.parseInt(data.substring(6,10));
		int anoAt = Integer.parseInt(anoAtual);
		
		if (data.length() == 10 && data.charAt(2) == '/' && data.charAt(5) == '/' && ano <= anoAt){	
			
			switch (mes){
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					
					if(dia >= 1 && dia <= 31){
						return true;
					}else {
						return false;
					}
					
				case 2:
					// fazer exclusivos do 02
					if ((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0){
						if(dia >= 1 && dia <= 29){
							return true;
						}else {
							return false;
						}
					}else {
						if(dia >= 1 && dia <= 28){
							return true;
						}else {
							return false;
						}
					}
					
				case 4:
				case 6:
				case 9:
				case 11:
					
					if(dia >= 1 && dia <= 30){
						return true;
					}else {
						return false;
					}
				default:
					return false;
			}
		}else {
			return false;
		}
		
		
	}
}
/*
 * O DETRAN deseja fazer o controle das multas de veículos. 
 * Faça um programa em Java que receba via teclado a PLACA DO VEÍCULO, a DATA DA MULTA (DD/MM/AAAA) e o VALOR DA MULTA.O programa deverá consistir a entrada de dados da seguinte forma:

	[ ] - A placa deverá ser uma String de 7 caracteres e ser formada por três letras e quatro dígitos. Ex: GVP5566
	[√] - O valor da multa deverá ser maior que zero.
	[√] - Fazer um método de nome dataEhValida para consistir a data da multa:
		- o método deverá receber como parâmetro uma data no formato DD/MM/AAAA - a consistência deverá seguir as seguintes regras:
			[√] - a String deverá ter 10 caracteres de tamanho. 
			[√] - o 3o. E o 6o. Caracteres deverão ser uma barra ('/'). USE compareTo == 47
			[√] - para os meses de Janeiro, Março, Maio, Julho, Agosto, Outubro e Dezembro o dia deverá ser entre 1 e 31.
			[√] - para os meses Abril, Junho, Setembro e Novembro o dia deverá ser entre 1 e 30.
			[√] - para o mês de Fevereiro:
			[√]	- anos divisíveis por 4 e não divisível por 100 ou anos divisíveis por 400 o dia deverá ser entre 1 e 29 ((ano bissexto);
			[√]	- para os demais anos o dia deverá ser entre 1 e 28;
			[√] - os mês deverá ser entre 1 e 12
			[√] - o ano deverá ser menor ou igual ao ano atual.
	[√] - o método deverá retornar um valor do tipo Boolean. 
	[√] Caso a data recebida como parâmetro esteja de acordo com as regras acima a função retornará o valor TRUE, caso contrário, retornará o valor FALSE.
	
	Como resultado final o programa deverá imprimir: 
	[√] - A soma dos valores das multas.
	[√] - O valor médio das multas.
	[√] - O valor da menor multa.
	Obs:
	[√]	- Definir um Flag para encerrar o programa.
 */