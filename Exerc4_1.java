import java.util.*;

import org.omg.Messaging.SyncScopeHelper;
public class Exerc4_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner leia = new Scanner(System.in);
		
		int numA, numB, numC;
		
		System.out.print("Digite o valor de A: ");
		numA = leia.nextInt();
		
		System.out.print("Digite o valor de B: ");
		numB = leia.nextInt();
		
		System.out.print("Digite o valor de C: ");
		numC = leia.nextInt();
		
		
		
		System.out.println("A soma dos inteiros A e B é: " + somaInteiros(numA, numB));
		divisaoInteiros(numA, numB, numC);
		System.out.println("O % de C em A é: " + valorPercentual(numA, numC)+"%");

	}
	
	public static int somaInteiros(int numA, int numB){
		
		int soma = 0;
		
		for (int x = numA+1; x <= numB - 1; x++){
			soma = soma + x;
		}
		
		return soma;
	}
	
	public static void divisaoInteiros(int numA, int numB, int numC){
	
		for (int x = numA+1; x <= numB - 1; x++){
			
			if(x % numC == 0){
				System.out.println("Numero divisivel: " + x);
			}
		}
	}
	
	
	public static float valorPercentual(int numA, int numC){
		return numC*100/numA;
		
	}

}
