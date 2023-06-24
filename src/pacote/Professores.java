package pacote;

import java.util.ArrayList;
import java.util.Date;

public class Professores extends Cliente{
	private String instituicao;
	private String educacao; //Ensino medio, graduacao, mestrado, doutorado, pos-doutorado
	private String area; //Area de atuacao
	private String aulas;
	private int ano_ing; //ano de ingresso
	
	//Construtor


	public Professores(String CPF, String nome, String telefone, String email, String ID, Date dataNasc, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Reserva> listaReservasItens, String instituicao, String educacao, String area, String aulas, int ano_ing) {
		super(CPF, nome, telefone, email, ID, dataNasc, listaEmprestimos, listaReservasItens);
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

	//Metodo para verificar se o professor esta apto a fazer emprestimos

	//Metodo para verificar se o professor esta apto a fazer reservas

	//toString
	@Override
	public String toString() {
		return "Professores [instituicao=" + instituicao + ", educacao=" + educacao + ", area=" + area + ", aulas="
				+ aulas + ", ano_ing=" + ano_ing + "]";
	}
}
