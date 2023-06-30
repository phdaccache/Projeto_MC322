package sistema;

import java.util.StringJoiner;

public class Revista extends Item {
	// Atributos
	private int edicao;
	private String instituicao;
	private String assuntos;
	private final int ISSN;
	
	//Construtor
	public Revista(int code, int qtdDePaginas, String titulo, String autor, int ano, int edicao, String instituicao, String assuntos, int ISSN) {
		super(code, qtdDePaginas, titulo, autor, ano);
		this.edicao = edicao;
		this.instituicao = instituicao;
		this.assuntos = assuntos;
		this.ISSN = ISSN;
	}

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

	// Getters e Setters
	public int getEdicao() {
		return this.edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public String getInstituicao() {
		return this.instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getAssuntos() {
		return this.assuntos;
	}

	public void setAssuntos(String assuntos) {
		this.assuntos = assuntos;
	}

	public int getISSN() {
		return this.ISSN;
	}
}