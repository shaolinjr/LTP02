import java.io.*;
import java.util.*;

public class Exerc7_1 {
	
	public static class Cliente {
		public char 	ativo;
		public int 		codCliente;
		public String 	nomeCliente;
		public float 	vlrCompra;
		public int		anoPrimeiraCompra;
		public boolean	emDia;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner				leia 	= new Scanner (System.in);
		Cliente				cliente = new Cliente();
		RandomAccessFile 	arquivo;
		boolean 			codigoJaExiste = false;
		char				confirmaGravacao, clienteEmDia;
		int 				codigoUnico;
		
		
		do {
			
			// valida codigo
			do {
				System.out.print("Digite o código do cliente: ");
				codigoUnico = leia.nextInt();
				
				if (codigoUnico <= 0){
					System.out.println("Código Inválido.Digite um número inteiro maior que 0.");
					break;
				}
				
			
				// Verifica se ja possui codigo do cliente
				try {
					arquivo = new RandomAccessFile("clientes", "rw");
					System.out.println("Abriu o arquivo!");
					while (cliente.codCliente != codigoUnico && cliente.ativo != 'S'){
						
						cliente.ativo 				= arquivo.readChar();
						cliente.codCliente 			= arquivo.readInt();
						cliente.nomeCliente 		= arquivo.readLine();
						cliente.vlrCompra			= arquivo.readFloat();
						cliente.anoPrimeiraCompra 	= arquivo.readInt();
						cliente.emDia				= arquivo.readBoolean();
						
						if (cliente.codCliente == codigoUnico && cliente.ativo == 'S'){
							System.out.println("Cliente já cadastrado.");
							codigoJaExiste = true;
							break;
						}
					}
					
					arquivo.close();
					
				}catch (EOFException e){
					codigoJaExiste = false;
				}catch (IOException e){
					System.out.println("Erro ao tentar abrir o arquivo, finalizando o programa.");
					System.exit(0);
				}
			
			}while(codigoJaExiste);
			leia.nextLine();
			// Adicionando os dados
			cliente.ativo = 'S';
			cliente.codCliente = codigoUnico;
			// valida nome
			do{
				System.out.print("Digite o nome do cliente..............: ");
				cliente.nomeCliente = leia.nextLine();
				if (cliente.nomeCliente.equals("") || cliente.nomeCliente.length() < 10){
					System.out.println("Nome inválido. Digite novamente.");
				}
			}while(cliente.nomeCliente.equals("") || cliente.nomeCliente.length() < 10);
			
			//valida valor compra
			System.out.print("Digite o valor da compra..................: ");
			cliente.vlrCompra = leia.nextFloat();
			//valida ano primeira compra
			System.out.print("Digite o ano da primeira compra...........: ");
			cliente.anoPrimeiraCompra = leia.nextInt();
			do {
				System.out.print("Cliente em dia [S/N]?.................: ");
				clienteEmDia = leia.next().charAt(0);
				if (clienteEmDia == 'S'){
					cliente.emDia = true; // verificar condição
				}else if (clienteEmDia == 'N'){
					cliente.emDia = false;
				}else {
					System.out.println("Opção inválida. Tente novamente.");
				}
			}while(clienteEmDia != 'S' && clienteEmDia != 'N');
			// Confirma gravacao dos dados
			do {
				System.out.print("Confirma a gravação dos dados [S/N]?: ");
				confirmaGravacao = leia.next().charAt(0);
				if (confirmaGravacao == 'S'){
					try{
						arquivo = new RandomAccessFile("clientes", "rw");
						arquivo.seek(arquivo.length());
						arquivo.writeChar(cliente.ativo);
						arquivo.writeInt(cliente.codCliente);
						arquivo.writeUTF(cliente.nomeCliente);
						arquivo.writeFloat(cliente.vlrCompra);
						arquivo.writeInt(cliente.anoPrimeiraCompra);
						arquivo.writeBoolean(cliente.emDia);
						arquivo.close();
						
						System.out.println("Dados gravados com sucesso!");
						
					}catch(IOException e){
						System.out.println("Erro na gravação do arquivo. O programa será finalizado.");
						System.exit(0);
					}
				}
				if (confirmaGravacao != 'S' && confirmaGravacao != 'N'){
					System.out.println("Opção inválida. Digite novamente.");
				}
			}while(confirmaGravacao != 'S' && confirmaGravacao != 'N');
			
		
		}while(true);
	}

}
