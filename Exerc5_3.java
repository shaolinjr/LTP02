import java.util.*;

public class Exerc5_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// EQUA��O: (HF-HI)*60 + ()
		Scanner leia = new Scanner(System.in);
		String horarioInicial = "", horarioFinal;
		float custoChamada, custoTotal;
		boolean horarioValido;
		
		do {
			
			do {
				System.out.println("Sempre que quiser sair, digite 0, no hor�rio inicial");
				System.out.print("Digite o hor�rio inicial [HH:MM]: ");
				horarioInicial = leia.next();
				// chamar metodo de valida��o
				if (horarioInicial.equals("0")){	
					break;
				}else{
					
					horarioValido = horarioEhValido(horarioInicial);
				
					if (!horarioValido){
						System.out.println("Hor�rio inv�lido");
					}
				}
			}while(!horarioValido);
			
			if (horarioInicial.equals("0")){	
				System.out.println("Saindo...");
				break;
			}
			
			do {
				System.out.print("Digite o hor�rio final [HH:MM]: ");
				horarioFinal = leia.next();
				// chamar metodo de vaida��o
				horarioValido = horarioEhValido(horarioFinal);
				if (!horarioValido){
					System.out.println("Hor�rio inv�lido");
				}
			}while(!horarioValido);
				
			// confist�nfia hofafio final > hofafio inifial
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
