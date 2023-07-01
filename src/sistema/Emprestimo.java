package sistema;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.StringJoiner;

public class Emprestimo {
	// Atributos
	private String[] possiveisStatus;
	private Biblioteca biblioteca;
	private Item item;
	private String status;
	private LocalDate data_ini; // data do emprestimo
	private LocalDate data_fim; // data do limite da devolucao
	private Cliente cliente;
	private final int code; // aleatorio
	
	//Construtor
	public Emprestimo(Biblioteca biblioteca, Item item, LocalDate data_ini, LocalDate data_fim, Cliente cliente) {
		this.possiveisStatus = new String[] {"Em dia", "Atrasado"};
		this.biblioteca = biblioteca;
		this.item = item;
		this.data_ini = data_ini;
		this.data_fim = data_fim;
		this.cliente = cliente;
		this.status = "Em dia";
		Random random = new Random();
		this.code = random.nextInt();
	}

	public Emprestimo(Biblioteca biblioteca, Item item, LocalDate data_ini, LocalDate data_fim, Cliente cliente, String status, int code) {
		this.possiveisStatus = new String[] {"Em dia", "Atrasado"};
		this.biblioteca = biblioteca;
		this.item = item;
		this.data_ini = data_ini;
		this.data_fim = data_fim;
		this.cliente = cliente;
		this.status = status;
		this.code = code;
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataIniString = getData_ini().format(dtf);
		String dataFimString = getData_fim().format(dtf);
		joiner.add(String.format("Item: %s (Code: %d)", getItem().getTitulo(), getItem().getCode()));
		joiner.add("Data de inicio de emprestimo:" + dataIniString);
		joiner.add("Data limite de devolucao:" + dataFimString);
		joiner.add("Cliente: %s (CPF: %s)" + getCliente().getNome() + getCliente().getCPF());
		joiner.add("Code: %d" + getCode());
		return joiner.toString();
	}

	public boolean isAtrasado() {
		return this.status.equals("Atrasado");
	}


	// Getters e Setters
	public String[] getPossiveisStatus() {
		return this.possiveisStatus;
	}

	public void setPossiveisStatus(String[] possiveisStatus) {
		this.possiveisStatus = possiveisStatus;
	}

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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getData_ini() {
		return this.data_ini;
	}

	public void setData_ini(LocalDate data_ini) {
		this.data_ini = data_ini;
	}

	public LocalDate getData_fim() {
		return this.data_fim;
	}

	public void setData_fim(LocalDate data_fim) {
		this.data_fim = data_fim;
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
}