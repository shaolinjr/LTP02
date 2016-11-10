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
	
	//Variáveis globais da classe Exerc7_1
	static RandomAccessFile 	arquivo;
	static Cliente				cliente = new Cliente();
	static boolean 				codigoJaExiste = false;
	static char					confirmaGravacao, clienteEmDia;
	static int 					codigoUnico;
	static Scanner				leia 	= new Scanner (System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte opcaoMenu;
		
		do {
			do {
				System.out.println("Seja bem-vindo ao Personal Client Management");
				System.out.println("Menu:");
				System.out.println("[0] Sair");
				System.out.println("[1] Incluir cliente");
				System.out.println("[2] Alterar dados de algum cliente");
				System.out.println("[3] Excluir algum cliente");
				System.out.println("[4] Pesquisar dados de algum cliente");
				System.out.print("\nO que deseja fazer?: ");
				
				opcaoMenu = leia.nextByte();
				
				if (opcaoMenu > 5 && opcaoMenu < 0){
					System.out.println("Opção inválida.");
				}
			}while(opcaoMenu > 5 && opcaoMenu < 0);
			
			if (opcaoMenu == 0){
				System.out.println("Até logo!");
				break;
			}
			
			switch (opcaoMenu){
	
			case 1:
				System.out.println("****************** INCLUSÃO DE CLIENTES ******************");
				inclusaoClientes();
				break;
			case 2:
				System.out.println("****************** ALTERAÇÃO DE DADOS ********************");
				alterarDadosCliente();
				break;
			case 3:
				System.out.println("****************** EXCLUSÃO DADOS ************************");
				break;
			case 4:
				System.out.println("****************** PESQUISA DE DADOS *********************");
				break;
			}
			
		}while(true);
		
	}
	
	
	
	public static void alterarDadosCliente (){
		do {
			// valida codigo
			do {
				System.out.print("Digite o código do cliente [0, para sair]: ");
				codigoUnico = leia.nextInt();
				if (codigoUnico == 0){
					System.out.println("Saindo do programa...");
					break;
				}
				else if (codigoUnico < 0){
					System.out.println("Código Inválido.Digite um número inteiro maior que 0.");
					break;
				}
				
				// Verifica se ja possui codigo do cliente
				try {
					arquivo = new RandomAccessFile("clientes", "rw");
					System.out.println("Abriu o arquivo!");
					while (true){
						
						cliente.ativo 				= arquivo.readChar();
						cliente.codCliente 			= arquivo.readInt();
						cliente.nomeCliente 		= arquivo.readUTF();
						cliente.vlrCompra			= arquivo.readFloat();
						cliente.anoPrimeiraCompra 	= arquivo.readInt();
						cliente.emDia				= arquivo.readBoolean();
						
						if (cliente.codCliente == codigoUnico && cliente.ativo == 'S'){
							codigoJaExiste = true;
							break;
						}
					}
					
					arquivo.close();
					
				}catch (EOFException e){
					codigoJaExiste = false;
					System.out.println("Código de cliente não encontrado.");
				}catch (IOException e){
					System.out.println("Erro ao tentar abrir o arquivo, finalizando o programa.");
					System.exit(0);
				}
			
			}while(!codigoJaExiste);
			
			// encontrou codigo
		}while(true);
	}
	
	public static void inclusaoClientes (){
		do {
			// valida codigo
			do {
				System.out.print("Digite o código do cliente [0, para sair]: ");
				codigoUnico = leia.nextInt();
				if (codigoUnico == 0){
					System.out.println("Saindo do programa...");
					break;
				}
				else if (codigoUnico < 0){
					System.out.println("Código Inválido.Digite um número inteiro maior que 0.");
					break;
				}
				
				// Verifica se ja possui codigo do cliente
				try {
					arquivo = new RandomAccessFile("clientes", "rw");
					System.out.println("Abriu o arquivo!");
					while (true){
						
						cliente.ativo 				= arquivo.readChar();
						cliente.codCliente 			= arquivo.readInt();
						cliente.nomeCliente 		= arquivo.readUTF();
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
			
			if (codigoUnico == 0){
				break;
			}
			
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
			do {
				System.out.print("Digite o ano da primeira compra...........: ");
				cliente.anoPrimeiraCompra = leia.nextInt();
				
				if (cliente.anoPrimeiraCompra > 2013){
					System.out.println("Ano inválido, tem que ser menor ou igual 2013. Digite novamente.");
				}
			}while(cliente.anoPrimeiraCompra > 2013);
			
			// valida e coloca status para cliente em dia
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
					insereCliente();
				}
				if (confirmaGravacao != 'S' && confirmaGravacao != 'N'){
					System.out.println("Opção inválida. Digite novamente.");
				}
			}while(confirmaGravacao != 'S' && confirmaGravacao != 'N');
			
		
		}while(true);
	}
	public static void insereCliente (){
	
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
	
}