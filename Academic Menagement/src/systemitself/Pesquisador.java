package systemitself;

public class Pesquisador extends Colaborador{
	
	
	
	public String retorna_tipo(){
		String tipo = " � um Pesquisador";
		
		return tipo;
	}
	
	@Override
	public boolean Teste_Pesquisador(){
		
		return true;
	}
}
