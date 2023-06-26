package pacote;
import java.util.ArrayList;
import java.util.StringJoiner;


public class Item {
	private final int code;
	private final int QtdDePaginas;
	private String status; //disponivel, emprestado, reservado, etc.
	private String titulo;
	private String autores;
	private ArrayList<Reserva> listaReservas;
	private int ano;
	
	//Construtor

	public Item(int code, int qtdDePaginas, String status, String titulo, String autores, ArrayList<Reserva> listaReservas, int ano) {
		this.code = code;
		this.QtdDePaginas = qtdDePaginas;
		this.status = status;
		this.titulo = titulo;
		this.autores = autores;
		this.listaReservas = listaReservas;
		this.ano = ano;
	}

	//Getters e setters
	public int getCode() {
		return code;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	public ArrayList<Reserva> getListaReservas(){
		return listaReservas;
	}
	public void setReserva(ArrayList<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getQtdDePaginas() {
		return QtdDePaginas;
	}
	public void addReserva(Reserva reserva) {
		this.listaReservas.add(reserva);
	}
	public void removeReserva(Reserva reserva) {
		this.listaReservas.remove(reserva);
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	//Metodos

	//toString
	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");
		if (titulo != null) {
		    joiner.add("Título: " + this.titulo);
		} else {
			joiner.add("Título: Não especificado");
		}
		if (QtdDePaginas != -1) {
		    joiner.add("Quantidade de Páginas: " + this.QtdDePaginas);
		} else {
			joiner.add("Quantidade de Páginas: Não especificado");
		}
		if (status != null) {
		    joiner.add("Status: " + this.status);
		} else {
			joiner.add("Status: Não especificado");
		}
		if (autores != null) {
		    joiner.add("Autores: " + this.autores);
		} else {
			joiner.add("Autores: Não especificados");
		}
		if (ano != -1) {
		    joiner.add("Ano: " + this.ano);
		} else {
			joiner.add("Ano: Não especificado");
		}
		return joiner.toString();
	}
}
