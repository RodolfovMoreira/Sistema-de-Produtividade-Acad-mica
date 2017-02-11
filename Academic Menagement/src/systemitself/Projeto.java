package systemitself;

import java.util.ArrayList;
import java.util.Collections;

public class Projeto {

	String titulo;			//feito
	int data_inicio;		//feito
	int data_termino;	//feito
	String agencia_financiadora;	//feito
	String objetivo;	//feito
	String descricao;	//feito
	double valor_financiado;	//feito
	private  ArrayList<Colaborador> participantes = new ArrayList<Colaborador>(); // Obrigado um professor
	private  ArrayList<Publicacoes> publicacoes = new ArrayList<Publicacoes>();
	int status; //feito // 1- Em elaboração 2- Pronto para Inicar(Info, básicas Preenchidas) 3- Em andamento  4- Pronto para Concluir 5- Concluído
	

	
	//------------- Métodos Auxiliares ------------------
	public void setTitulo(String titulo){
		
		this.titulo = titulo;
	}	
	public void setDataInicio(int datainicio){
		
		this.data_inicio = datainicio;
	}
	public void setDataTermino(int datatermino){
		
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
		int total_colaboradores = this.participantes.size();
		
		for(aux = 0; aux < total_colaboradores; aux++){
			fulano = participantes.get(aux);
			if(fulano.retorna_tipo() == " é um Professor."){
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
		
		int total_publicacoes = this.publicacoes.size();
		
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
	public void print_Participantes(){
		
		Colaborador fulano = null;
		int aux;
		int total_participantes = participantes.size();
		
		for(aux = 0; aux < total_participantes; aux++){
			fulano = participantes.get(aux);
			
			System.out.print(fulano.get_Name() + "\n");
	
		}
	}
	public void bubble_OrderPubli(){
		
		int i=0, j=0;
		Publicacoes projeto_1 = null, projeto_2 = null;
		
		for (i = publicacoes.size(); i >= 1; i--) {
            for (j = 1; j < i; j++) {
            	projeto_1 = publicacoes.get(j-1);
            	projeto_2 = publicacoes.get(j);
                if (projeto_1.ano < projeto_2.ano) {
                    Collections.swap(publicacoes, j-1, j);
                }
            }
        }
	}
	public void print_Publicacoes(){
	
		Publicacoes publi_aux = null;
		int aux;
		int total_participantes = publicacoes.size();
		
		
		for(aux = 0; aux < total_participantes; aux++){
			publi_aux = publicacoes.get(aux);
			
			System.out.print("Título: " + publi_aux.titulo + "|| Ano: " + publi_aux.ano + "\n");
		}
	}

	//------------- Métodos Principais ------------------
	public int checar_Colaborador(Colaborador fulano){
		
		int tamanho,i;
		Colaborador comparar;
		tamanho = participantes.size();
		
		for(i=0; i<tamanho; i++){
			comparar = participantes.get(i);
			
			if(fulano.nome == comparar.nome){
				return 1;
			}
		}
		return 0;
	}
	public void mostrar_DadosBasicos(){
		
		System.out.print("\nDADOS DO PROJETO"
				+ "\n--------------------\n"
				+ "Título: " + this.titulo + "\n"
						+ "Data de Início: " + this.data_inicio + "\n"
								+ "Data de Término: " + this.data_termino + "\n"
										+ "Agência Financiadora: " + this.agencia_financiadora + "\n"
												+ "Objetivo: " + this.objetivo + " \n"
														+ "Descrição: " + this.descricao + "\n"
																+ "Valor Financiado: " + this.valor_financiado + "\n"
																		+ "Status: " + get_Status() + "\n" );
		
		if(participantes.size() == 0){
			System.out.println("Participantes: Atualmente não há participantes no projeto");
		}else{
			System.out.print("Colaboradores alocados: \n");
			print_Participantes();
		}
		
		if(publicacoes.size() == 0){
			System.out.println("Produção acadêmica: Atualmente não há publicações provenientes do projeto");			
		}else{
			System.out.print("Produção Acadêmica: \n");
			bubble_OrderPubli();
			print_Publicacoes();
		}
		
	}
	public void adicionar_Colaboradores(Colaborador fulano){
		
		this.participantes.add(fulano);
		System.out.print(fulano.nome + " foi alocado(a) com sucesso no projeto: \"" + this.titulo + "\"");
	}
	public void adicionar_Publicacao(Publicacoes publicacao){
		this.publicacoes.add(publicacao);
	}
}
