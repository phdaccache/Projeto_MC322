package pacote;

import java.util.ArrayList;

public class Livro extends Item{
	private String editora;
	private int ISBN; //International Standard Book Number, código de identificação único para livros
	private String edicao;
	private String tema; //Educação, suspense, romance, etc
	//private ArquivoLivro arquivoLivro;
	
	//Construtor


	public Livro(int code, int QtdDePaginas, String titulo, String autores, ArrayList<Reserva> listaReservas, int ano, String editora, int ISBN, String edicao, String tema) {
		super(code, QtdDePaginas, titulo, autores, listaReservas, ano);
		this.editora = editora;
		this.ISBN = ISBN;
		this.edicao = edicao;
		this.tema = tema;
	}

	//Getters e setters
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int ISBN) {
		this.ISBN = ISBN;
	}
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}

	//Metodos

	//toString
	@Override
	public String toString() {
		return "Livro [editora=" + editora + ", ISBN=" + ISBN + ", edicao=" + edicao + ", tema=" + tema
				+ ", toString()=" + super.toString() + "]";
	}
}

