package pacote;

import java.util.Date;

public class Reserva {
	private Item item;
	private Date data;
	private Cliente cliente;
	private String status; //Em dia, atrasado, cancelado, etc.
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

	//Metodos


	//toString
	@Override
	public String toString() {
		return "Reserva [item=" + item + ", data=" + data + ", cliente=" + cliente + ", status=" + status + ", code="
				+ code + ", posicao=" + posicao + "]";
	}
}
