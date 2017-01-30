package systemitself;

import java.util.List;

public class Colaborador {

	String nome;
	String email;
	Publicacoes publicacoes;
	List <Publicacoes> historico;
	
	
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
	
	public boolean Alocar_Colaborador(Projeto pesquisa){ // Retorna TRUE caso colaborador for adicionado com sucesso!
		
		if(Permitir_alocacao(pesquisa)){
			
			pesquisa.participantes.add(this);
			return true;
		}else{
			return false;
		}
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


}
