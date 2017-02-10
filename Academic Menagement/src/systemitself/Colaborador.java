package systemitself;

import java.util.ArrayList;
import java.util.Collections;


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
	public void print_ProdAcademica(){
		
		Publicacoes publi_aux = null;
		int aux;
		int total_participantes = publicacoes.size();
		
		
		for(aux = 0; aux < total_participantes; aux++){
			publi_aux = publicacoes.get(aux);
			
			System.out.print("Título: " + publi_aux.titulo + "|| Ano: " + publi_aux.ano + "\n");
		}
	}
	public void print_Historico(){
		
		Projeto proj_aux = null;
		int aux;
		int total_participantes = historico.size();
		
		
		for(aux = 0; aux < total_participantes; aux++){
			proj_aux = historico.get(aux);
			
			if(proj_aux.status == 5){
				System.out.print("Título: " + proj_aux.titulo + "|| Ano de término: " + proj_aux.data_termino + "\n");	
			}	
		}

		System.out.print("Projetos em Andamento: \n");
		
		for(aux = 0; aux < total_participantes; aux++){
			proj_aux = historico.get(aux);
			
			if(proj_aux.status == 3){
				System.out.print("Título: " + proj_aux.titulo + "|| Ano de término: " + proj_aux.data_termino + "\n");	
			}	
		}
		
	}
	public void bubble_Historico(){
		int i=0, j=0;
		Projeto projeto_1 = null, projeto_2 = null;
		
		for (i = historico.size(); i >= 1; i--) {
            for (j = 1; j < i; j++) {
            	projeto_1 = historico.get(j-1);
            	projeto_2 = historico.get(j);
                if (projeto_1.data_termino < projeto_2.data_termino) {
                    Collections.swap(historico, j-1, j);
                }
            }
        }
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
	public void mostrar_DadosBasicos(){
		System.out.print("\nDADOS DO COLABORADOR"
				+ "\n--------------------\n"
				+ "Nome: " + this.nome + "\n"
						+ "E-mail: " + this.email + "\n");
		
		if(publicacoes.size() == 0){
			System.out.println("Produção Acadêmica: Atualmente não existem publicações feitas pelo colaborador!");
		}else{
			System.out.print("Produção Acadêmica: \n");
			print_ProdAcademica();
		}
		
		if(historico.size() == 0){
			System.out.println("Histórico de Projetos: Atualmente não existem projetos alocados para o colaborador!");			
		}else{
			System.out.println("Projetos finalizados: ");
			bubble_Historico();
			print_Historico();
		}
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
