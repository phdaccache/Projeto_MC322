package sistema;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.StringJoiner;

public class Professores extends Cliente{
	private String instituicao;
	private String educacao; //Ensino medio, graduacao, mestrado, doutorado, pos-doutorado
	private String area; //Area de atuacao
	private String aulas;
	private int ano_ing; //ano de ingresso
	
	//Construtor


	public Professores(Biblioteca biblioteca, String CPF, int multa, String nome, String telefone, String email, LocalDate dataNasc, String senha, String assinatura, String status, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Reserva> listaReservasItens, String instituicao, String educacao, String area, String aulas, int ano_ing) {
		super(biblioteca, CPF, multa, nome, telefone, email, dataNasc, senha, assinatura, status, listaEmprestimos, listaReservasItens);
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
		if (instituicao != null) {
		    joiner.add("Instituição: " + this.instituicao);
		} else {
			joiner.add("Instituição: Não especificada");
		}
		if (educacao != null) {
		    joiner.add("Educação: " + this.educacao);
		} else {
			joiner.add("Educação: Não especificada");
		}
		if (area != null) {
		    joiner.add("Área: " + this.area);
		} else {
			joiner.add("Área: Não especificada");
		}
		if (aulas != null) {
		    joiner.add("Aulas: " + this.aulas);
		} else {
			joiner.add("Aulas: Não especificadas");
		}
		if (ano_ing != -1) {
		    joiner.add("Ano de ingresso: " + this.ano_ing);
		} else {
			joiner.add("Ano de ingresso: Não especificado");
		};
		return joiner.toString();
	}
}
