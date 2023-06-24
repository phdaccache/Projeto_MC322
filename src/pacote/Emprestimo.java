package pacote;

import java.util.Date;

public class Emprestimo {
	private Item item;
	private Date data_ini; //data do emprestimo
	private Date data_lim; //data do limite da devolucao
	private Cliente cliente;
	private final String code; //aleatorio
	
	//Construtor
	public Emprestimo(Item item, Date data_ini, Date data_lim, Cliente cliente, String code) {
		this.item = item;
		this.data_ini = data_ini;
		this.data_lim = data_lim;
		this.cliente = cliente;
		this.code = code;
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
	public Date getDataIni() {
		return data_ini;
	}
	public void setDataIni(Date data_ini) {
		this.data_ini = data_ini;
	}
	public Date getDataLim() {
		return data_lim;
	}
	public void setDataLim(Date data_lim) {
		this.data_lim = data_lim;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	//Metodos

	//toString
	@Override
	public String toString() {
		return "Emprestimo [item=" + item + ", data_ini=" + data_ini + ", data_lim=" + data_lim + ", cliente=" + cliente
				+ ", code=" + code + "]";
	}
	
}
