package sistema;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringJoiner;

public class Item {
	// Atributos
	private final String[] possiveisStatus;
	private final int code;
	private int quantidade;
	private String status;
	private String titulo;
	private String autor;
	private int ano; // ano de publicacao
	private ArrayList<Reserva> listaReservas;
	
	//Construtor
	public Item(int quantidade, String titulo, String autor, int ano) {
		this.possiveisStatus = new String[]{"Disponível", "Emprestado", "Reservado"};
		Random random = new Random();
		this.code = random.nextInt();
		this.quantidade = quantidade;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.listaReservas = new ArrayList<Reserva>();
	}

	public Item(int quantidade, String titulo, String autor, int ano, int code) {
		this.possiveisStatus = new String[]{"Disponível", "Emprestado", "Reservado"};
		this.code = code;
		this.quantidade = quantidade;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.listaReservas = new ArrayList<Reserva>();
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");
		if (titulo != null) {
		    joiner.add("Título: " + this.titulo);
		} else {
			joiner.add("Título: Não especificado");
		}
		if (quantidade != -1) {
		    joiner.add("Quantidade: " + this.quantidade);
		} else {
			joiner.add("Quantidade: Não especificado");
		}
		if (status != null) {
		    joiner.add("Status: " + this.status);
		} else {
			joiner.add("Status: Não especificado");
		}
		if (autor != null) {
		    joiner.add("Autores: " + this.autor);
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

	public void addReserva(Reserva reserva) {
		this.listaReservas.add(reserva);
	}
	
	public void removeReserva(Reserva reserva) {
		this.listaReservas.remove(reserva);
	}


	// Getters e setters
	public String[] getPossiveisStatus() {
		return this.possiveisStatus;
	}


	public int getCode() {
		return this.code;
	}


	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAno() {
		return this.ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public ArrayList<Reserva> getListaReservas() {
		return this.listaReservas;
	}

	public void setListaReservas(ArrayList<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}
}