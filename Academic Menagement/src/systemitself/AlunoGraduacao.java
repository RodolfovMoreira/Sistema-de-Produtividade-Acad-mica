package systemitself;

public class AlunoGraduacao extends Colaborador {

	int participacao_projetos;
	
	public String retorna_tipo(){
		String tipo = " � um Aluno de Gradua��o!";
		
		return tipo;
	}
	
	
	@Override
	public boolean Teste_Aluno_Graduacao(){
		
		return true;
	}
	@Override
	public int Consulta_Projetos_AlunoGraduacao(){
		return this.participacao_projetos; 
	}
}
