package sistema;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.StringJoiner;

public class Reserva {
	private Biblioteca biblioteca;
	private Item item;
	private LocalDate data; // Data em que o cliente vai poder tirar o item
	private Cliente cliente;
	private final int code;
	private int posicao;
	
	//Construtor
	public Reserva(Biblioteca biblioteca, Item item, LocalDate data, Cliente cliente, int posicao) {
		this.biblioteca = biblioteca;
		this.item = item;
		this.data = data;
		this.cliente = cliente;
		Random random = new Random();
		this.code = random.nextInt();
		this.posicao = posicao;
	}

	public Reserva(Biblioteca biblioteca, Item item, LocalDate data, Cliente cliente, int code, int posicao) {
		this.biblioteca = biblioteca;
		this.item = item;
		this.data = data;
		this.cliente = cliente;
		this.code = code;
		this.posicao = posicao;
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataReservaString = getData().format(dtf);
		joiner.add(String.format("Item: %s (Code: %d)", getItem().getTitulo(), getItem().getCode()));
		joiner.add("Data de reserva:" + dataReservaString);
		joiner.add("Codigo da reserva: " + getCode());
		joiner.add(String.format("Cliente: %s (CPF: %s)", getCliente().getNome(), getCliente().getCPF()));
		joiner.add("Posicao na fila de espera: " + getPosicao());
		return joiner.toString();
	}


	// Getters e Setters
	public Biblioteca getBiblioteca() {
		return this.biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public LocalDate getData() {
		return this.data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getCode() {
		return this.code;
	}


	public int getPosicao() {
		return this.posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
}