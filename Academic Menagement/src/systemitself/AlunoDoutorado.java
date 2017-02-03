package systemitself;

public class AlunoDoutorado extends Colaborador{

	
	public String retorna_tipo(){
		String tipo = " é um Aluno de Doutorado!";
		
		return tipo;
	}
	
	@Override
	public boolean Teste_Aluno_Doutorado(){
		
		return true;
	}
}
