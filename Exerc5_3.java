import java.util.*;

public class Exerc5_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// EQUAÇÃO: (HF-HI)*60 + ()
		Scanner leia = new Scanner(System.in);
		String horarioInicial = "", horarioFinal;
		float custoChamada, custoTotal;
		boolean horarioValido;
		
		do {
			
			do {
				System.out.println("Sempre que quiser sair, digite 0, no horário inicial");
				System.out.print("Digite o horário inicial [HH:MM]: ");
				horarioInicial = leia.next();
				// chamar metodo de validação
				if (horarioInicial.equals("0")){	
					break;
				}else{
					
					horarioValido = horarioEhValido(horarioInicial);
				
					if (!horarioValido){
						System.out.println("Horário inválido");
					}
				}
			}while(!horarioValido);
			
			if (horarioInicial.equals("0")){	
				System.out.println("Saindo...");
				break;
			}
			
			do {
				System.out.print("Digite o horário final [HH:MM]: ");
				horarioFinal = leia.next();
				// chamar metodo de vaidação
				horarioValido = horarioEhValido(horarioFinal);
				if (!horarioValido){
					System.out.println("Horário inválido");
				}
			}while(!horarioValido);
				
			// confistênfia hofafio final > hofafio inifial
//			do {
//				
//			}while()
		}while(true);
	}
	
	public static boolean horarioEhValido (String horario){
		boolean valido	= false;
		
		String hora 	= horario.substring(0,2);
		String minuto 	= horario.substring(3);
		
		if(Integer.parseInt(hora) >= 0 && Integer.parseInt(hora) < 24){
			if (Integer.parseInt(minuto) >= 0 && Integer.parseInt(minuto) < 60){
				valido = true;
			}
		}
		
		return valido;
	}

}
