import java.util.*;
public class Exerc4_3 {
	static 	String vetCidades[] = {"Belo Horizonte", "São Paulo", "Rio de Janeiro", "Salvador", "Curitiba"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leia = new Scanner(System.in);
		
		String 	nomes[] = new String[100],
				tipoQuarto,
				cidadeHotel; 
				
		int 	diaEntrada,
				diaSaida,
				hospede;
		
		float valorConta[] = new float[100];
		
		for (hospede = 0; hospede < nomes.length;hospede++){
			
			System.out.println("Digite seu nome (digite fim para sair): ");
			nomes[hospede] = leia.nextLine();
			
			if (nomes[hospede].equalsIgnoreCase("fim")){
				System.out.println("Saindo...\n");
				break;
			}
			
			do {
				System.out.print("Digite o dia do seu check-in: ");
				diaEntrada = leia.nextInt();
				if (diaEntrada < 0 || diaEntrada > 31){
					System.out.println("Dia inválido! Digite novamente.");
				}
			}while(diaEntrada < 0 || diaEntrada > 31);
			
			do {
				System.out.print("Digite o dia do seu check-out: ");
				diaSaida = leia.nextInt();
				if (diaSaida < 0 && diaSaida > 31){
					System.out.println("Dia inválido! Digite novamente.");
				}
			}while(diaSaida < 0 && diaSaida > 31);
			
			do {
				System.out.println("Digite o tipo do seu quarto");
				tipoQuarto = leia.next();
				
				if (tipoQuarto != "Standard" && tipoQuarto != "Luxo" && tipoQuarto != "Super-Luxo"){
					System.out.println("Tipo inválido.Digite novamente");
				}
			}while(tipoQuarto != "Standard" && tipoQuarto != "Luxo" && tipoQuarto != "Super-Luxo");
			
			do {
				System.out.println("Digite a cidade da sua estadia: ");
				cidadeHotel = leia.nextLine();
			}
		}
		
		
		
	}
	
	public static void calcularConta(int diaEntrada, int diaSaida, int valorDiaria){
		
		float conta = (diaSaida - diaEntrada)*valorDiaria;
		System.out.println();
	}
}
