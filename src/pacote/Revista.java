package pacote;

import java.util.ArrayList;

public class Revista extends Item{
	//private ArquivoRevista arquivoRevista;
	private int edicao;
	
	//Construtor
	public Revista(int code, String titulo, String autores, ArrayList<Reserva> listaReservas,
			int ano, int edicao/*, ArquivoRevista arquivoRevista*/) {
		super(code, titulo, autores, listaReservas, ano);
		this.edicao = edicao;
		//this.arquivoRevista = arquivoRevista;
	}
	//Getters e setters
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

}
