package systemitself;

public class Professor extends Colaborador{
	
	
	public String retorna_tipo(){
		String tipo = " � um Professor.";
		
		return tipo;
	}
	
	@Override
	public boolean Teste_Professor(){
		
		return true;
	}
}
