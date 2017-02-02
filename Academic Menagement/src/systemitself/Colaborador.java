package systemitself;

import java.util.List;
import java.util.Scanner;


public class Colaborador {

	String nome;
	String email;
	List <Publicacoes> publicacoes;
	List <Projeto> historico;
	private Scanner input;
	
	//------------- Métodos Auxiliares ------------------
	public String retorna_nomezinho(){
		String tipo = "EU SOU MÉDICO";
		
		return tipo;
	}
	
	public boolean Projeto_Contem_Professor(Projeto pesquisa){
		
		int aux;
		int total_participantes = pesquisa.participantes.size();
		
		for(aux = 0; aux < total_participantes; aux++){
			if(pesquisa.participantes.get(aux).Teste_Professor()){
				return true;
			}else if(aux-1 == total_participantes){
				return false;
			}
		}
		
		if(total_participantes == 0 && this.Teste_Professor()){
			return true;
		}
		return false;
	}
	
	public boolean Permitir_alocacao(Projeto pesquisa){
		
		if(Projeto_Contem_Professor(pesquisa)){
			if(this.Teste_Aluno_Graduacao()){
				if(this.Consulta_Projetos_AlunoGraduacao() <= 2){
					return true;
				}else{
					System.out.println("ERRO! Colaborador já está presente em dois projetos!");
					return false;
				}
			}else{
				return true;
			}
		}else{
			System.out.println("ERRO! Por favor, adicione um professor no projeto para depois poder alocar colaboradores!");
			return false;
		}
	}
	
	public void setName(String Nome){
		
		this.nome = Nome;
	}
	
	public void setEmail(String email){
		
		this.email = email;
	}

	public Colaborador criar_AlGraduacao(String nome, String email){
		
		AlunoGraduacao fulano = new AlunoGraduacao();
		fulano.setEmail(email);
		fulano.setName(nome);
		
		return fulano;
	}

	public Colaborador criar_AlMestrado(String nome, String email){
		
		AlunoMestrado fulano = new AlunoMestrado();
		fulano.setEmail(email);
		fulano.setName(nome);
		
		return fulano;
	}

	public Colaborador criar_AlDoutorado(String nome, String email){
		
		AlunoDoutorado fulano = new AlunoDoutorado();
		fulano.setEmail(email);
		fulano.setName(nome);
		
		return fulano;
	}

	public Colaborador criar_Professor(String nome, String email){
		
		Professor fulano = new Professor();
		fulano.setEmail(email);
		fulano.setName(nome);
		
		return fulano;
	}

	public Colaborador criar_Pesquisador(String nome, String email){
		
		Pesquisador fulano = new Pesquisador();
		fulano.setEmail(email);
		fulano.setName(nome);
		
		return fulano;
	}
	
	//------------- Métodos Principais ------------------
	
	public void alocar_Colaborador(Projeto pesquisa){ // Retorna TRUE caso colaborador for adicionado com sucesso!
		
		if(Permitir_alocacao(pesquisa)){
			if(pesquisa.Consultar_Status() <= 2){
				
				pesquisa.participantes.add(this);
				System.out.println("Colaborador Alocado com Sucesso!");				
			}else{
				System.out.println("ERRO! Pesquisa já está em processo avançado para poder adicionar colaboradores!");
			}
		}
	}
	
	public void adicionar_Historico(Projeto pesquisa){
		
		this.historico.add(pesquisa);
		System.out.println("Projeto adicionado com sucesso no histórico!");
	}
	
	public void adicionar_Publicacao(Publicacoes publicacao){
		
		this.publicacoes.add(publicacao);
		System.out.println("Publicação adicionada com sucesso!");
	}

	public Colaborador Colaborador(String nome, String email, int tipo){
		
		/*String nome, email;
		int tipo;
		
		input = new Scanner(System.in);
		System.out.print("Insira o nome do novo colaborador: ");
		nome = input.nextLine();
		
		System.out.print("Insira o e-mail do novo colaborador: ");
		email = input.nextLine();
		
		System.out.println("Selecione o tipo de Colaborador: \n1- Aluno de Graduação            2- Aluno de Mestrado\n3- Aluno de Doutorado"
				+ "            4- Professor\n"
				+ "5-Pesquisador");
		
		tipo = input.nextInt();*/
		
		if(tipo == 1){
			return criar_AlGraduacao(nome, email);
		}else if(tipo == 2){
			return criar_AlMestrado(nome, email);
		}else if(tipo == 3){
			return criar_AlDoutorado(nome, email);
		}else if(tipo == 4){
			return criar_Professor(nome, email);
		}else{
			return criar_Pesquisador(nome, email);
		}
	}

	
	//-------------- Testes e Consultas -----------------
	
	public boolean Teste_Professor() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean Teste_Aluno_Graduacao() {
		// TODO Auto-generated method stub
		return false;
	}

	public int Consulta_Projetos_AlunoGraduacao() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean Teste_Aluno_Mestrado() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean Teste_Aluno_Doutorado() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean Teste_Pesquisador() {
		// TODO Auto-generated method stub
		return false;
	}


}
