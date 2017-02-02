package systemitself;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

	private static Scanner input;
	private static ArrayList<Colaborador> colaboradores;
	private List<Projeto> projetos;
	private static Colaborador fulano;
	
	public static void mostrar_Colaboradores(List <Colaborador> colaboradores){
		
		Colaborador fulano = null;
		int aux;
		int total_participantes = colaboradores.size();
		
		System.out.println(total_participantes);
		if(total_participantes == 0){
			System.out.println("N�o h� colaboradores para listar!");
		}
		
		for(aux = 0; aux < total_participantes; aux++){
			fulano = colaboradores.get(aux);
			
			System.out.print("\nNome: " + fulano.nome + "\nEmail: " + fulano.email + "\n" + fulano.retorna_nomezinho());
		}
	}
	
	public static AlunoGraduacao adicionar_AG(String nome, String email){
		
		AlunoGraduacao fulano = new AlunoGraduacao();
		
		fulano.setName(nome);
		fulano.setEmail(email);
		
		System.out.println("Sucesso!");
		
		return fulano;
	}
	public static AlunoMestrado adicionar_AM(String nome, String email){
		
		AlunoMestrado fulano = new AlunoMestrado();
		
		fulano.setName(nome);
		fulano.setEmail(email);
		
		System.out.println("Sucesso!");
		
		return fulano;
	}
	public static AlunoDoutorado adicionar_AD(String nome, String email){
		
		AlunoDoutorado fulano = new AlunoDoutorado();
		
		fulano.setName(nome);
		fulano.setEmail(email);
		
		System.out.println("Sucesso!");
		
		return fulano;
	}
	public static Professor adicionar_P(String nome, String email){
		
		Professor fulano = new Professor();
		
		fulano.setName(nome);
		fulano.setEmail(email);
		
		System.out.println("Sucesso!");
		
		return fulano;
	}
	
	
	public static Colaborador adicionar_Colaborador(){
		
		String nome, email;
		int tipo;
		
		input = new Scanner(System.in);
		System.out.print("Insira o nome do novo colaborador: ");
		nome = input.nextLine();
		
		System.out.print("Insira o e-mail do novo colaborador: ");
		email = input.nextLine();
		
		System.out.println("Selecione o tipo de Colaborador: \n1- Aluno de Gradua��o            2- Aluno de Mestrado\n3- Aluno de Doutorado"
				+ "            4- Professor\n"
				+ "5-Pesquisador");
		
		tipo = input.nextInt();
		
		if(tipo == 1){
			return adicionar_AG(nome,email);
		}else if(tipo == 2){
			return adicionar_AM(nome,email);
		}else if(tipo == 3){
			return adicionar_AD(nome,email);
		}else{
			return adicionar_P(nome,email);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int comando = 1;
		input = new Scanner(System.in);
		colaboradores = new ArrayList<Colaborador>();
		
		
		while(comando != 0){
			
			System.out.print("----------------------------------------------------\n"
                                + "Seja bem vindo!\nSelecione uma das op��es abaixo:\n\n"
					+ "1- Alocar Colaborador\n"                     
					+ "2- Alterar Status\n"		   
					+ "3- Inclus�o de Publica��o\n"        
					+ "4- Consultar Colaborador\n"     
					+ "5- Consultar Projeto\n"		   
					+ "6- Mostrar relat�rio do Laborat�rio\n" 
					+ "7- Adicionar Colaborador\n"      
					+ "8- Adicionar Projeto\n"
					+ "Aperte '0' para sair !\n"	
                                + "----------------------------------------------------\n\n\n\n\n"
                                + "Comando:");
			
			comando = input.nextInt();
			
			if(comando == 0){
				System.out.println("Obrigado por utilizar o Sistema !");
				break;
			}
			
			switch(comando){
				case 1:
					System.out.println("Aloca��o de Colaborador\n-----------------------------\n");
					break;
				
				case 2:
					System.out.println("Altera��o de Status\n-----------------------------\n");
					break;
					
				case 3:
					System.out.println("Inclus�o de Publica��o\n-----------------------------\n");
					break;
				
				case 4:
					System.out.println("Consulta de Colaborador\n-----------------------------\n");
					
					break;
					
				case 5:
					System.out.println("Consulta de Projeto\n-----------------------------\n");
					break;
				
				case 6:
					System.out.println("Exibir Relat�rio do Laborat�rio\n-----------------------------\n");
					break;
					
				case 7:
					System.out.println("Adi��o de Colaborador\n-----------------------------\n");
					colaboradores.add(adicionar_Colaborador());
					mostrar_Colaboradores(colaboradores);
					break;
					
				case 8:
					System.out.println("Adi��o de Projeto\n-----------------------------\n");
					
					break;
				
				default:
					System.out.println("Por favor, insira um comando v�lido!\n-----------------------------\n");
					break;

			}
	
		}
	}
}
