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
	int status; // 1- Em elaboração 2- Pronto para Inicar(Info, básicas Preenchidas) 3- Em andamento  4- Pronto para Concluir 5- Concluído
	
	public int Consultar_Status(){
		return this.status;
	}
	
}
