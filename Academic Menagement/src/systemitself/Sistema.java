package systemitself;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

	private static Scanner input;
	private static ArrayList<Colaborador> colaboradores;
	private static ArrayList<Projeto> projetos;


	//------------- M�todos Auxiliares ------------------
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
	
	public static void mostrar_Alunos(List <Colaborador> colaboradores, int i){
		
		Colaborador fulano = null;
		int aux;
		int total_participantes = colaboradores.size();
		
		if(total_participantes == 0){
			System.out.println("N�o h� Professores para listar!");
		}
		
		for(aux = 0; aux < total_participantes; aux++){
			fulano = colaboradores.get(aux);
			
			if(!fulano.Teste_Pesquisador()){
				if(!(aux == i)){
					System.out.print("\nID: " + aux + " || Nome: " + fulano.nome);	
				}	
			}
		}
	}
	public static void mostrar_Professores(List <Colaborador> colaboradores){
		
		Colaborador fulano = null;
		int aux;
		int total_participantes = colaboradores.size();
		
		if(total_participantes == 0){
			System.out.println("N�o h� Professores para listar!");
		}
		
		for(aux = 0; aux < total_participantes; aux++){
			fulano = colaboradores.get(aux);
			
			if(fulano.Teste_Professor()){
				System.out.print("\nID: " + aux + " || Nome: " + fulano.nome);	
			}
		}
	}
	public static void mostrar_Colaboradores(List <Colaborador> colaboradores){
		
		Colaborador fulano = null;
		int aux;
		int total_participantes = colaboradores.size();
		
		if(total_participantes == 0){
			System.out.println("N�o h� colaboradores para listar!");
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
			System.out.println("N�o h� colaboradores para listar!");
		}
		
		for(aux = 0; aux < total_projetos; aux++){
			projeto = projetos.get(aux);
			
			System.out.print("\nID:" + aux + " || T�tulo: " + projeto.titulo + " || Status: " + projeto.get_Status());
		}
	}
	public static void mostrar_Projetos_Em_Elaboracao(List <Projeto> projetos){
		
		Projeto projeto = null;
		int aux;
		int total_projetos = projetos.size();
		
		if(total_projetos == 0){
			System.out.println("N�o h� colaboradores para listar!");
		}
		
		for(aux = 0; aux < total_projetos; aux++){
			projeto = projetos.get(aux);
			
			if(projeto.get_Status() == "Em Elabora��o"){
				System.out.print("\nID: "+ aux +"  || T�tulo: " + projeto.titulo);				
			}
		}
	}
	public static void atualizar_Status(List<Colaborador> colaboradores, List<Projeto> projetos){ // Roda todos os projetos procurando quais podem alterar os status
		
		int aux = 0, contador = 0, id = 0;
		int total_projetos = projetos.size();
		Projeto projeto = null;
		
		System.out.println("Selecione o ID do projeto que deseja Come�ar/Concluir:");
		
		for(aux = 0; aux < total_projetos; aux++){
			projeto = projetos.get(aux);
			
			if(projeto.conferir_Projeto_Prontoparacomecar()){
				contador++;
				System.out.print("\nID: "+ aux +" T�tulo: " + projeto.titulo + " - EST� PRONTO PARA COME�AR!");
			}else if(projeto.conferir_Projeto_Prontoparaconcluir()){
				contador++;
				System.out.print("\nID: "+ aux +" T�tulo: " + projeto.titulo + " - EST� PRONTO PARA CONCLUIR!");
			}
		}
		
		if(contador == 0){
			System.out.println("Desculpe! N�o h� projetos prontos para Concluir/Come�ar!");
		}else{
			System.out.print("\nProjeto n�mero: ");
			id = input.nextInt();
			
			projeto = projetos.get(id);
			projeto.alterar_Status();
			System.out.println("Status do projeto \"" + projeto.titulo + "\" mudou para "+ projeto.get_Status());
		}		
		
	}
	
	//------------- M�todos Principais ------------------
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
	public static Projeto adicionar_Projeto(){
		
		String titulo, data_inicio, data_termino, agencia_financiadora, objetivo, descricao;
		double valor_financiado;
		
		Projeto projetonovo = new Projeto();
		
		input = new Scanner(System.in);
		System.out.print("Insira o t�tulo do projeto: ");
		titulo = input.nextLine();
		System.out.print("Insira a data de in�cio do projeto (dd/mm/aa) : ");
		data_inicio = input.nextLine();
		System.out.print("Insira a data de t�rmino do projeto (dd/mm/aa) : ");
		data_termino = input.nextLine();
		System.out.print("Ag�ncia financiadora do projeto: ");
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
		projetonovo.setStatus(1);
		
		
		
		return projetonovo;
	}
	public static void alocar_Colaborador(List<Colaborador> colaboradores, List<Projeto> projetos){
		
		int id_colaborador, id_projeto;
		
		input = new Scanner(System.in);
		if(colaboradores.size() == 0 || projetos.size() == 0){
			System.out.println("Aloca��o n�o permitida! N�o existem projetos e/ou colaboradores suficientes para prosseguir com a aloca��o!");
		}else{
			mostrar_Projetos_Em_Elaboracao(projetos);
			System.out.print("\nSELECIONE O ID DO PROJETO AONDE O COLABORADOR SER� ALOCADO: ");
			id_projeto = input.nextInt();
			
			mostrar_Colaboradores(colaboradores);
			System.out.print("\nSELECIONE O ID DO COLABORADOR A SE ALOCADO: ");
			id_colaborador = input.nextInt();
			
			Colaborador fulano = colaboradores.get(id_colaborador);
			Projeto projeto = projetos.get(id_projeto);
			
			if(fulano.Teste_Aluno_Graduacao()){
				if(fulano.pode_Alocar()){
					fulano.adicionar_Projeto(projeto);
					projeto.adicionar_Colaboradores(fulano);
				}else{
					System.out.println("\nAloca��o n�o permitida ! Aluno participa de mais de dois Projetos \"Em Andamento\"");
				}
			}else{
				fulano.adicionar_Projeto(projeto);
				projeto.adicionar_Colaboradores(fulano);
			}	
		}
		
	}
	public static void adicionar_Orientacao_Publicacao(List<Colaborador> colaboradores, List<Projeto> projetos){
		
		int escolha = 0, id_professor = 0, id_aluno=0, ano, id,	id_autor, comando = 1;
		Projeto projeto = null;
		Colaborador fulano = null;
		Colaborador sicrano = null;
		String titulos, conferencia, lixo;
		
		System.out.print("\n------------------------\nSelecione:\n1- Orienta��o\n2- Publica��o\n------------------------\nEscolha:");
		
		escolha = input.nextInt();
		lixo = input.nextLine(); // pega escape
		
		
		if(escolha == 1){
			mostrar_Professores(colaboradores);
			System.out.print("\nDigite o ID do professor: ");
			id_professor = input.nextInt();
			
			System.out.println("\n\n");
			mostrar_Alunos(colaboradores,id_professor);
			System.out.print("\nDigite o ID do aluno: ");
			id_professor = input.nextInt();
			fulano = colaboradores.get(id_professor);
			sicrano = colaboradores.get(id_aluno);
			
			fulano.adicionar_Orientacao(sicrano);
			System.out.println("\nOrienta��o adicionada com sucesso!");
		}else if(escolha == 2){
			
			Publicacoes publicacao = new Publicacoes();
			
			System.out.print("\nDigite o t�tulo da Publica��o: ");
			titulos = input.nextLine();
			System.out.print("Digite a confer�ncia onde foi publicada: ");
			conferencia = input.nextLine();
			System.out.print("Digite o ano de publica��o: ");
			ano = input.nextInt();
			
			publicacao.set_Titulo(titulos);
			publicacao.set_Conferencia(conferencia);
			publicacao.set_Ano(ano);
			
			System.out.print("\nDeseja associar a um projeto?\n1- Sim\n2- N�o\n");
			escolha = input.nextInt();
			
			if(escolha == 1){
				mostrar_Projetos(projetos);
				System.out.print("\nID do projeto a ser associado: ");
				id = input.nextInt();
				projeto = projetos.get(id);
				
				if(projeto.Consultar_Status() == 3){
					publicacao.set_ProjetoAssociado(projeto);	
					projeto.adicionar_Publicacao(publicacao);
				}else{
					System.out.print("\nProjeto selecionado n�o est� em andamento, associa��o proibida!\n");
				}
			}
			while(comando == 1){
				mostrar_Colaboradores(colaboradores);
				System.out.print("\nSelecione o ID do autor: ");
				id_autor = input.nextInt();
					
				sicrano = colaboradores.get(id_autor);
					
				publicacao.adicionar_Colaborador(sicrano);
				sicrano.adicionar_Publicacao(publicacao);
					
				System.out.print("Deseja adicionar outro autor?\n"
						+ "1-Sim\n"
						+ "0-N�o\n"
						+ "Escolha: ");
				comando = input.nextInt();
			}
			
			System.out.println("\nPublica��o adicionada com sucesso!");
		}else{
			System.out.println("Entrada inv�lida!");
		}
		
		
	}
	//---------------------------------------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int comando = 1;
		input = new Scanner(System.in);
		colaboradores = new ArrayList<Colaborador>();
		projetos = new ArrayList<Projeto>();
		
		
		
		while(comando != 0){
			
			System.out.print("\n\n----------------------------------------------------\n"
                                + "Seja bem vindo!\nSelecione uma das op��es abaixo:\n\n"
					+ "1- Alocar Colaborador\n"         //feito    
					+ "2- Alterar Status\n"		   		//feito
					+ "3- Inclus�o de Publica��o\\Orienta��o\n"    //feito    
					+ "4- Consultar Colaborador\n"     
					+ "5- Consultar Projeto\n"		   
					+ "6- Mostrar relat�rio do Laborat�rio\n" 
					+ "7- Adicionar Colaborador\n"      //feito
					+ "8- Adicionar Projeto\n"			//feito
					+ "9- Mostrar Colaboradores\n"		//feito
					+ "10- Mostrar Projetos\n"			//feito
					+ "Aperte '0' para sair !\n"		//feito
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
					alocar_Colaborador(colaboradores, projetos);
					break;
				
				case 2:
					System.out.println("Altera��o de Status\n-----------------------------\n");
					atualizar_Status(colaboradores, projetos);
					break;
					
				case 3:
					System.out.println("Inclus�o de Publica��o\n-----------------------------\n");
					adicionar_Orientacao_Publicacao(colaboradores, projetos);
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

					break;
					
				case 8:
					System.out.println("Adi��o de Projeto\n-----------------------------\n");
					projetos.add(adicionar_Projeto());
					break;
					
				case 9:
					System.out.println("Mostrar Colaboradores do Laborat�rio\n-----------------------------\n");
					mostrar_Colaboradores(colaboradores);
					
					break;
					
				case 10:
					System.out.println("Mostrar Projetos do Laborat�rio\n-----------------------------\n");
					mostrar_Projetos(projetos);
					break;
				
				default:
					System.out.println("Por favor, insira um comando v�lido!\n-----------------------------\n");
					break;

			}
	
		}
	}
}
