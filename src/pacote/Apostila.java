package pacote;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Apostila extends Item{
	private String disciplina;
	private String instituicao;
	
	//Construtor

	public Apostila(int code, int qtdDePaginas, String status, String titulo, String autores, ArrayList<Reserva> listaReservas, int ano, String disciplina, String instituicao) {
		super(code, qtdDePaginas, status, titulo, autores, listaReservas, ano);
		this.disciplina = disciplina;
		this.instituicao = instituicao;
	}

	//Getters e setters
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina= disciplina;
	}
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao= instituicao;
	}

	//Metodos

	//toString
	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");
		joiner.add(super.toString());
		if (disciplina != null) {
	        joiner.add("Disciplina: " + this.disciplina);
	    } else {
	        joiner.add("Disciplina: Não especificada");
	    }
	    
	    if (instituicao != null) {
	        joiner.add("Instituição: " + this.instituicao);
	    } else {
	        joiner.add("Instituição: Não especificada");
	    }
		return joiner.toString();
	}

}