package pacote;

import java.util.ArrayList;
import java.util.Date;

public class Professores extends Cliente{
	private final String ID;
	private String aulas;
	private int ano_ing; //ano de ingresso
	
	//Construtor
	public Professores(String nome, String telefone, String email, String CPF, Date dataNasc,
			ArrayList<Emprestimo> listaEmprestimos, ArrayList<Reserva> listaReservasItens, 
			String ID, String aulas, int ano_ing) {
		super(nome, telefone, email, CPF, dataNasc, listaEmprestimos, listaReservasItens);
		this.ID = ID;
		this.aulas = aulas;
		this.ano_ing = ano_ing;
	}

	//Getters e setters
	public String getID() {
		return ID;
	}
	public String getAulas() {
		return aulas;
	}
	public void setAulas(String aulas) {
		this.aulas = aulas;
	}
	public int getAnoIng() {
		return ano_ing;
	}
	public void setAnoIng(int ano_ing) {
		this.ano_ing = ano_ing;
	}
	
}
