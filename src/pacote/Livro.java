package pacote;

import java.util.StringJoiner;

public class Livro extends Item {
	// Atributos
	private String editora;
	private int ISBN; // International Standard Book Number, código de identificação único para livros
	private String edicao;
	private String tema; // Educação, suspense, romance, etc
	
	//Construtor
	public Livro(int code, int qtdDePaginas, String titulo, String autor, int ano, String editora, int ISBN, String edicao, String tema) {
		super(code, qtdDePaginas, titulo, autor, ano);
		this.editora = editora;
		this.ISBN = ISBN;
		this.edicao = edicao;
		this.tema = tema;
	}

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

	// Getters e Setters
	public String getEditora() {
		return this.editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getISBN() {
		return this.ISBN;
	}

	public void setISBN(int ISBN) {
		this.ISBN = ISBN;
	}

	public String getEdicao() {
		return this.edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getTema() {
		return this.tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
}

