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
	private static ArrayList<Publicacoes> publicacoes = new ArrayList<Publicacoes>();
	int status; //feito // 1- Em elaboração 2- Pronto para Inicar(Info, básicas Preenchidas) 3- Em andamento  4- Pronto para Concluir 5- Concluído
	

	
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

	public int Consultar_Status(){
		return this.status;
	}
	public String get_Status(){
		
		String status = null;
		
		if(this.status == 1){
			status = "Em Elaboração";
		}else if(this.status == 3){
			status = "Em Andamento";
		}else if(this.status == 5){
			status = "Concluído";
		}
		
		return status;
	}
	public boolean conferir_Projeto_Prontoparacomecar(){
		
		Colaborador fulano = null;
		int flag = 0, aux = 0;
		int total_colaboradores = Projeto.participantes.size();
		
		for(aux = 0; aux < total_colaboradores; aux++){
			fulano = Projeto.participantes.get(aux);
			if(fulano.Teste_Professor()){
				flag = 1;
			}
		}
		
		if(flag == 1){
			return true;
		}else{
			return false;
		}
		
	}
	public boolean conferir_Projeto_Prontoparaconcluir(){
		
		int total_publicacoes = Projeto.publicacoes.size();
		
		if(total_publicacoes > 0){
			return true;
		}else{
			return false;
		}

	}
	public void alterar_Status(){
		
		if(this.status == 1){
			setStatus(3);
		}else if(this.status == 3){
			setStatus(5);
		}
	}
	
	//------------- Métodos Principais ------------------
	
	public void adicionar_Colaboradores(Colaborador fulano){
		
		participantes.add(fulano);
		System.out.print(fulano.nome + " foi alocado(a) com sucesso no projeto: \"" + this.titulo + "\"");
	}
	public void adicionar_Publicacao(Publicacoes publicacao){
		Projeto.publicacoes.add(publicacao);
	}
}
