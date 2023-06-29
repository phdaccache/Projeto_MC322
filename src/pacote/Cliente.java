package pacote;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.StringJoiner;

public class Cliente {
	// Atributos
	private final String[] possiveisAssinaturas;
	private Biblioteca biblioteca;
	private String CPF;
	private int multa; // Valor de multa acumulada. O cliente sempre começa com 0.
	private String nome;
	private String telefone;
	private String email;
	private LocalDate dataNasc;
	private String senha;
	private String assinatura;
	private String status; // "ativo", "inativo"
	private ArrayList<Emprestimo> listaEmprestimos;
	private ArrayList<Reserva> listaReservasItens;
	
	//Construtor
	public Cliente(Biblioteca biblioteca, String CPF, String nome, String telefone, String email, LocalDate dataNasc, String senha, String assinatura) {
		this.possiveisAssinaturas = new String[]{"Básico", "Prata", "Dourado"};
		this.biblioteca = biblioteca;
		this.CPF = CPF;
		this.multa = 0;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.dataNasc = dataNasc;
		this.senha = senha;
		this.assinatura = assinatura;
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //Formato da data (dia/mes/ano
		String dataNascimento = formato.format(getDataNasc());
		joiner.add("CPF: " + CPF);
		joiner.add("Nome: " + nome);
		joiner.add("Email: " + email);
		joiner.add("Telefone: " + telefone);
		joiner.add("Data de nascimento: " + dataNascimento);
		joiner.add("Status: " + status);
		joiner.add("Biblioteca: " + biblioteca.getNome());

		return joiner.toString();
	}

	public Item getItem(String Titulo){
		try {
	        if (this.biblioteca == null) {
	            throw new IllegalArgumentException("Lista vazia!");
	        }
        for(Item item : biblioteca.getItens()) {
			if(item.getTitulo().equals(Titulo)) {
				return item;
			}
		}
		return null;
    	} catch (IllegalArgumentException e) {
	        System.out.println("Erro: " + e.getMessage());
            return null;
    	}
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
			System.out.println("Status inválido");
			return false;
		}
	}

	//Metodo para achar emprestimo na lista de emprestimos da biblioteca
	public Emprestimo achaEmprestimo(String titulo, ArrayList<Emprestimo> listaEmprestimos) {
		try {
	        if (listaEmprestimos == null) {
	            throw new IllegalArgumentException("Lista vazia!");
	        }
        for (Emprestimo emprestimo : listaEmprestimos) {
			if (emprestimo.getItem().getTitulo().equals(titulo)) {
				return emprestimo;
			}
		}
		return null;
    	} catch (IllegalArgumentException e) {
	        System.out.println("Erro: " + e.getMessage());
            return null;
    	}
	}

	// PROTÓTIPO - Metodo para verificar se o item está disponível, emprestado, ou reservado.
	public String verificaStatusItem(String TituloItem, ArrayList<Item> listaItens, ArrayList<Emprestimo> listaEmprestimos) {
		try {
	        if (listaItens == null) {
	            throw new IllegalArgumentException("Lista vazia!");
	        }
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
    	} catch (IllegalArgumentException e) {
	        System.out.println("Erro: " + e.getMessage());
            return null;
    	}
	}

	public String TentaEmprestimo(String TituloItem, ArrayList<Item> listaItens, ArrayList<Emprestimo> listaEmprestimos) {
		if (aptoEmprestimo() == true) {
			if (verificaStatusItem(TituloItem, listaItens, listaEmprestimos) == "disponivel") {
				fazerEmprestimo(TituloItem);
				return "Emprestimo realizado com sucesso";
			}
			else if(verificaStatusItem(TituloItem, listaItens, listaEmprestimos) == "emprestado"){
				Emprestimo emprestimo = achaEmprestimo(TituloItem, listaEmprestimos);
				return "Item emprestado. \nEstará disponivel no máximo em " + emprestimo.getData_fim() + ".\n" + "Para caso queira fazer uma reserva, vá para a area de reservas.";
			}
			else if(verificaStatusItem(TituloItem, listaItens, listaEmprestimos) == "reservado"){
				return "Item está reservado. Para caso queira fazer uma reserva, vá para a área de reservas";
			}
			else {
				return "Emprestimo nao realizado";
			}
		}
		else {
			return "Cliente nao apto a fazer emprestimos";
		}
	}
	public void fazerEmprestimo(String titulo){
		biblioteca.cadastrarEmprestimo(getItem(titulo), Admin.data, Admin.data.plusDays(verificaQtdDeDias(this)), this);
		biblioteca.getItem(titulo).setStatus("emprestado");
	}
	public String listarEmprestimos(){
		String retorno;
		if(listaEmprestimos.isEmpty() || listaEmprestimos == null){
			return "Nao ha emprestimos";
		}
		else{
			retorno = "****** Emprestimos ******\n";
			for(Emprestimo emprestimo : listaEmprestimos){
				retorno += emprestimo.toString();
			}
		}
		return retorno;
	}
	public String listarReservas(){
		String retorno = "";
		if(listaReservasItens.isEmpty() || listaReservasItens == null){
			return "Nao ha reservas";
		}
		else{
			retorno = "****** Reservas ******\n";
			for(Reserva reserva : listaReservasItens){
				retorno += reserva.toString();
			}
		}
		return retorno;
	}
	public void pesquisarItem(String titulo){
		getBiblioteca().pesquisarItem(titulo);
	}
	public void UltimasAquisicoes(){
		getBiblioteca().UltimasAquisicoes();
	}

	public String DevolverEmprestimo(String Titulo){
		try {
	        if (listaEmprestimos == null) {
	            throw new IllegalArgumentException("Lista vazia!");
	        }
        for(Emprestimo emprestimo : listaEmprestimos){
			if(emprestimo.getItem().getTitulo().equals(Titulo)){
				listaEmprestimos.remove(emprestimo);
				biblioteca.removerEmprestimo(Titulo);
				return "Emprestimo removido com sucesso";
			}
		}
		return "Emprestimo nao encontrado";
    	} catch (IllegalArgumentException e) {
	        System.out.println("Erro: " + e.getMessage());
            return null;
    	}
	}

	//Permite fazer uma renovação apenas quando não há reservas para o item.
	public String renovarEmprestimo(String titulo){
		try {
	        if (listaEmprestimos == null) {
	            throw new IllegalArgumentException("Lista vazia!");
	        }
        if(getItem(titulo).getStatus().equals("reservado")){
			return "Há reservas. O cliente não pode renovar o emprestimo.";
		}
		else{
			for(Emprestimo emprestimo : listaEmprestimos){
				if(emprestimo.getItem().getTitulo().equals(titulo)){
					emprestimo.setData_fim(emprestimo.getData_fim().plusDays(verificaQtdDeDias(this)));
					return "Emprestimo renovado com sucesso";
				}
			}
		}
    	} catch (IllegalArgumentException e) {
	        return "Erro: " + e.getMessage();
    	}
		return "Emprestimo nao encontrado";
	}

	//public void listarEmprestimosAtrasados(){}

	public Boolean TentaReservar(String titulo) {
		try {
	        if (listaEmprestimos == null) {
	            throw new IllegalArgumentException("Lista vazia!");
	        }
        for(Emprestimo emprestimo : getBiblioteca().getEmprestimos()){
			if(emprestimo.getItem().getTitulo().equals(titulo)){
				return true;
			}
		}
		return false;
    	} catch (IllegalArgumentException e) {
	        System.out.println("Erro: " + e.getMessage());
            return false;
    	}
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
	public void RemoverReserva(String titulo){
		for(Reserva reserva : listaReservasItens){
			if(reserva.getItem().getTitulo().equals(titulo)){
				listaReservasItens.remove(reserva);
				getItem(titulo).removeReserva(reserva);
				biblioteca.removerReserva(titulo);
			}
		}
	}

	//Metodo que deixa em aberto que pode mudar todos os dados, se recebe uma string vazia, não muda o dado.
	public String EditarDados(String nome, String email, String telefone, LocalDate dataNasc, String senha){
		if(nome != ""){
			setNome(nome);
		}
		if(email != ""){
			setEmail(email);
		}
		if(telefone != ""){
			setTelefone(telefone);
		}
		if(dataNasc != null){
			setDataNasc(dataNasc);
		}
		if(senha != ""){
			setSenha(senha);
		}
		return "Dados alterados com sucesso";
	}
	public String VisualizarDados(){
		return toString();
	}

	//Fazer metodo para atualizar a situação

	// Getters e Setters
	public String[] getPossiveisAssinaturas() {
		return this.possiveisAssinaturas;
	}


	public Biblioteca getBiblioteca() {
		return this.biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	public String getCPF() {
		return this.CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public int getMulta() {
		return this.multa;
	}

	public void setMulta(int multa) {
		this.multa = multa;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNasc() {
		return this.dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getAssinatura() {
		return this.assinatura;
	}

	public void setAssinatura(String assinatura) {
		this.assinatura = assinatura;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<Emprestimo> getListaEmprestimos() {
		return this.listaEmprestimos;
	}

	public void setListaEmprestimos(ArrayList<Emprestimo> listaEmprestimos) {
		this.listaEmprestimos = listaEmprestimos;
	}

	public ArrayList<Reserva> getListaReservasItens() {
		return this.listaReservasItens;
	}

	public void setListaReservasItens(ArrayList<Reserva> listaReservasItens) {
		this.listaReservasItens = listaReservasItens;
	}
}
