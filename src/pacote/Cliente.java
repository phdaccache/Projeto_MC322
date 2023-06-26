package pacote;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.StringJoiner;

public class Cliente {
	private Biblioteca biblioteca;
	private final String CPF;
	private final String ID;
	private int multa; //Valor de multa acumulada. O cliente sempre começa com 0.
	private String nome;
	private String telefone;
	private String email;
	private LocalDate dataNasc;
	private final String senha;
	private String assinatura; // "basica", "Prata", "Dourado" etc
	private String status; // "ativo", "inativo", "suspenso", "bloqueado" etc
	private ArrayList<Emprestimo> listaEmprestimos;
	private ArrayList<Reserva> listaReservasItens;
	
	//Construtor
	public Cliente(Biblioteca biblioteca, String CPF, String ID, int multa, String nome, String telefone, String email, LocalDate dataNasc, String senha, String assinatura, String status, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Reserva> listaReservasItens) {
		this.biblioteca = biblioteca;
		this.CPF = CPF;
		this.ID = ID;
		this.multa = multa;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.dataNasc = dataNasc;
		this.senha = senha;
		this.assinatura = assinatura;
		this.status = status;
		this.listaEmprestimos = listaEmprestimos;
		this.listaReservasItens = listaReservasItens;
	}

	//Getters e setters
	public String getCpf() {
		return CPF;
	}
	public String getID() {
		return ID;
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
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(LocalDate dataNasc) {
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
	public String getSenha() {
		return senha;
	}
	public String getCPF() {
		return CPF;
	}
	public int getMulta() {
		return multa;
	}
	public void setMulta(int multa) {
		this.multa = multa;
	}
	public void setListaEmprestimos(ArrayList<Emprestimo> listaEmprestimos) {
		this.listaEmprestimos = listaEmprestimos;
	}
	public void setListaReservasItens(ArrayList<Reserva> listaReservasItens) {
		this.listaReservasItens = listaReservasItens;
	}
	public Biblioteca getBiblioteca() {
		return biblioteca;
	}
	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	public String getAssinatura() {
		return assinatura;
	}
	public void setAssinatura(String assinatura) {
		this.assinatura = assinatura;
	}
	//Metodos
	public Item getItem(String Titulo){
		for(Item item : biblioteca.getItens()) {
			if(item.getTitulo().equals(Titulo)) {
				return item;
			}
		}
		return null;
	}

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
				System.out.println("Item emprestado. \nEstará disponivel no máximo em " + emprestimo.getDataLim() + ".\n");
				System.out.println("Para caso queira fazer uma reserva, vá para a area de reservas.");
				//Método para tentar reserva, caso o cliente queira.
				return false;
			}
			else if(verificaStatusItem(TituloItem, listaItens, listaEmprestimos) == "reservado"){
				System.out.println("Item está reservado. Para caso queira fazer uma reserva, vá para a área de reservas");
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
	public void fazerEmprestimo(String titulo){
		if(TentaEmprestimo(titulo, biblioteca.getItens(), listaEmprestimos) == true){
			 biblioteca.cadastrarEmprestimo(getItem(titulo), Admin.getData(), Admin.getData().plusDays(verificaQtdDeDias(this)), this);
			 biblioteca.getItem(titulo).setStatus("emprestado");
			System.out.println("Emprestimo realizado com sucesso");
		}
		else{
			System.out.println("Emprestimo nao realizado");
		}
	}
	public void listarEmprestimos(){
		if(listaEmprestimos.isEmpty()){
			System.out.println("Nao ha emprestimos");
		}
		else{
			for(Emprestimo emprestimo : listaEmprestimos){
				System.out.println("****** Emprestimos ******");
				emprestimo.toString();
			}
		}
	}
	public void listarReservas(){
		if(listaReservasItens.isEmpty()){
			System.out.println("Nao ha reservas");
		}
		else{
			for(Reserva reserva : listaReservasItens){
				System.out.println("****** Reservas ******");
				reserva.toString();
			}
		}
	}
	public void pesquisarItem(String titulo){
		getBiblioteca().pesquisarItem(titulo);
	}
	public void UltimasAquisicoes(){
		getBiblioteca().UltimasAquisicoes();
	}

	public ArrayList<Emprestimo> DevolverEmprestimo(String Titulo){
		for(Emprestimo emprestimo : listaEmprestimos){
			if(emprestimo.getItem().getTitulo().equals(Titulo)){
				listaEmprestimos.remove(emprestimo);
				System.out.println("Emprestimo removido com sucesso");
				return listaEmprestimos;
			}
		}
		System.out.println("Emprestimo nao encontrado");
		return listaEmprestimos;
	}
	//Permite fazer uma renovação apenas quando não há reservas para o item.
	public void renovarEmprestimo(String titulo){
		if(getItem(titulo).getStatus().equals("reservado")){
			System.out.println("Há reservas. O cliente não pode renovar o emprestimo.");
		}
		else{
			for(Emprestimo emprestimo : listaEmprestimos){
				if(emprestimo.getItem().getTitulo().equals(titulo)){
					emprestimo.setDataLim(emprestimo.getDataLim().plusDays(verificaQtdDeDias(this)));
					System.out.println("Emprestimo renovado com sucesso");
				}
			}
		}
	}

	//public void listarEmprestimosAtrasados(){}

	public Boolean TentaReservar(String titulo) {
		for(Emprestimo emprestimo : getBiblioteca().getEmprestimos()){
			if(emprestimo.getItem().getTitulo().equals(titulo)){
				return true;
			}
		}
		return false;
	}
	// Metodo para verificar a quantidade de dias que um cliente pode ficar.
	public int verificaQtdDeDias(Cliente cliente){
		if(cliente.getAssinatura().equals("Básico")){
			return 5;
		}
		else if(cliente.getAssinatura().equals("Prata")){
			return 7;
		}
		else if(cliente.getAssinatura().equals("Dourado")){
			return 10;
		}
		else{
			System.out.println("Assinatura invalida");
			return 0;
		}
	}
	//Método para calcular a data esperada para o item estar disponivel.
	public LocalDate CalculaData(String titulo){
		LocalDate data = getItem(titulo).getListaReservas().get(0).getData().plusDays(verificaQtdDeDias(this));
		return data;
	}
	public void Reservar(String titulo){
		biblioteca.cadastrarReserva(getItem(titulo), CalculaData(titulo), this, 0);
		biblioteca.getItem(titulo).setStatus("reservado");
	}

	//Fazer metodo para atualizar a situação

	//toString
	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //Formato da data (dia/mes/ano
		String dataNascimento = formato.format(getDataNasc());
		joiner.add("CPF: " + CPF);
		joiner.add("ID: " + ID);
		joiner.add("Nome: " + nome);
		joiner.add("Email: " + email);
		joiner.add("Telefone: " + telefone);
		joiner.add("Data de nascimento: " + dataNascimento);
		joiner.add("Status: " + status);
		joiner.add("Biblioteca: " + biblioteca.getNome());

		return joiner.toString();
	}

}
