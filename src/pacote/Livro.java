package pacote;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Livro extends Item{
	private String editora;
	private int ISBN; //International Standard Book Number, código de identificação único para livros
	private String edicao;
	private String tema; //Educação, suspense, romance, etc
	
	//Construtor


	public Livro(int code, int qtdDePaginas, String status, String titulo, String autores, ArrayList<Reserva> listaReservas, int ano, String editora, int ISBN, String edicao, String tema) {
		super(code, qtdDePaginas, status, titulo, autores, listaReservas, ano);
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
		StringJoiner joiner = new StringJoiner("\n");
		joiner.add(super.toString());
		 if (editora != null) {
		     joiner.add("Editora: " + this.editora);
		 } else {
			 joiner.add("Editora: Não especificada");
		 }
		 if (ISBN != -1) {
		     joiner.add("ISBN: " + this.ISBN);
		 } else {
			 joiner.add("ISBN: Não especificado");
		 }
		 if (edicao != null) {
		     joiner.add("Edição: " + this.edicao);
		 } else {
			 joiner.add("Edição: Não especificada");
		 }
		 if (tema != null) {
		     joiner.add("Tema: " + this.tema);
		 } else {
			 joiner.add("Tema: Não especificado");
		 }
		return joiner.toString();
	}
}

