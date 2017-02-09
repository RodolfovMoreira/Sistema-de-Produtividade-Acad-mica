package systemitself;

import java.util.ArrayList;


public class Colaborador {

	String nome;
	String email;
	private static ArrayList<Publicacoes> publicacoes = new ArrayList<Publicacoes>();
	private static ArrayList<Projeto> historico = new ArrayList<Projeto>();
	public static ArrayList<Colaborador> orientacoes = new ArrayList<Colaborador>();
	
	//------------- Métodos Auxiliares ------------------	
	public void setName(String Nome){
		
		this.nome = Nome;
	}	
	public void setEmail(String email){
		
		this.email = email;
	}
	
	public Professor get_Professor(int id){
		Professor fulano = new Professor();
		return fulano;
	}
	public void adicionar_Orientacao(Colaborador aluno){
		
		orientacoes.add(aluno);
		
	}
	//------------- Métodos Principais ------------------
	public String retorna_tipo(){
		String tipo = " sou um Colaborador!";
		
		return tipo;
	}
	public boolean pode_Alocar(){   // retorna TRUE caso o AG possa ser alocado
		
		int contagem = 0, aux;
		int total_projetos = historico.size();
		Projeto teste = null;
		
		if(total_projetos == 0){
			return true;
		}
		
		for(aux = 0; aux < total_projetos; aux++){
			teste = historico.get(aux);
			if(teste.Consultar_Status() == 2){
				contagem++;
			}
		}
		
		if(contagem > 2){
			return false;
		}else{
			return true;
		}
	}
	public void adicionar_Projeto(Projeto projeto){
		
		historico.add(projeto);
	}
	public void adicionar_Publicacao(Publicacoes publicacao){
		Colaborador.publicacoes.add(publicacao);
	}
	//-------------- Testes e Consultas -----------------
	public String get_Name(){
		return this.nome;
	}
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
