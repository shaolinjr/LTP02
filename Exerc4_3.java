import java.util.*;
public class Exerc4_3 {
	public static 	String vetCidades[] = {"Belo Horizonte", "São Paulo", "Rio de Janeiro", "Salvador", "Curitiba"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leia = new Scanner(System.in);
		
		String 	nomes[] = new String[100],
				tipoQuarto,
				cidadeHotel; 
				
		int 	diaEntrada,
				diaSaida,
				hospede,
				valorDiaria = 0,
				somaValores = 0;
		
		float 	media;
		
//		boolean cidadeEncontrada = false;
		float valorConta[] = new float[100];
		
		for (hospede = 0; hospede < nomes.length;hospede++){
			
			System.out.print("Digite seu nome (digite fim para sair): ");
			nomes[hospede] = leia.nextLine();
			
			if (nomes[hospede].equalsIgnoreCase("fim")){
				System.out.println("Saindo...\n");
				break;
			}
			
			do {
				System.out.print("Digite o dia do seu check-in: ");
				diaEntrada = leia.nextInt();
				if (diaEntrada < 0 || diaEntrada > 31){
					System.out.println("Dia inv�lido! Digite novamente.");
				}
			}while(diaEntrada < 0 || diaEntrada > 31);
			
			do {
				System.out.print("Digite o dia do seu check-out: ");
				diaSaida = leia.nextInt();
				if (diaSaida < 0 || diaSaida > 31 || diaSaida < diaEntrada){
					System.out.println("Dia inv�lido! Digite novamente.");
				}
			}while(diaSaida < 0 || diaSaida > 31 ||  diaSaida < diaEntrada);
			
			do {
				System.out.print("Digite o tipo do seu quarto: ");
				tipoQuarto = leia.next().toLowerCase();
				
				if (!tipoQuarto.equalsIgnoreCase("Standard") && !tipoQuarto.equalsIgnoreCase("Luxo") && !tipoQuarto.equalsIgnoreCase("Super-Luxo")){
					System.out.println("Tipo inv�lido.Digite novamente");
				}
			}while(!tipoQuarto.equalsIgnoreCase("Standard") && !tipoQuarto.equalsIgnoreCase("Luxo") && !tipoQuarto.equalsIgnoreCase("Super-Luxo"));
			leia.nextLine();
			
			switch (tipoQuarto){
			case "standard": 
				valorDiaria = 120;
				break;
			case "luxo":
				valorDiaria = 150;
				break;
			case "super-luxo":
				valorDiaria = 180;
				break;
			default:
				System.out.println("Erro!");
			}
			
			valorConta[hospede] = calcularConta(diaEntrada, diaSaida, valorDiaria);
			somaValores+= valorConta[hospede];
			
			do {
				System.out.print("Digite a cidade da sua estadia: ");
				cidadeHotel = leia.nextLine();
				cidadeEhValida(cidadeHotel);
				
				if (cidadeEhValida(cidadeHotel) == false){
					System.out.println("Cidade não encontrada. Tente novamente.");
				}
			}while(cidadeEhValida(cidadeHotel) == false);
		}
//		if (hospede == 0){
//			media = (float) somaValores/1;
//		}else {
			media = (float) somaValores/hospede;
//		}
		
		System.out.println("Hóspede\t\tValor");
		System.out.println("---------\t---------");
		for (int x = 0; x <= hospede;x++){
			
			if (valorConta[x] >= media){
				System.out.print(nomes[x]+"\t\t");
				System.out.print(valorConta[x]+"\n");
			}
		}
		
		
	}
	
	public static float calcularConta(int diaEntrada, int diaSaida, int valorDiaria){
		
		float conta = (diaSaida - diaEntrada)*valorDiaria;
		return conta;
	}
	
	public static boolean cidadeEhValida (String cidadeHotel){
		boolean cidadeEncontrada = false;
		for (int x = 0; x < vetCidades.length;x++){
			if (cidadeHotel.equalsIgnoreCase(vetCidades[x])){
				cidadeEncontrada = true;
			}
		}
		return cidadeEncontrada;
	}
}
