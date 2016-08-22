import java.util.*;
public class Exerc3_1 {

	public static void main(String[] args) {
		
		Scanner leia 				= new Scanner(System.in);
		
		String 	cidadesNomes[] 		= new String[20], 
				nomePesquisa 		= "";
		
		
		float 	cidadesDistancia[] 	= new float[20],
				precoPassagem		= 0;
		
		int 	cidade,
				sairConsulta 		= 0,
				numeroEscalas		= 0,
				pesquisa			= 0;
		
		double tempoVoo				= 0.0;
		
		boolean encontrouCidade = false;
		
		System.out.println("---------- Cadastro de cidades ----------\n");
		
		for (cidade = 0; cidade < cidadesNomes.length; cidade++){
			
			// Receber nome da cidade para cadastro			
			do {
				System.out.print("Digite o nome da cidade a ser cadastrada (digite 'FIM' para sair): ");
				cidadesNomes[cidade] = leia.nextLine();
				
				if (cidadesNomes[cidade].equals("")){
					System.out.println("Nome inválido, digite novamente!");
				}
				
			}while(cidadesNomes[cidade].equals(""));
			
			// Flag para saída no nome da cidade
			if(cidadesNomes[cidade].equalsIgnoreCase("FIM")){
				System.out.println("Saindo...");
				break;
			}
			
			// Receber distância entre Cidade e BH
			do {
				System.out.print("Qual a distância entre "+ cidadesNomes[cidade]+ " e Belo Horizonte? (digite '0' para sair): ");
				cidadesDistancia[cidade] = leia.nextFloat();
				
				if (cidadesDistancia[cidade] < 500){
					System.out.println("Distância inválida. Digite novamente!");
				}
				
			}while(cidadesDistancia[cidade] < 500);
			
			// Flag para saída no nome da cidade [arrumar]
			if(cidadesDistancia[cidade] == 0){
				System.out.println("Saindo...");
				break;
			}
			
			leia.nextLine();
		}
		
		// Modulo de pesquisa
		System.out.println("\n---------- Pesquisa de cidades ----------");
		System.out.println("Para sair, digite 0");
		 
		do {
			
			do {
				System.out.print("\nDigite o nome de uma cidade para pesquisar: ");
				nomePesquisa  = leia.nextLine();
				
				
				if (nomePesquisa.equalsIgnoreCase("")){
					System.out.println("Valor inválido. Digite novamente!");
					break; // ver se n vai dar problema
				}else if (nomePesquisa.equals("0")){
					System.out.println("Saindo...");
				}else{
					// pesquisar no array de nomes
					for (pesquisa = 0; pesquisa < cidadesNomes.length; pesquisa++){
						
						if (nomePesquisa.equalsIgnoreCase(cidadesNomes[pesquisa])){
							encontrouCidade = true;
							precoPassagem 	= (float) 0.25 * cidadesDistancia[pesquisa];
							tempoVoo 		= (cidadesDistancia[pesquisa] / 800)* 60;
							numeroEscalas 	= (int) ((tempoVoo/ 60) / 3);
							break;
							
						}else{
							encontrouCidade = false;
						}
						
					}
				}
				
				if (encontrouCidade == false){
					System.out.println("Cidade não encontrada na lista de cidades cadastradas.Digite novamente.");
				}else{
					System.out.println("\nInformações sobre a viagem para "+nomePesquisa+": \n");
					System.out.println("Preço da passagem: R$ "+ precoPassagem);
					System.out.println("Tempo de voo: "+ tempoVoo+ " minutos");
					System.out.println("Numero de escalas: "+ numeroEscalas+ " escala(s)");
					
				}
				
//				leia.nextLine();
			}while(nomePesquisa.equalsIgnoreCase("") || encontrouCidade == false);
			
		}while(nomePesquisa != "0");
		
		
		leia.nextLine();
		leia.close();
		
	}

}


/*
Fazer um programa em Java para consultar informações sobre os vôos de uma empresa aérea. 
Primeiramente o programa deverá receber via teclado os Nomes e respectivas Distâncias (em km, até Belo Horizonte) 
de até 20 Cidades no mundo e armazenar em dois vetores. Em seguida, o programa deverá entrar no módulo de consultas 
e solicitar o Nome de uma Cidade. 

Para cada cidade digitada o programa deverá calcular e exibir os seguintes resultados:
 
	- Preço da Passagem
	- Tempo de Vôo em minutos
	- Número de escalas no percurso
	
Considerações para os cálculos:

	- A empresa aérea cobra R$0,25 por km percorrido no vôo 
	- O avião voa com uma velocidade de 800 km/h
	- A empresa aérea faz uma escala a cada 3 horas de vôo.
	
Observações:

	- Adotar um flag para finalizar a entrada de dados com os Nomes de Cidades e Distâncias
	- Adotar um flag para finalizar as consultas
	
	- Exibir mensagem de erro se o Nome da Cidade digitada na consulta não existir na lista de cidades digitadas inicialmente (Max. 20)
	- Durante a digitação dos Nomes das Cidades e Distâncias, consistir:
	- O Nome da Cidade deverá ser de preenchimento obrigatório - A distância até Belo Horizonte deverá ser no mínimo 500 km.
*/	