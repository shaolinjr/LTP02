import java.util.*;
public class Exerc6_2 {

	public static void main(String[] args) {
		Scanner leia = new Scanner (System.in);     
		
		String 	nome,
				senha;
		
		// Até 30 nomes
		for (int i = 0; i < 30; i++){
			
			System.out.println("Digite seu nome completo: ");
			nome = leia.nextLine();
			gerarConta(nome);
		}

	}
	public static boolean validaNome (String nome){
		
		return true;
	}
	public static void gerarConta (String nome){
		// pegar as iniciais
		String nomeString = nome.substring(0,1).toUpperCase();
		String senhaString = String.valueOf((int) nomeString.charAt(0)).substring(0,1);
		
		int cont = 1;
		
		for (int x = 0; x < nome.length(); x++){
			if (nome.charAt(x) == ' '){
				nomeString += nome.substring(x+1,x+2).toUpperCase();
				senhaString += String.valueOf((int) nomeString.charAt(cont)).charAt(0);
				cont++;
			}
		}
		
		
		System.out.println("Login: "+ nomeString);
		System.out.println("Senha: "+senhaString);
	}
}
