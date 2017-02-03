package systemitself;

public class AlunoMestrado extends Colaborador {

	
	
	public String retorna_tipo(){
		String tipo = " é um Aluno de Mestrado!";
		
		return tipo;
	}
	
	@Override
	public boolean Teste_Aluno_Mestrado(){
		
		return true;
	}
}
