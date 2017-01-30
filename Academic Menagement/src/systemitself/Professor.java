package systemitself;

import java.util.List;

public class Professor extends Colaborador{
	
	List<Colaborador> orientacoes;
	
	
	public void Adicionar_Orientacao(Colaborador aluno){
		
		orientacoes.add(aluno);
		
	}
	
	@Override
	public boolean Teste_Professor(){
		
		return true;
	}
}
