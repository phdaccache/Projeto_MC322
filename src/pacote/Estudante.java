package pacote;

import java.time.LocalDate;
import java.util.StringJoiner;

public class Estudante extends Cliente {
	// Atributos
	private final String Matricula;
	private String curso;
	private int ano_grad; // ano limite de graduacao
	
	//Construtor
	public Estudante(Biblioteca biblioteca, String CPF, String nome, String telefone, String email, LocalDate dataNasc, String senha, String assinatura, String matricula, String curso, int ano_grad) {
		super(biblioteca, CPF, nome, telefone, email, dataNasc, senha, assinatura);
		this.Matricula = matricula;
		this.curso = curso;
		this.ano_grad = ano_grad;
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");
		joiner.add(super.toString());
		if (Matricula != null) {
		    joiner.add("Matrícula: " + this.Matricula);
		} else {
			joiner.add("Matrícula: Não especificada");
		}
		if (curso != null) {
		    joiner.add("Curso: " + this.curso);
		} else {
			joiner.add("Curso: Não especificado");
		}
		if (ano_grad != -1) {
		    joiner.add("Ano de Graduacao: " + this.ano_grad);
		} else {
			joiner.add("Ano de Graduacao: Não especificado");
		}
		return joiner.toString();
	}
	

	// Getters e Setters
	public String getMatricula() {
		return this.Matricula;
	}


	public String getCurso() {
		return this.curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getAno_grad() {
		return this.ano_grad;
	}

	public void setAno_grad(int ano_grad) {
		this.ano_grad = ano_grad;
	}
}