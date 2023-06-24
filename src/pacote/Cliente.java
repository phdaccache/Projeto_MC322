package pacote;

// import java.util.ArrayList;
import java.util.Date;

public class Cliente {
	private final String CPF;
	private String nome;
	private String telefone;
	private String email;
	private Date dataNasc;
	//private ArrayList<Emprestimo> listaEmprestimos;
	//private ArrayList<Reserva> listaReservasItens;
	
	//Construtor
	public Cliente(String nome, String telefone, String email, String CPF, Date dataNasc 
			/*, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Reserva> listaReservasItens*/) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.CPF = CPF;
		this.dataNasc = dataNasc;
		//this.listaEmprestimos = listaEmprestimos;
		//this.listaReservasItens = listaReservasItens;
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
	/*public ArrayList<Reserva> getListaReservasItens(){
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
	}*/
}
