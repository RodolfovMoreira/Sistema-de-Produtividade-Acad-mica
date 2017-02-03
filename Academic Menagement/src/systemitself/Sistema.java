package systemitself;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

	private static Scanner input;
	private static ArrayList<Colaborador> colaboradores;
	private static ArrayList<Projeto> projetos;


	//------------- Métodos Auxiliares ------------------
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
	
	public static void mostrar_Colaboradores(List <Colaborador> colaboradores){
		
		Colaborador fulano = null;
		int aux;
		int total_participantes = colaboradores.size();
		
		if(total_participantes == 0){
			System.out.println("Não há colaboradores para listar!");
		}
		
		for(aux = 0; aux < total_participantes; aux++){
			fulano = colaboradores.get(aux);
			
			System.out.print("\nID: " + aux + " || Nome: " + fulano.nome + " || Email: " + fulano.email + " e" + fulano.retorna_tipo());
		}
	}
	public static void mostrar_Projetos(List <Projeto> projetos){
		
		Projeto projeto = null;
		int aux;
		int total_projetos = projetos.size();
		
		if(total_projetos == 0){
			System.out.println("Não há colaboradores para listar!");
		}
		
		for(aux = 0; aux < total_projetos; aux++){
			projeto = projetos.get(aux);
			
			System.out.print("\nTítulo: " + projeto.titulo + " || Status: " + projeto.get_Status());
		}
	}
	//------------- Métodos Principais ------------------
	public static Colaborador adicionar_Colaborador(){
		
		String nome, email;
		int tipo;
		
		input = new Scanner(System.in);
		System.out.print("Insira o nome do novo colaborador: ");
		nome = input.nextLine();
		
		System.out.print("Insira o e-mail do novo colaborador: ");
		email = input.nextLine();
		
		System.out.println("Selecione o tipo de Colaborador: \n1- Aluno de Graduação            2- Aluno de Mestrado\n3- Aluno de Doutorado"
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
	public static Projeto adicionar_Projeto(){
		
		String titulo, data_inicio, data_termino, agencia_financiadora, objetivo, descricao;
		double valor_financiado;
		
		Projeto projetonovo = new Projeto();
		
		input = new Scanner(System.in);
		System.out.print("Insira o título do projeto: ");
		titulo = input.nextLine();
		System.out.print("Insira a data de início do projeto (dd/mm/aa) : ");
		data_inicio = input.nextLine();
		System.out.print("Insira a data de término do projeto (dd/mm/aa) : ");
		data_termino = input.nextLine();
		System.out.print("Agência financiadora do projeto: ");
		agencia_financiadora = input.nextLine();
		System.out.print("Digite o objetivo do Projeto: ");
		objetivo = input.nextLine();
		System.out.print("Descreva o projeto: ");
		descricao = input.nextLine();
		System.out.print("Digite o valor financiado: ");
		valor_financiado = input.nextDouble();
		
		projetonovo.setTitulo(titulo);
		projetonovo.setDataInicio(data_inicio);
		projetonovo.setDataTermino(data_termino);
		projetonovo.setAgenciaFinanciadora(agencia_financiadora);
		projetonovo.setObjetivo(objetivo);
		projetonovo.setDescricao(descricao);
		projetonovo.setValorFinanciado(valor_financiado);
		projetonovo.setStatus_EmElaboracao(1);
		
		
		
		return projetonovo;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int comando = 1;
		input = new Scanner(System.in);
		colaboradores = new ArrayList<Colaborador>();
		projetos = new ArrayList<Projeto>();
		
		
		
		while(comando != 0){
			
			System.out.print("\n\n----------------------------------------------------\n"
                                + "Seja bem vindo!\nSelecione uma das opções abaixo:\n\n"
					+ "1- Alocar Colaborador\n"                     
					+ "2- Alterar Status\n"		   
					+ "3- Inclusão de Publicação\n"        
					+ "4- Consultar Colaborador\n"     
					+ "5- Consultar Projeto\n"		   
					+ "6- Mostrar relatório do Laboratório\n" 
					+ "7- Adicionar Colaborador\n"      //feito
					+ "8- Adicionar Projeto\n"
					+ "9- Mostrar Colaboradores\n"
					+ "10- Mostrar Projetos\n"
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
					System.out.println("Alocação de Colaborador\n-----------------------------\n");
					break;
				
				case 2:
					System.out.println("Alteração de Status\n-----------------------------\n");
					break;
					
				case 3:
					System.out.println("Inclusão de Publicação\n-----------------------------\n");
					break;
				
				case 4:
					System.out.println("Consulta de Colaborador\n-----------------------------\n");
					
					break;
					
				case 5:
					System.out.println("Consulta de Projeto\n-----------------------------\n");
					break;
				
				case 6:
					System.out.println("Exibir Relatório do Laboratório\n-----------------------------\n");
					break;
					
				case 7:
					System.out.println("Adição de Colaborador\n-----------------------------\n");
					colaboradores.add(adicionar_Colaborador());

					break;
					
				case 8:
					System.out.println("Adição de Projeto\n-----------------------------\n");
					projetos.add(adicionar_Projeto());
					break;
					
				case 9:
					System.out.println("Mostrar Colaboradores do Laboratório\n-----------------------------\n");
					mostrar_Colaboradores(colaboradores);
					
					break;
					
				case 10:
					System.out.println("Mostrar Projetos do Laboratório\n-----------------------------\n");
					mostrar_Projetos(projetos);
					break;
				
				default:
					System.out.println("Por favor, insira um comando válido!\n-----------------------------\n");
					break;

			}
	
		}
	}
}
