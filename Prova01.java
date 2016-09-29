import java.util.*;
public class Prova01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner leia = new Scanner(System.in);
		//Variaveis
		String		descConsumo [] = new String [100];
		
		int			numApto [] = new int [100],
					aptoPesq,
					c;
		
		float		precoConsumo [] = new float [100];
		
		//Entrada de dados
		for(c = 0 ; c < 100 ; c++){
			do{
				System.out.print("\n\tDigite o número do apartamento[0 para encerrar]: ");
				numApto[c] = leia.nextInt();
					if(numApto[c] == 0){
						break;
					} else if (numApto[c] < 101 || numApto[c] > 150){
						System.out.print("\n\tApartamento inválido.");
					}
			}while(numApto[c] < 101 || numApto[c] > 150);
			
			if(numApto[c] == 0){
				break;
			}
			
			System.out.print("\n\tDigite a descrição do consumo: ");
			descConsumo[c] = leia.next();
			
			do{
				System.out.print("\n\tDigite o valor do consumo: ");
				precoConsumo[c] = leia.nextFloat();
					if(precoConsumo[c] <= 0){
						System.out.print("\n\tValor inválido.");
					}
			}while(precoConsumo[c] <= 0);
		}//Fim for
			do{
				System.out.print("\n\tDigite o apartamento para fechar[0 para encerrar]:");
				aptoPesq = leia.nextInt();
				if(aptoPesq == 0){
					break;
				}
				System.out.println("*********** Relatório ***********");
				System.out.println("Número apto: "+aptoPesq);
				fecharConta(numApto, aptoPesq, precoConsumo, descConsumo);
				System.out.println("*********************************");
			}while(aptoPesq != 0);
			
			leia.close();
	}
	
	public static void fecharConta (int apto[], int pesqApto, float consumo[], String consumoDesc[]){
		boolean		encontrou = false;
		float		contaTotal = 0;
		
		for (int x = 0; x < 100;x++){
			if (pesqApto == apto[x]){
				encontrou = true;
				
				System.out.print(consumoDesc[x]);
				System.out.println("\t"+consumo[x]);
				contaTotal += consumo[x];
			}
		}
		if (encontrou){
			System.out.println("Conta total: "+ contaTotal);
		}else {
			System.out.println("Não existem despesas para esse apartamento.");
		}
	}
}
