package sistema;

import java.time.LocalDate;
import java.util.Random;
import java.util.StringJoiner;

public class Emprestimo {
	private Item item;
	private Boolean status; //true para em dia e false para atrasado
	private LocalDate data_ini; //data do emprestimo
	private LocalDate data_lim; //data do limite da devolucao
	private Cliente cliente;
	private final int code; //aleatorio
	
	//Construtor
	public Emprestimo(Item item, LocalDate data_ini, LocalDate data_lim, Cliente cliente, Boolean status) {
		this.item = item;
		this.data_ini = data_ini;
		this.data_lim = data_lim;
		this.cliente = cliente;
		this.status = status;
		Random random = new Random();
		this.code = random.nextInt();
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
	public LocalDate getDataIni() {
		return data_ini;
	}
	public void setDataIni(LocalDate data_ini) {
		this.data_ini = data_ini;
	}
	public LocalDate getDataLim() {
		return data_lim;
	}
	public void setDataLim(LocalDate data_lim) {
		this.data_lim = data_lim;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	//Metodos

	//toString
	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");
		joiner.add("Item: %s (Code: %s)" + getItem().getTitulo() + getItem().getCode());
		joiner.add("Data de inicio de emprestimo:" + getDataIni());
		joiner.add("Data limite de devolucao:" + getDataLim());
		joiner.add("Cliente: %s (CPF: %s)" + getCliente().getNome() + getCliente().getCpf());
		joiner.add("Code: %s" + getCode());
		return joiner.toString();
	}
	
}
