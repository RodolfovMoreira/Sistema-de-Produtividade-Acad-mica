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
	int status; // 1- Em elabora��o 2- Pronto para Inicar(Info, b�sicas Preenchidas) 3- Em andamento  4- Pronto para Concluir 5- Conclu�do
	
	public int Consultar_Status(){
		return this.status;
	}
	
}
