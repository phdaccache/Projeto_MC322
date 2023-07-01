package sistema;

import java.util.StringJoiner;

public class Artigo extends Item {
	// Atributos
	private int DOI; // Digital Object Identifier, identificador único para cada artigo;
	private String abstractArtigo; // Resumo do artigo;
	private String keywords; // Palavras-chave do artigo;
	
	// Construtor
	public Artigo(int quantidade, String titulo, String autor, int ano, int DOI, String abstractArtigo, String keywords) {
		super(quantidade, titulo, autor, ano, DOI);
		this.DOI = DOI;
		this.abstractArtigo = abstractArtigo;
		this.keywords = keywords;
	}

	public Artigo(int quantidade, String titulo, String autor, int ano, int DOI, String abstractArtigo, String keywords, String status) {
		super(quantidade, titulo, autor, ano, DOI, status);
		this.DOI = DOI;
		this.abstractArtigo = abstractArtigo;
		this.keywords = keywords;
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");
		joiner.add(super.toString());
		if (DOI != -1) {
	        joiner.add("DOI: " + this.DOI);
	    } else {
	        joiner.add("DOI: Não especificado");
	    }
	    
	    if (abstractArtigo != null) {
	        joiner.add("Resumo: " + this.abstractArtigo);
	    } else {
	        joiner.add("Instituição: Não especificada");
	    }
	    if (keywords != null) {
	        joiner.add("Palavras-chave: " + this.keywords);
	    } else {
	        joiner.add("Palavras-chave: Não especificadas");
	    }
		return joiner.toString();
	}


	// Getters e setters
	public int getDOI() {
		return this.DOI;
	}

	public void setDOI(int DOI) {
		this.DOI = DOI;
	}

	public String getAbstractArtigo() {
		return this.abstractArtigo;
	}

	public void setAbstractArtigo(String abstractArtigo) {
		this.abstractArtigo = abstractArtigo;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
}