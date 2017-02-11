package systemitself;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
	public static void relatorio_Laboratorio(List<Projeto> projetos, List<Colaborador> colaboradores, int ori, int publi){
		
		int elaboracao = 0, andamento = 0, concluido = 0, aux;
		int total_projetos = projetos.size();
		int total_colaboradores = colaboradores.size();
		Projeto projeto = null;
		
		for(aux = 0; aux < total_projetos; aux++){
			projeto = projetos.get(aux);
			
			if(projeto.Consultar_Status() == 1){
				elaboracao++;
			}else if(projeto.Consultar_Status() == 3){
				andamento++;
			}else{
				concluido++;
			}
		}
		
		System.out.println("Atualmente no laboratório temos "+ total_colaboradores +
				" colaboradores alocados em "+ total_projetos + " projetos, dos quais "+ elaboracao 
				+ " estão em Elaboração, "+ andamento + " estão em Andamento e "+ concluido + " Concluídos."
						+ " Além do total de " + ori + " Orientações e " + publi + " Publicações");
		
	}
	
	public static int mostrar_Alunos(List <Colaborador> colaboradores, int i){
		
		Colaborador fulano = null;
		int aux, contador = 0;
		int total_participantes = colaboradores.size();
		
		if(total_participantes == 0){
			System.out.println("Não há Alunos para listar!");
			return contador;
		}
		
		for(aux = 0; aux < total_participantes; aux++){
			fulano = colaboradores.get(aux);
			
			if(!fulano.Teste_Pesquisador()){
				if(!(aux == i)){
					contador++;
					System.out.print("\nID: " + aux + " || Nome: " + fulano.nome);	
				}	
			}
		}
		return contador;
	}
	public static int mostrar_Professores(List <Colaborador> colaboradores){
		
		Colaborador fulano = null;
		int aux, contador=0;
		int total_participantes = colaboradores.size();
		
		if(total_participantes == 0){
			System.out.println("Não há Professores para listar!");
			return 0;
		}
		
		for(aux = 0; aux < total_participantes; aux++){
			fulano = colaboradores.get(aux);
			
			if(fulano.Teste_Professor()){
				contador++;
				System.out.print("\nID: " + aux + " || Nome: " + fulano.nome);	
			}
		}
		return contador;
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
	public static int mostrar_Projetos(List <Projeto> projetos){
		
		Projeto projeto = null;
		int aux;
		int total_projetos = projetos.size();
		
		if(total_projetos == 0){
			System.out.println("Não há projetos para listar!");
			return 0;
		}
		
		for(aux = 0; aux < total_projetos; aux++){
			projeto = projetos.get(aux);
			
			System.out.print("\nID:" + aux + " || Título: " + projeto.titulo + " || Status: " + projeto.get_Status());
		}
		return 1;
	}
	public static int mostrar_Projetos_Em_Elaboracao(List <Projeto> projetos){
		
		Projeto projeto = null;
		int aux, contador=0;
		int total_projetos = projetos.size();
		
		if(total_projetos == 0){
			System.out.println("Não há projetos para listar!");
		}
		
		for(aux = 0; aux < total_projetos; aux++){
			projeto = projetos.get(aux);
			
			if(projeto.get_Status() == "Em Elaboração"){
				contador++;
				System.out.print("\nID: "+ aux +"  || Título: " + projeto.titulo);				
			}
		}
		
		return contador;
	}
	public static void atualizar_Status(List<Colaborador> colaboradores, List<Projeto> projetos){ // Roda todos os projetos procurando quais podem alterar os status
		
		
		try{
			int aux = 0, contador = 0, id = 0;
			int total_projetos = projetos.size();
			Projeto projeto = null;
			
			System.out.println("Selecione o ID do projeto que deseja Começar/Concluir:");
			
			for(aux = 0; aux < total_projetos; aux++){
				projeto = projetos.get(aux);
				
				if(projeto.conferir_Projeto_Prontoparacomecar() && projeto.Consultar_Status() != 3){
					contador++;
					System.out.print("\nID: "+ aux +" Título: " + projeto.titulo + " - ESTÁ PRONTO PARA COMEÇAR!");
				}else if(projeto.conferir_Projeto_Prontoparaconcluir()){
					contador++;
					System.out.print("\nID: "+ aux +" Título: " + projeto.titulo + " - ESTÁ PRONTO PARA CONCLUIR!");
				}
			}
			
			if(contador == 0){
				System.out.println("Desculpe! Não há projetos prontos para Concluir/Começar!");
			}else{
				System.out.print("\nProjeto número: ");
				id = input.nextInt();
				
				projeto = projetos.get(id);
				projeto.alterar_Status();
				
				System.out.println("Status do projeto \"" + projeto.titulo + "\" mudou para "+ projeto.get_Status());
			}		

		}catch(InputMismatchException e){
			System.out.println("\nERRO! Detecção de caractere atípico, por favor, faça novamente!\n");
			input.nextLine();
			
			atualizar_Status(colaboradores, projetos);
			
		}catch(IndexOutOfBoundsException e){
			System.out.println("\nERRO! Selecione corretamente, por favor reenicie o processo novamente!\n");
			input.nextLine();
			
			atualizar_Status(colaboradores, projetos);
		}
		
	}
	public static int checarnome_Colaborador(String nome){
		
		int tamanho,i;
		Colaborador comparar;
		tamanho = colaboradores.size();
		
		for(i=0; i<tamanho; i++){
			comparar = colaboradores.get(i);
			
			if(nome == comparar.nome){
				return 1;
			}
		}
		return 0;
	}
	
	//------------- Métodos Principais ------------------
	public static Colaborador adicionar_Colaborador(){
	
		try{
			String nome, email;
			int tipo,teste;
			
			input = new Scanner(System.in);
			System.out.print("Insira o nome do novo colaborador: ");
			nome = input.nextLine();
			
			teste = checarnome_Colaborador(nome);

			if(teste == 1){
				System.out.println("\n"+ nome +" já faz parte da lista de colaboradores do Projeto!");
				return null;
			}
			
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

		}catch(InputMismatchException e){
			System.out.println("\nERRO! Foi detectado caractere inválido na inserção dos dados, por favor cadastre novamente!\n");
			input.nextLine();
			
			return adicionar_Colaborador();
			
		}
				
	}
	public static Projeto adicionar_Projeto(){
		
		
		try{
			String titulo, agencia_financiadora, objetivo, descricao;
			int data_termino;
			int data_inicio;
			double valor_financiado;
			
			Projeto projetonovo = new Projeto();
			
			input = new Scanner(System.in);
			System.out.print("Insira o título do projeto: ");
			titulo = input.nextLine();
			System.out.print("Agência financiadora do projeto: ");
			agencia_financiadora = input.nextLine();
			System.out.print("Digite o objetivo do Projeto: ");
			objetivo = input.nextLine();
			System.out.print("Descreva o projeto: ");
			descricao = input.nextLine();
			System.out.print("Digite o valor financiado: ");
			valor_financiado = input.nextDouble();
			System.out.print("Insira a data de início do projeto (ano) : ");
			data_inicio = input.nextInt();
			System.out.print("Insira a data de término do projeto (ano) : ");
			data_termino = input.nextInt();
			
			projetonovo.setTitulo(titulo);
			projetonovo.setDataInicio(data_inicio);
			projetonovo.setDataTermino(data_termino);
			projetonovo.setAgenciaFinanciadora(agencia_financiadora);
			projetonovo.setObjetivo(objetivo);
			projetonovo.setDescricao(descricao);
			projetonovo.setValorFinanciado(valor_financiado);
			projetonovo.setStatus(1);
			
			
			
			return projetonovo;
		}catch(InputMismatchException e){
			System.out.println("\nERRO! Foi detectado caractere inválido na inserção dos dados, por favor cadastre novamente!\n");
			input.nextLine();
			
			return adicionar_Projeto();
			
		}

	}
	public static void alocar_Colaborador(List<Colaborador> colaboradores, List<Projeto> projetos){
		
		
		
		try{
			int id_colaborador, id_projeto, confere, teste;
			
			input = new Scanner(System.in);
			if(colaboradores.size() == 0 || projetos.size() == 0){
				System.out.println("Alocação não permitida! Não existem projetos e/ou colaboradores suficientes para prosseguir com a alocação!");
			}else{
				confere = mostrar_Projetos_Em_Elaboracao(projetos);
				if(confere == 0){
					System.out.println("Não existem projetos em elaboração para alocar colaboradores !");
					return;
				}
				System.out.print("\nSelecione o ID do projeto onde o Colaborador será alocado: ");
				id_projeto = input.nextInt();
				
				mostrar_Colaboradores(colaboradores);
				System.out.print("\nSelecione o ID do Colaborador a se alocado: ");
				id_colaborador = input.nextInt();
				
				Colaborador fulano = colaboradores.get(id_colaborador);
				Projeto projeto = projetos.get(id_projeto);
				
				teste =  projeto.checar_Colaborador(fulano);
				
				if(teste == 1){
					System.out.println("\nColaborador ja está alocado no referido projeto!");
					return;
				}
				
				if(fulano.Teste_Aluno_Graduacao()){
					if(fulano.pode_Alocar()){
						fulano.adicionar_Projeto(projeto);
						projeto.adicionar_Colaboradores(fulano);
					}else{
						System.out.println("\nAlocação não permitida ! Aluno participa de mais de dois Projetos \"Em Andamento\"");
					}
				}else{
					fulano.adicionar_Projeto(projeto);
					projeto.adicionar_Colaboradores(fulano);
				}	
			}

		}catch(InputMismatchException e){
			System.out.println("\nERRO! Detecção de caractere atípico, por favor, faça novamente!\n");
			input.nextLine();
			
			alocar_Colaborador(colaboradores, projetos);
			
		}catch(IndexOutOfBoundsException e){
			System.out.println("\nERRO! Selecione corretamente, por favor reenicie o processo novamente!\n");
			input.nextLine();
			
			alocar_Colaborador(colaboradores, projetos);
		}
		
	}
	public static int adicionar_Orientacao_Publicacao(List<Colaborador> colaboradores, List<Projeto> projetos){
		
		
		
		try{
			int escolha = 0, id_professor = 0, id_aluno=0, ano, id,	id_autor, comando = 1, aux = 0, teste;
			Projeto projeto = null;
			Colaborador fulano = null;
			Colaborador sicrano = null;
			String titulos, conferencia;
			
			teste = colaboradores.size();
			
			if(teste == 0){
				System.out.println("Antes de continuar, adicione colaboradores no laboratório!");
				return 0;
			}
			
			System.out.print("\n------------------------\nSelecione:\n1- Orientação\n2- Publicação\n------------------------\nEscolha:");
			
			escolha = input.nextInt();
			
			input.nextLine();
			
			
			
			
			if(escolha == 1){
				aux = escolha;
				teste = mostrar_Professores(colaboradores);
				if(teste==0){
					System.out.println("Não existem Professores para orientação!");
					return 0;
				}
				System.out.print("\nDigite o ID do professor: ");
				id_professor = input.nextInt();
				
				System.out.println("\n\n");
				teste = mostrar_Alunos(colaboradores,id_professor);
				if(teste==0){
					System.out.println("Não existem Alunos para serem orientados!");
					return 0;
				}
				System.out.print("\nDigite o ID do aluno: ");
				id_professor = input.nextInt();
				fulano = colaboradores.get(id_professor);
				sicrano = colaboradores.get(id_aluno);
				
				fulano.adicionar_Orientacao(sicrano);
				System.out.println("\nOrientação adicionada com sucesso!");
			}else if(escolha == 2){
				aux = escolha;
				
				Publicacoes publicacao = new Publicacoes();
				
				System.out.print("\nDigite o título da Publicação: ");
				titulos = input.nextLine();
				System.out.print("Digite a conferência onde foi publicada: ");
				conferencia = input.nextLine();
				System.out.print("Digite o ano de publicação: ");
				ano = input.nextInt();
				
				publicacao.set_Titulo(titulos);
				publicacao.set_Conferencia(conferencia);
				publicacao.set_Ano(ano);
				
				escolha = 3; // para entrar no while
				while(escolha < 1 || escolha > 2){
				
					System.out.print("\nDeseja associar a um projeto?\n1- Sim\n2- Não\n");
					escolha = input.nextInt();
					
					if(escolha == 1){
						teste = mostrar_Projetos(projetos);
						if(teste == 0){
							System.out.println("\nPor favor primeiro cadastre um projeto para depois adicionar a publicação!");
							return 0;
						}
						System.out.print("\nID do projeto a ser associado: ");
						id = input.nextInt();
						projeto = projetos.get(id);
						
						if(projeto.Consultar_Status() == 3){
							publicacao.set_ProjetoAssociado(projeto);	
							projeto.adicionar_Publicacao(publicacao);
						}else{
							System.out.print("\nProjeto selecionado não está em andamento, associação proibida!\n");
						}
					}else if(escolha == 2){
						break;
					}else{
						System.out.println("\nSelecione uma escolha válida!");
					}
				}

				
				while(comando == 1){
					mostrar_Colaboradores(colaboradores);
					System.out.print("\nSelecione o ID do autor: ");
					id_autor = input.nextInt();
						
					sicrano = colaboradores.get(id_autor);
						
					publicacao.adicionar_Colaborador(sicrano);
					sicrano.adicionar_Publicacao(publicacao);
					
					comando = 3;
						while(comando<0 || comando>1){
							System.out.print("Deseja adicionar outro autor?\n"
									+ "1-Sim\n"
									+ "0-Não\n"
									+ "Escolha: ");
							comando = input.nextInt();	
							if(comando<0 || comando>1){
								System.out.println("\nInsira um comando válido!");
							}
						}
				}
				
				System.out.println("\nPublicação adicionada com sucesso!");
			}else{
				System.out.println("Entrada inválida!");
			}
			
		return aux;	

		}catch(InputMismatchException e){
			System.out.println("\nERRO! Detecção de caractere atípico, por favor, faça novamente!\n");
			input.nextLine();
			
			return adicionar_Orientacao_Publicacao(colaboradores, projetos);
			
		}catch(IndexOutOfBoundsException e){
			System.out.println("\nERRO! Selecione corretamente, por favor reenicie o processo novamente!\n");
			input.nextLine();
			
			return adicionar_Orientacao_Publicacao(colaboradores, projetos);
		}
	}
	public static void detalhes_Projeto(List<Projeto> projetos){
		
		try{
			int escolha=0,size=0;
			Projeto proj_aux;
			
			size = projetos.size();
			
			if(size == 0){
				System.out.println("Ainda não existem projetos no laboratório!");
			}else{
				mostrar_Projetos(projetos);
				System.out.print("\nSelecione o ID do projeto no qual deseja consultar: ");
				
				escolha = input.nextInt();
				
				if(escolha < 0 || escolha >= size){
					System.out.println("Entrada inválida!");
				}else{
					proj_aux = projetos.get(escolha);
					proj_aux.mostrar_DadosBasicos();
				}
			}

		}catch(InputMismatchException e){
			System.out.println("\nERRO! Detecção de caractere atípico, por favor selecione um projeto!\n");
			input.nextLine();
			
			detalhes_Projeto(projetos);
			
		}catch(IndexOutOfBoundsException e){
			System.out.println("\nERRO! Selecione corretamente, por favor reenicie o processo novamente!\n");
			input.nextLine();
			
			detalhes_Projeto(projetos);
		}
		
	}
	public static void detalhes_Colaborador(List<Colaborador> colaboradores){
		
		try{
			int escolha=0,size=0;
			Colaborador proj_aux;
			
			size = colaboradores.size();
			
			if(size == 0){
				System.out.println("Ainda não existem colaboradores no laboratório!");
			}else{
				mostrar_Colaboradores(colaboradores);
				System.out.print("\nSelecione o ID do colaborador no qual deseja consultar: ");
				
				escolha = input.nextInt();
				
				if(escolha < 0 || escolha >= size){
					System.out.println("Entrada inválida!");
				}else{
					proj_aux = colaboradores.get(escolha);
					proj_aux.mostrar_DadosBasicos();
				}
			}
		}catch(InputMismatchException e){
			System.out.println("\nERRO! Detecção de caractere atípico, por favor selecione um colaborador!\n");
			input.nextLine();
			
			detalhes_Colaborador(colaboradores);
			
		}
	}

	//---------------------------------------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int contagem_Orientacoes = 0;
		int contagem_Publicacoes = 0;
		int comando = 1, aux = 0;
		input = new Scanner(System.in);
		colaboradores = new ArrayList<Colaborador>();
		projetos = new ArrayList<Projeto>();
		
		
		
		
		
		while(comando != 0){
			
			System.out.print("\n\n----------------------------------------------------\n"
                                + "Seja bem vindo!\nSelecione uma das opções abaixo:\n\n"
					+ "1- Alocar Colaborador\n"         //feito - CATCHED
					+ "2- Alterar Status\n"		   		//feito - CATCHED
					+ "3- Inclusão de Publicação\\Orientação\n"    //feito - CATCHED
					+ "4- Consultar Colaborador\n"     	//feito - CATCHED
					+ "5- Consultar Projeto\n"		   	//feito - CATCHED
					+ "6- Mostrar relatório do Laboratório\n" //feito - CATCHED
					+ "7- Adicionar Colaborador\n"      //feito - CATCHED
					+ "8- Adicionar Projeto\n"			//feito - CATCHED
					+ "9- Mostrar Colaboradores\n"		//feito - CATCHED
					+ "10- Mostrar Projetos\n"			//feito - CATCHED
					+ "Aperte '0' para sair !\n"		//feito - CATCHED
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
					alocar_Colaborador(colaboradores, projetos);
					break;
				
				case 2:
					System.out.println("Alteração de Status\n-----------------------------\n");
					atualizar_Status(colaboradores, projetos);
					break;
					
				case 3:
					System.out.println("Inclusão de Publicação\n-----------------------------\n");
					aux = adicionar_Orientacao_Publicacao(colaboradores, projetos);
					if(aux == 1){
						contagem_Orientacoes++;
					}else if(aux == 2){
						contagem_Publicacoes++;
					}
					break;
				
				case 4:
					System.out.println("Consulta de Colaborador\n-----------------------------\n");
					detalhes_Colaborador(colaboradores);
					break;
					
				case 5:
					System.out.println("Consulta de Projeto\n-----------------------------\n");
					detalhes_Projeto(projetos);
					break;
				
				case 6:
					System.out.println("Exibir Relatório do Laboratório\n-----------------------------\n\n");
					relatorio_Laboratorio(projetos, colaboradores, contagem_Orientacoes, contagem_Publicacoes);
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
