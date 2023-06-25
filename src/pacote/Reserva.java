package pacote;

import java.util.Date;
import java.util.StringJoiner;

public class Reserva {
	private Item item;
	private Date data; // Data em que o cliente vai poder tirar o item
	private Cliente cliente;
	private String status; //Em dia ou atrasado. No sentido de foi devolvido o livro reservado ou não
	private final String code; //aleatorio
	private String posicao;
	
	//Construtor
	public Reserva(Item item, Date data, Cliente cliente, String code, String posicao) {
		this.item = item;
		this.data = data;
		this.cliente = cliente;
		this.code = code;
		this.posicao = posicao;
	}

	//Getters e setters
	public String getCode() {
		return code;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
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
		joiner.add("Cliente: %s (CPF: %s)" + getCliente().getNome() + getCliente().getCpf());
		joiner.add("Posicao na fila de espera: " + getPosicao());
		joiner.add("Status: " + getStatus());
		return joiner.toString();

	}
}
