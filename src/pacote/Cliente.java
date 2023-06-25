package pacote;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringJoiner;

public class Cliente {
	private final String CPF;
	private String nome;
	private String telefone;
	private String email;
	private Date dataNasc;
	private final String ID;
	private final String senha;
	private String status; // "ativo", "inativo", "suspenso", "bloqueado" etc
	private ArrayList<Emprestimo> listaEmprestimos;
	private ArrayList<Reserva> listaReservasItens;
	
	//Construtor


	public Cliente(String CPF, String nome, String telefone, String email, Date dataNasc, String ID, String senha, String status, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Reserva> listaReservasItens) {
		this.CPF = CPF;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.dataNasc = dataNasc;
		this.ID = ID;
		this.senha = senha;
		this.status = status;
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
	public void getStatus() {
		System.out.println("Status: " + status);
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getID() {
		return ID;
	}
	public String getSenha() {
		return senha;
	}


	//Metodos

	//Metodo para verificar se o cliente esta apto a fazer emprestimos
	public boolean aptoEmprestimo() {
		if (status.equals("ativo")) {
			System.out.println("Cliente apto a fazer emprestimos e reservas");
			return true;
		}
		else if (status.equals("inativo")) {
			System.out.println("Cliente inativo, nao pode fazer emprestimos e reservas");
			return false;
		}
		else if (status.equals("suspenso")) {
			System.out.println("Cliente suspenso, nao pode fazer emprestimos e reservas");
			return false;
		}
		else if (status.equals("bloqueado")) {
			System.out.println("Cliente bloqueado, nao pode fazer emprestimos e reservas");
			return false;
		}
		else {
			System.out.println("Status invalido");
			return false;
		}
	}

	//Metodo para achar emprestimo na lista de emprestimos da biblioteca
	public Emprestimo achaEmprestimo(String titulo, ArrayList<Emprestimo> listaEmprestimos) {
		for (Emprestimo emprestimo : listaEmprestimos) {
			if (emprestimo.getItem().getTitulo().equals(titulo)) {
				return emprestimo;
			}
		}
		return null;
	}

	// PROTÓTIPO - Metodo para verificar se o item está disponível, emprestado, ou reservado.
	public String verificaStatusItem(String TituloItem, ArrayList<Item> listaItens, ArrayList<Emprestimo> listaEmprestimos) {
		for (Item item : listaItens) {
			if (item.getTitulo().equals(TituloItem)) {
				if (item.getStatus().equals("disponivel")) {
					System.out.println("Item disponivel");
					return "disponivel";
				}
				else if(item.getStatus().equals("emprestado")){
					return "emprestado";
				}
				else if(item.getStatus().equals("reservado")){
					return "reservado";
				}
				else {
					System.out.println("Status invalido");
					return "invalido";
				}
			}
		}
		return "Item nao encontrado";
	}
	//PROTÓTIPO - Metodo que tenta fazer um emprestimo, em seguida aplica o metodo de reserva caso o cliente queira.
	public boolean TentaEmprestimo(String TituloItem, ArrayList<Item> listaItens, ArrayList<Emprestimo> listaEmprestimos) {
		if (aptoEmprestimo() == true) {
			if (verificaStatusItem(TituloItem, listaItens, listaEmprestimos) == "disponivel") {
				System.out.println("Emprestimo realizado com sucesso");
				return true;
			}
			else if(verificaStatusItem(TituloItem, listaItens, listaEmprestimos) == "emprestado"){
				Emprestimo emprestimo = achaEmprestimo(TituloItem, listaEmprestimos);
				System.out.println("Item emprestado. \nEstará disponivel no máximo em " + emprestimo.getDataLim() + ".");
				//Método para tentar reserva, caso o cliente queira.
				return false;
			}
			else if(verificaStatusItem(TituloItem, listaItens, listaEmprestimos) == "reservado"){
				System.out.println("Item reservado.");
				//Método para tentar reserva, caso o cliente queira.
				return false;
			}
			else {
				System.out.println("Emprestimo nao realizado");
				return false;
			}
		}
		else {
			System.out.println("Cliente nao apto a fazer emprestimos");
			return false;
		}
	}

	//Metodo para tentar fazer uma reserva

	//toString
	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");
		/*DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataNascimento = getDataNasc().format(data);   */ //Dá errado por algum motivo
		joiner.add("CPF: " + CPF);
		joiner.add("Nome: " + nome);
		joiner.add("Email: " + email);
		joiner.add("Telefone: " + telefone);
		joiner.add("Data de nascimento: " + dataNasc);
		joiner.add("Status: " + status);
		return joiner.toString();
	}

}
