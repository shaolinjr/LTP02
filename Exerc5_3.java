import java.util.*;

public class Exerc5_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// EQUAÇÃO: (HF-HI)*60 + (MF-MI)
		Scanner leia = new Scanner(System.in);
		String horarioInicial = "", horarioFinal;
		float custoChamada = 0, custoTotal = 0;
		boolean horarioValido;
		int horaInicial, horaFinal, minutoInicial, minutoFinal,duracaoChamada;
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
				

			horaInicial= Integer.parseInt(horarioInicial.substring(0,2));
			horaFinal = Integer.parseInt(horarioFinal.substring(0,2));
			minutoInicial= Integer.parseInt(horarioInicial.substring(3));
			minutoFinal = Integer.parseInt(horarioFinal.substring(3));
			duracaoChamada = (horaFinal - horaInicial)*60 + (minutoFinal-minutoInicial); 
			// confistênfia hofafio final > hofafio inifial
			
			if (horaFinal < horaInicial){
				System.out.println("Horários inválidos");
			}else if (horaFinal == horaInicial && horaInicial > horaFinal){
				System.out.println("Horários inválidos");
			}else {
				if (horaInicial < 6){
					custoChamada = duracaoChamada * (float) 0.10;
				}else if (horaInicial < 8){
					custoChamada = duracaoChamada * (float) 0.15;
				}else if (horaInicial < 18){
					custoChamada = duracaoChamada * (float) 0.20;
				}else if (horaInicial < 24){
					custoChamada = duracaoChamada * (float) 0.15;
				}
				
				custoTotal += custoChamada;
			}	
			
		}while(true);
		
		System.out.println("Custo Total: R$"+ custoTotal);
	}
	
	public static boolean horarioEhValido (String horario){
		boolean valido	= false;
		
		String hora 	= horario.substring(0,2);
		String minuto 	= horario.substring(3);
		try{
			if(Integer.parseInt(hora) >= 0 && Integer.parseInt(hora) < 24){
				if (Integer.parseInt(minuto) >= 0 && Integer.parseInt(minuto) < 60){
					valido = true;
				}
			}
		}catch(NumberFormatException E){
			valido = false;
		}
		
		return valido;
	}

}
