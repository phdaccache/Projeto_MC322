package pacote;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Revista extends Item{
	private int edicao;
	private String instituicao;
	private ArrayList<String> assuntos;
	private final int ISSN;
	
	//Construtor


	public Revista(int code, int qtdDePaginas, String status, String titulo, String autores, ArrayList<Reserva> listaReservas, int ano, int edicao, String instituicao, ArrayList<String> assuntos, int ISSN) {
		super(code, qtdDePaginas, status, titulo, autores, listaReservas, ano);
		this.edicao = edicao;
		this.instituicao = instituicao;
		this.assuntos = assuntos;
		this.ISSN = ISSN;
	}

	//Getters e setters
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	public ArrayList<String> getAssuntos() {
		return assuntos;
	}
	public void setAssuntos(ArrayList<String> assuntos) {
		this.assuntos = assuntos;
	}
	public int getISSN() {
		return ISSN;
	}

	//Metodos


	//toString
	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");
		joiner.add(super.toString());
		if (edicao != -1) {
		    joiner.add("Edição: " + this.edicao);
		} else {
			joiner.add("Edição: Não especificada");
		}
		if (instituicao != null) {
		    joiner.add("Intituição: " + this.instituicao);
		} else {
			joiner.add("Intituição: Não especificada");
		}
		if (assuntos != null) {
		    joiner.add("Assuntos: " + this.assuntos);
		} else {
			joiner.add("Assuntos: Não especificados");
		}
		if (ISSN != -1) {
		    joiner.add("ISSN: " + this.ISSN);
		} else {
			joiner.add("ISSN: Não especificado");
		}
		return joiner.toString();
	}

}
