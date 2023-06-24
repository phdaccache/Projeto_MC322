package pacote;
// import java.util.ArrayList;


public class Item {
	private final int code;
	private String titulo;
	private String autores;
	//private ArrayList<Reserva> listaReservas;
	private int ano;
	
	//Construtor
	public Item(int code, String titulo, String autores/*, ArrayList<Reserva> listaReservas*/, 
			int ano) {
		this.code = code;
		this.titulo = titulo;
		this.autores = autores;
		//this.listaReservas = listaReservas;
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
	/*public ArrayList<Reserva> getListaReservas(){
		return listaReservas;
	}
	public void setReserva(ArrayList<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}*/
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
}
