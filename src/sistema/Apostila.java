package sistema;

import java.util.StringJoiner;

public class Apostila extends Item {
	// Atributos
	private String disciplina;
	private String instituicao;
	
	//Construtor
	public Apostila(int quantidade, String titulo, String autor, int ano, String disciplina, String instituicao) {
		super(quantidade, titulo, autor, ano);
		this.disciplina = disciplina;
		this.instituicao = instituicao;
	}

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


	// Getters e Setters
	public String getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getInstituicao() {
		return this.instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
}