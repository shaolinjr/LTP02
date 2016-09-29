import java.util.*;


public class Exerc5_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leia = new Scanner(System.in);
		boolean erro = false;
		String codigo, digitoDois;
		int digitoUm, somaDigitos = 0, multiplicaDigitos = 1;
		
		do {
			System.out.print("Digite o código contendo 11 caracteres: ");
			codigo = leia.next();
			
			if (codigo.length() != 11){
				System.out.println("Quantidade de caracteres inválida");
			}else {
				for(byte x = 0; x < 11; x++){
					if (codigo.charAt(x) < '0' || codigo.charAt(x) > '9'){
						System.out.println("Código inválido");
						erro = true;
						break;
					}
				}
			}
		}while (codigo.length() != 11 || erro == true);
		
		// Fazer manipulação para gerar resultado
		
		for (byte x = 0;x < 9;x++){
			
			// Somando os 9 digitos
			somaDigitos += Character.digit(codigo.charAt(x), 10);
			// Multiplicando os 9 digitos
			multiplicaDigitos *=  Character.digit(codigo.charAt(x), 10);
		}
		
		// Calculando digitoUm
		digitoUm = (int) somaDigitos / 10;
		
		// Calculando digitoDois
		String numeroString = String.valueOf(multiplicaDigitos);
		digitoDois = numeroString.substring(numeroString.length() - 1);
		
		// Mostrando dígitos
		System.out.println("1º Dígito verificador: "+ digitoUm);
		System.out.println("2º Dígito verificador: "+digitoDois);
		
		leia.close();
	}

}
