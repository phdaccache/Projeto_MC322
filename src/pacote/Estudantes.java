package pacote;

import java.util.ArrayList;
import java.util.Date;

public class Estudantes extends Cliente{
	private final String RA;
	private String curso;
	private int ano_grad; //ano limite de graduacao
	
	//Construtor


	public Estudantes(String CPF, String nome, String telefone, String email, String ID, Date dataNasc, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Reserva> listaReservasItens, String RA, String curso, int ano_grad) {
		super(CPF, nome, telefone, email, ID, dataNasc, listaEmprestimos, listaReservasItens);
		this.RA = RA;
		this.curso = curso;
		this.ano_grad = ano_grad;
	}

	//Getters e setters
	public String getRA() {
		return RA;
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

	//Metodo para verificar se o aluno esta apto a fazer emprestimos

	//Metodo para verificar se o aluno esta apto a fazer reservas

	//toString
	@Override
	public String toString() {
		return "Estudantes [RA=" + RA + ", curso=" + curso + ", ano_grad=" + ano_grad + "]";
	}
	
}
