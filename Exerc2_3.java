import java.util.*;
public class Exerc2_3 {

	public static void main(String[] args) {
		Scanner		leia = new Scanner(System.in);
		
		int			codigoOperario = 1,
					numeroPecasMes,
					totalPecas = 0,
					menorNumeroPecas = 9999,
					menorNumeroCodigo = 0,
					classeBContador = 0,
					numeroPecasB = 0;
		
		char 		classeOperario;
		
		double		salarioOperario = 0,
					totalSalarios = 0;
		
		while (codigoOperario != 0){
			
			
			System.out.print("Digite seu código (Digite 0 para sair): ");
			codigoOperario = leia.nextInt();
			if (codigoOperario == 0){
				System.out.println("Saindo do programa...");
				break;
			}
			
			System.out.print("Digite sua classe: ");
			classeOperario = leia.next().charAt(0);
			while(classeOperario != 'A' && classeOperario != 'B' && classeOperario != 'C'){
				System.out.print("Valor inválido. Digite novamente: ");
				classeOperario = leia.next().charAt(0);
			}
			
			System.out.print("Digite o número de peças fabricadas no mês: ");
			numeroPecasMes = leia.nextInt();
			while(numeroPecasMes < 0){
				System.out.print("Valor inválido. Digite novamente: ");
				numeroPecasMes = leia.nextInt();	
			}
			
			//menor numero de peças
			if (numeroPecasMes < menorNumeroPecas){
				menorNumeroCodigo = codigoOperario;
			}
			
			// calcular salario e especificos de classe
			switch (classeOperario){
			case 'A':
				
				if (numeroPecasMes <= 30){
					salarioOperario = 500 + (2 * numeroPecasMes);
				} else if (numeroPecasMes <= 40){
					salarioOperario = 500 + (2.30 * numeroPecasMes);
				}else {
					salarioOperario = 500 + (2.80 * numeroPecasMes);
				}
				break;
				
				
			case 'B':
				salarioOperario = 1200;
				classeBContador++;
				numeroPecasB += numeroPecasMes;
				break;
				
			case 'C':
				if (numeroPecasMes <= 50){
					salarioOperario = 40 * numeroPecasMes;
				}else {
					salarioOperario = 45 * numeroPecasMes;
				}
				break;
				
			default:
				System.out.println("Não se encaixa."); // nunca deve acontecer.
				break;
			}
			
			// somando para total de salarios
			totalSalarios += salarioOperario;
			totalPecas += numeroPecasMes;
			
			System.out.println(codigoOperario+", seu salário é: "+ salarioOperario);
			
			
		}
		
		leia.close();
		
		System.out.println("Total gasto com salários: "+ totalSalarios);
		System.out.println("Total de peças produzidas: "+ totalPecas);
		System.out.println("Funcionário com menos peças: "+ menorNumeroCodigo);
		System.out.println("Media de peças classe B: "+ (double) numeroPecasB / classeBContador);
	}

}

/*
 "/$$    /$$$$$$$$ /$$$$$$$   /$$$$$$   /$$$$$$ "+
"| $$   |__  $$__/| $$__  $$ /$$$_  $$ /$$__  $$"+
"| $$      | $$   | $$  \ $$| $$$$\ $$|__/  \ $$"+
"| $$      | $$   | $$$$$$$/| $$ $$ $$  /$$$$$$/"+
"| $$      | $$   | $$____/ | $$\ $$$$ /$$____/ "+
"| $$      | $$   | $$      | $$ \ $$$| $$      "+
"| $$$$$$$$| $$   | $$      |  $$$$$$/| $$$$$$$$"+
"|________/|__/   |__/       \______/ |________/"
*/
                                              
                                              
 