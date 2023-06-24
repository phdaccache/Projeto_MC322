package pacote;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Apostila extends Item{
	//private ArquivoApostila arquivoApostila;
	private String disciplina;
	private String instituicao;
	
	//Construtor
	public Apostila(int code, int QtdDePaginas, String disciplina, String instituicao, String titulo, String autores, ArrayList<Reserva> listaReservas,
			int ano/*, ArquivoApostila arquivoApostila*/) {
		super(code, QtdDePaginas, titulo, autores, listaReservas, ano);
		this.disciplina = disciplina;
		this.instituicao = instituicao;
		//this.arquivoApostila = arquivoApostila;
	}
	//Getters e setters
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina= disciplina;
	}
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao= instituicao;
	}

	//Metodos

	//toString
	@Override
	public String toString() {
		return "Apostila [disciplina=" + disciplina + ", instituicao=" + instituicao + ", toString()="
				+ super.toString() + "]";
	}

}