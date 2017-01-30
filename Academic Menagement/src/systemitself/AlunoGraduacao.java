package systemitself;

public class AlunoGraduacao extends Colaborador {

	int participacao_projetos;
	
	@Override
	public boolean Teste_Aluno_Graduacao(){
		
		return true;
	}
	@Override
	public int Consulta_Projetos_AlunoGraduacao(){
		return this.participacao_projetos; 
	}
}
