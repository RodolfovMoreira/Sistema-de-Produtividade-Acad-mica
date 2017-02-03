package systemitself;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Colaborador {

	String nome;
	String email;
	private static ArrayList<Publicacoes> publicacoes;
	private static ArrayList<Projeto> historico;
	private Scanner input;
	
	//------------- Métodos Auxiliares ------------------	
	public void setName(String Nome){
		
		this.nome = Nome;
	}	
	public void setEmail(String email){
		
		this.email = email;
	}

	
	//------------- Métodos Principais ------------------
	public String retorna_tipo(){
		String tipo = " sou um Colaborador!";
		
		return tipo;
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
