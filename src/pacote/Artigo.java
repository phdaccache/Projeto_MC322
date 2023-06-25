package pacote;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Artigo extends Item{
	//private ArquivoArtigo arquivoArtigo;
	private int DOI; //Digital Object Identifier, identificador único para cada artigo;
	private String abstractArtigo; //Resumo do artigo;
	private String keywords; //Palavras-chave do artigo;

	
	//Construtor

	public Artigo(int code, int qtdDePaginas, String status, String titulo, String autores, ArrayList<Reserva> listaReservas, int ano, int DOI, String abstractArtigo, String keywords) {
		super(code, qtdDePaginas, status, titulo, autores, listaReservas, ano);
		this.DOI = DOI;
		this.abstractArtigo = abstractArtigo;
		this.keywords = keywords;
	}

	//Getters e setters
	public int getDOI() {
		return DOI;
	}
	public void setDOI(int DOI) {
		this.DOI = DOI;
	}
	public String getAbstractArtigo() {
		return abstractArtigo;
	}
	public void setAbstractArtigo(String abstractArtigo) {
		this.abstractArtigo = abstractArtigo;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	//Metodos

	//toString
	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");
		joiner.add(super.toString());
		joiner.add("DOI: " + this.getDOI());
		joiner.add("Resumo: " + this.getAbstractArtigo());
		joiner.add("Palavras-chave: " + this.getKeywords());
		return joiner.toString();
	}
}

