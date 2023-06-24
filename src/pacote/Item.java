package pacote;
import java.util.ArrayList;


public class Item {
	private final int code; //aleatorio
	private final int QtdDePaginas;
	private String status; //disponivel, emprestado, reservado, etc.
	private String titulo;
	private String autores;
	private ArrayList<Reserva> listaReservas;
	private int ano;
	
	//Construtor

	public Item(int code, int qtdDePaginas, String status, String titulo, String autores, ArrayList<Reserva> listaReservas, int ano) {
		this.code = code;
		QtdDePaginas = qtdDePaginas;
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
		return "Item{" +
				"code=" + code +
				", QtdDePaginas=" + QtdDePaginas +
				", status='" + status + '\'' +
				", titulo='" + titulo + '\'' +
				", autores='" + autores + '\'' +
				", listaReservas=" + listaReservas +
				", ano=" + ano +
				'}';
	}
}
