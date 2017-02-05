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
	int status; //feito // 1- Em elabora��o 2- Pronto para Inicar(Info, b�sicas Preenchidas) 3- Em andamento  4- Pronto para Concluir 5- Conclu�do
	
	public int Consultar_Status(){
		return this.status;
	}
	
	//------------- M�todos Auxiliares ------------------
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
			status = "Em Elabora��o";
		}else if(this.status == 2){
			status = "Em Andamento";
		}else if(this.status == 3){
			status = "Conclu�do";
		}
		
		return status;
	}
	//------------- M�todos Principais ------------------
	
	public void adicionar_Colaboradores(Colaborador fulano){
		
		participantes.add(fulano);
		System.out.print(fulano.nome + " foi alocado(a) com sucesso no projeto: \"" + this.titulo + "\"");
	}

}
