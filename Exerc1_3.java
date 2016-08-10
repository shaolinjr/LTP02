
import java.util.*;
public class Exerc1_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner leia = new Scanner (System.in);
		int 	tempoCasa, 
				salarioInicial;
		double 	salarioFinal, 
				valeTransporte,
				bonus;
		
		char respostaUsuario = 'S';
		System.out.println("Bom dia, bem vindo ao exercício 1.3");
		while (respostaUsuario == 'S'){
			
			do {
				System.out.print("Quanto tempo o sr(a) possui na empresa?: ");
				tempoCasa = leia.nextInt();
				
				if (tempoCasa < 0){
					System.out.println("Valor inválido!");
				}
			}while(tempoCasa < 0);
			
			do {
				System.out.print("Quanto o sr(a) recebe na empresa?: ");
				salarioInicial = leia.nextInt();
				
				if (salarioInicial < 0){
					System.out.println("Valor inválido!");
				}
			}while(salarioInicial < 0);
			
			
			if (tempoCasa <= 5){
				if (salarioInicial <= 300){
					bonus = 50.0;
					valeTransporte = (double) salarioInicial * 0.05;
				}else{
					bonus = 80.0;
					valeTransporte = (double) salarioInicial * 0.06;
				}
			}else if (tempoCasa <= 10){
				if (salarioInicial <=500){
					bonus = (double) salarioInicial * 0.15;
					valeTransporte = 70;
				}else if (salarioInicial <=2000){
					bonus = (double) salarioInicial * 0.13;
					valeTransporte = 90;
				}else {
					bonus = (double) salarioInicial * 0.12;
					valeTransporte = (double) salarioInicial * 0.08;
				}
			}else {
				bonus = 300;
				valeTransporte = (double) salarioInicial * 0.04;
			}
			
			System.out.println("Seu bônus salarial é: "+ bonus);
			System.out.println("Seu desconto de VT é: "+ valeTransporte);
			
			do {
				System.out.print("Deseja efetuar uma nova entrada de dados? [S/N]: ");
				respostaUsuario = leia.next().charAt(0);
				
				if(respostaUsuario != 'S' && respostaUsuario != 'N'){
					System.out.println("Valor inválido");
				}
				if (respostaUsuario == 'N'){
					System.out.println("Deixando o programa. Até mais!");
					break;
				}
			}while(respostaUsuario != 'S' && respostaUsuario != 'N');
		}
	
	}

}
