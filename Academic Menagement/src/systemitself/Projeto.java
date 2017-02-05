package systemitself;

import java.util.ArrayList;

public class Projeto {

	String titulo;			//feito
	String data_inicio;		//feito
	String data_termino;	//feito
	String agencia_financiadora;	//feito
	String objetivo;	//feito
	String descricao;	//feito
	double valor_financiado;	//feito
	private static ArrayList<Colaborador> participantes = new ArrayList<Colaborador>(); // Obrigado um professor
	int status; //feito // 1- Em elaboração 2- Pronto para Inicar(Info, básicas Preenchidas) 3- Em andamento  4- Pronto para Concluir 5- Concluído
	
	public int Consultar_Status(){
		return this.status;
	}
	
	//------------- Métodos Auxiliares ------------------
	public void setTitulo(String titulo){
		
		this.titulo = titulo;
	}	
	public void setDataInicio(String datainicio){
		
		this.data_inicio = datainicio;
	}
	public void setDataTermino(String datatermino){
		
		this.data_termino = datatermino;
	}
	public void setAgenciaFinanciadora(String agenciafinanciadora){
		
		this.agencia_financiadora = agenciafinanciadora;
	}
	public void setObjetivo(String objetivo){
		
		this.objetivo = objetivo;
	}
	public void setDescricao(String descricao){
		
		this.descricao = descricao;
	}
	public void setValorFinanciado(Double valorfinanciado ){
		
		this.valor_financiado = valorfinanciado;
	}	
	public void setStatus(int status){
		
		this.status = status;
	}

	public String get_Status(){
		
		String status = null;
		
		if(this.status == 1){
			status = "Em Elaboração";
		}else if(this.status == 2){
			status = "Em Andamento";
		}else if(this.status == 3){
			status = "Concluído";
		}
		
		return status;
	}
	//------------- Métodos Principais ------------------
	
	public void adicionar_Colaboradores(Colaborador fulano){
		
		participantes.add(fulano);
		System.out.print(fulano.nome + " foi alocado(a) com sucesso no projeto: \"" + this.titulo + "\"");
	}

}
