package pacote;

import java.util.ArrayList;
import java.util.Date;
import java.util.StringJoiner;

public class Professores extends Cliente{
	private String instituicao;
	private String educacao; //Ensino medio, graduacao, mestrado, doutorado, pos-doutorado
	private String area; //Area de atuacao
	private String aulas;
	private int ano_ing; //ano de ingresso
	
	//Construtor


	public Professores(String CPF, String nome, String telefone, String email, Date dataNasc, String ID, String senha, String status, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Reserva> listaReservasItens, String instituicao, String educacao, String area, String aulas, int ano_ing) {
		super(CPF, nome, telefone, email, dataNasc, ID, senha, status, listaEmprestimos, listaReservasItens);
		this.instituicao = instituicao;
		this.educacao = educacao;
		this.area = area;
		this.aulas = aulas;
		this.ano_ing = ano_ing;
	}

	//Getters e setters
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	public String getEducacao() {
		return educacao;
	}
	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAulas() {
		return aulas;
	}
	public void setAulas(String aulas) {
		this.aulas = aulas;
	}
	public int getAno_ing() {
		return ano_ing;
	}
	public void setAno_ing(int ano_ing) {
		this.ano_ing = ano_ing;
	}

	//Metodos



	//toString
	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");
		joiner.add(super.toString());
		joiner.add("Instituicao: " + this.instituicao);
		joiner.add("Educacao: " + this.educacao);
		joiner.add("Area: " + this.area);
		joiner.add("Aulas: " + this.aulas);
		joiner.add("Ano de ingresso: " + this.ano_ing);
		return joiner.toString();
	}
}
