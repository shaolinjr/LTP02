import java.util.*;
public class Exerc6_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nome;
		Scanner leia = new Scanner (System.in);
		System.out.print("Digite seu nome minúsculo: ");
		nome = leia.nextLine().toLowerCase();
		
		System.out.println("Resultado primeira inicial: "+ firstLetterUp(nome));
		
		nome = allFirstUp(nome);
		System.out.println("Resultado todas iniciais: "+ nome);
		
		System.out.println("Sem espaços a esquerda: "+noLeftSpaces(nome));
	}
	
	
	public static String firstLetterUp (String nome){
		return nome.replaceFirst(nome.substring(0,1), nome.substring(0,1).toUpperCase());
	}
	
	public static String allFirstUp (String nome){
		String novoNome = firstLetterUp(nome);
		for (int i = 1; i < nome.length();i++){
			if (nome.charAt(i) == ' '){
				novoNome = novoNome.replaceFirst(nome.substring(i+1, i+2), nome.substring(i+1, i+2).toUpperCase());
			}
		}
		
		return novoNome;
	}
	
	public static String noLeftSpaces (String nome){
		while (nome.charAt(0) == ' '){
			nome = nome.replaceFirst(" ", "");
		}	
		
		return nome;
	}
	
	public static String noRightSpaces (String nome){
		return "";
	}
}
