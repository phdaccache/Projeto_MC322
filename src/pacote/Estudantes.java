package pacote;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.StringJoiner;

public class Estudantes extends Cliente{
	private final String Matricula;
	private String curso;
	private int ano_grad; //ano limite de graduacao
	
	//Construtor


	public Estudantes(Biblioteca biblioteca, String CPF, int multa, String nome, String telefone, String email, LocalDate dataNasc, String senha, String assinatura, String status, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Reserva> listaReservasItens, String matricula, String curso, int ano_grad) {
		super(biblioteca, CPF, multa, nome, telefone, email, dataNasc, senha, assinatura, status, listaEmprestimos, listaReservasItens);
		this.Matricula = matricula;
		this.curso = curso;
		this.ano_grad = ano_grad;
	}

	//Getters e setters
	public String getMatricula() {
		return Matricula;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getAnoGrad() {
		return ano_grad;
	}
	public void setAnoGrad(int ano_grad) {
		this.ano_grad = ano_grad;
	}

	//Metodos


	//toString
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
	
}
