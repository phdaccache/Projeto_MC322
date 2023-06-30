package sistema;

import java.time.LocalDate;
import java.util.Random;
import java.util.StringJoiner;

public class Reserva {
	private Item item;
	private LocalDate data; // Data em que o cliente vai poder tirar o item
	private Cliente cliente;
	private String status; //Em dia ou atrasado. No sentido de foi devolvido o livro reservado ou não
	private final int code;//
	private int posicao;
	
	//Construtor
	public Reserva(Item item, LocalDate data, Cliente cliente, int posicao) {
		this.item = item;
		this.data = data;
		this.cliente = cliente;
		Random random = new Random();
		this.code = random.nextInt();
		this.posicao = posicao;
	}

	//Getters e setters
	public int getCode() {
		return code;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
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
		joiner.add("Item: %s (Code: %s)" + getItem().getTitulo() + getItem().getCode());
		joiner.add("Data de reserva:" + getData());
		joiner.add("Codigo da reserva: " + getCode());
		joiner.add("Cliente: %s (CPF: %s)" + getCliente().getNome() + getCliente().getCpf());
		joiner.add("Posicao na fila de espera: " + getPosicao());
		joiner.add("Status: " + getStatus());
		return joiner.toString();

	}
}
