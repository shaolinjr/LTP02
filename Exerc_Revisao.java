import java.util.*;

public class Exerc_Revisao {
	
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		int 	idade [] 		= new int[3],
				numeroFilhos [] = new int[3];
		
		char	sexo [] 		= new char[3];
		float 	salarios []		= new float[3];
		// Pegar esses dados de cada pessoa
		// Criar função que retorne a média dos salários dos habitantes
		// Criar função que retorne a MAIOR e a MENOR idade do grupo;
		// Criar função que retorne a quantidade de mulheres com três filhos que recebem até 500,00
		// Um método para cada cálculo
		
		
		for (int x = 0; x < idade.length;x++){
			
			System.out.print("Digite sua idade: ");
			idade[x] = leia.nextInt();
			
			System.out.print("Digite seu número de filhos: ");
			numeroFilhos[x] = leia.nextInt();
			
			
			System.out.print("Digite seu sexo: [M/F]: ");
			sexo[x] = leia.next().charAt(0);
			
			System.out.print("Digite seu salário: ");
			salarios[x] = leia.nextFloat();
		}
		
		// Até esse ponto ja cadastramos os usuários
		System.out.println("--------------------------------------------");
		System.out.println("Média: "+ getMediaSalarios(salarios));
		System.out.println("Menor idade: "+ getMenorIdade(idade));
		System.out.println("Maior idade: "+ getMaiorIdade(idade));
		System.out.println("Quantidade de mulheres: "+ getQuantidadeMulheres(numeroFilhos, salarios, sexo));
		
		
	}
	
	public static float getMediaSalarios (float salarioArray[]){
		float salarioTotal = 0;
		int x = 0;
		for (x = 0; x < salarioArray.length;x++){
			salarioTotal += salarioArray[x];
		}
		return salarioTotal/x;
	}
	
	public static int getMenorIdade (int idade[]){
		int menorIdade = 999;
		int x = 0;
		
		for (x = 0; x < idade.length;x++){
			if (menorIdade > idade[x]){
				menorIdade = idade[x];
			}
		}
		return menorIdade;
	};
	
	public static int getMaiorIdade (int idade[]){
		int maiorIdade = 0;
		int x = 0;
		
		for (x = 0; x < idade.length;x++){
			if (maiorIdade < idade[x]){
				maiorIdade = idade[x];
			}
		}
		return maiorIdade;
	};
	
	public static int getQuantidadeMulheres(int filhos[], float salario[], char sexo[]){
		int quantidadeMulheres = 0;
		int x = 0;
		for (x = 0; x < filhos.length;x++){
			if (filhos[x] == 3 && salario[x] <= 500 && sexo[x] == 'F'){
				quantidadeMulheres++;
			}
		}
		return quantidadeMulheres;
		
	}
	
}