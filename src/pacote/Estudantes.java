package pacote;

import java.util.ArrayList;
import java.util.Date;
import java.util.StringJoiner;

public class Estudantes extends Cliente{
	private final String Matricula;
	private String curso;
	private int ano_grad; //ano limite de graduacao
	
	//Construtor

	public Estudantes(String CPF, String nome, String telefone, String email, Date dataNasc, String ID, String senha, String status, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Reserva> listaReservasItens, String Matricula, String curso, int ano_grad) {
		super(CPF, nome, telefone, email, dataNasc, ID, senha, status, listaEmprestimos, listaReservasItens);
		this.Matricula = Matricula;
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
		joiner.add("Matricula: " + Matricula);
		joiner.add("Curso: " + curso);
		joiner.add("Ano de Graduacao: " + ano_grad);
		return joiner.toString();
	}
	
}
