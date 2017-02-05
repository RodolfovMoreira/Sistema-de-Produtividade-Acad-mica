package systemitself;

import java.util.ArrayList;

public class Publicacoes {
	
	String titulo;
	String conferencia_publicada;
	int ano;
	Projeto projeto_associado;
	private static ArrayList<Colaborador> autores = new ArrayList<Colaborador>();
	
	
	public void set_Titulo(String titulo){
		this.titulo = titulo;
	}
	public void set_Conferencia(String conferencia){
		this.conferencia_publicada = conferencia;
	}
	public void set_Ano(int ano){
		this.ano = ano;
	}
	public void set_ProjetoAssociado(Projeto projeto){
		this.projeto_associado = projeto;
	}
	
	public void adicionar_Colaborador(Colaborador fulano){
		autores.add(fulano);
	}
		
}
