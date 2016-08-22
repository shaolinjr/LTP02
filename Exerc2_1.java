import java.util.*;
public class Exerc2_1 {
	
	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		// Variáveis
		double 	altura,
				maiorAltura 	= 0,
				menorAltura 	= 10,
				alturasMasc		= 0,
				mediaGeral,
				somaAlturas 	= 0;
		
		char 	sexo,
				novaEntrada		= 'S';
		
		int		sexoFeminino 	= 0,
				contador 		= 0,
				contadorMasc	= 0;
		
		// Entrada de dados
		while (novaEntrada == 'S'){
			
			//validação do do..while
			do {
				System.out.print("Digite sua altura: ");
				altura = leia.nextDouble();
				
				if (altura < 0 || altura > 2.5){
					System.out.println("Valor inválido. Digite novamente.");
				}
				
			}while(altura < 0 || altura > 2.5);
			
			// somando alturas
			somaAlturas += altura;

			System.out.print("Qual é o seu sexo? [F/M]: ");
			sexo = leia.next().charAt(0);
			
			// validação com while			
			while(sexo != 'F' && sexo != 'M'){
				System.out.print("Valor inválido. Digite novamente. [F/M]: ");
				sexo = leia.next().charAt(0);
			}
			
			// pegar maior altura
			if (altura > maiorAltura){
				maiorAltura = altura;
			}
			
			//pegar menor altura
			if (altura < menorAltura) {
				menorAltura = altura;
			}
			
			// pegar pessoas do sexo feminino
			if (sexo == 'F'){
				sexoFeminino++;
			}else {
			// somar para pegar todas alturas masculinas
				alturasMasc += altura;
				contadorMasc++;
			}
			
			contador++;
			
			// Flag para finalizar o programa...
			do {
				System.out.print("Você deseja digitar uma nova entrada de dados? [S/N]: ");
				novaEntrada = leia.next().charAt(0);
				
				if (novaEntrada != 'S' && novaEntrada != 'N'){
					System.out.println("Valor inválido. Digite novamente.");
				}else if (novaEntrada == 'S'){
					break;
				}else {
					System.out.println("Saindo...");
				}
			
			}while(novaEntrada != 'S' && novaEntrada != 'N');
		}
		
		//Mostrar dados finais
		
		System.out.println("Maior altura: "+ maiorAltura);
		System.out.println("Menor altura: "+ menorAltura);
		System.out.println("Atletas do sexo feminino: "+ sexoFeminino);
		System.out.println("Média altura masculina: "+ (double) alturasMasc / contadorMasc);
		System.out.println("Média geral das alturas: "+ (double) somaAlturas / contador);
		
		
		leia.close();
	}
}
