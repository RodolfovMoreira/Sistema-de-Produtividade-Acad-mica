package systemitself;

import java.util.List;

public class Projeto {

	String titulo;
	String data_inicio;
	String data_termino;
	String agencia_financiadora;
	String objetivo;
	String descricao;
	double valor_financiado;
	List<Colaborador> participantes; // Obrigado um professor
	int status; // 1- Em elaboração  2- Em andamento  3- Concluído
	
	public boolean Teste_Professor(Colaborador pesquisador){
		
		return false;
	}
	
}
