package pacote;

import java.util.ArrayList;
import java.util.Date;

public class Cliente {
	private final String CPF;
	private String nome;
	private String telefone;
	private String email;
	private final String ID;
	private Date dataNasc;
	private String status; // "ativo", "inativo", "suspenso", "bloqueado" etc
	private ArrayList<Emprestimo> listaEmprestimos;
	private ArrayList<Reserva> listaReservasItens;
	
	//Construtor
	public Cliente(String CPF, String nome, String telefone, String email, String ID, Date dataNasc, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Reserva> listaReservasItens) {
		this.CPF = CPF;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.ID = ID;
		this.dataNasc = dataNasc;
		this.listaEmprestimos = listaEmprestimos;
		this.listaReservasItens = listaReservasItens;
	}

	//Getters e setters
	public String getCpf() {
		return CPF;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public ArrayList<Reserva> getListaReservasItens(){
		return listaReservasItens;
	}
	public void setReservaItens(ArrayList<Reserva> listaReservasItens) {
		this.listaReservasItens = listaReservasItens;
	}
	public ArrayList<Emprestimo> getListaEmprestimos(){
		return listaEmprestimos;
	}
	public void setEmprestimo(ArrayList<Emprestimo> listaEmprestimos) {
		this.listaEmprestimos = listaEmprestimos;
	}

	//Metodos

	//toString
	@Override
	public String toString() {
		return "Cliente [CPF=" + CPF + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", ID=" + ID
				+ ", dataNasc=" + dataNasc + ", status=" + status + ", listaEmprestimos=" + listaEmprestimos
				+ ", listaReservasItens=" + listaReservasItens + "]";
	}

}
