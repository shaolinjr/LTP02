import java.util.*;


public class Exerc5_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leia = new Scanner(System.in);
		boolean erro = false;
		String codigo, digitoDois,digitoVerificador;
		int digitoUm;
		
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
		
		digitoVerificador = calcularDigitoVerificador(codigo);
		
		// Resultado
		
		if (codigo.charAt(9) ==  codigo.charAt(0) && codigo.charAt(10) == digitoVerificador.charAt(1)){
			System.out.println("Código correto!");
		}
		else{
			System.out.println("Código inválido!");
		}
		
	}
	// Fazer manipulação para gerar resultado
	public static String calcularDigitoVerificador(String codigo){
		int somaDigitos = 0, multiplicaDigitos = 1;
		String digito= "";
		int digitoUm, digitoDois;
		for (byte x = 0;x < 9;x++){
			
			// Somando os 9 digitos
			somaDigitos += Character.digit(codigo.charAt(x), 10);
			// Multiplicando os 9 digitos
			multiplicaDigitos *=  Character.digit(codigo.charAt(x), 10);
		}	
		digitoUm = (int) somaDigitos / 10;
		digitoDois = multiplicaDigitos%10;
		// 0BS: Concatenar int's, soma uma string vazia antes dos valores 
		digito += digitoUm+digitoDois;
		
		return digito;
		
	}

}
