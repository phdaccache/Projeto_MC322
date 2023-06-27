package pacote;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.StringJoiner;

public class Cliente {
	private Biblioteca biblioteca;
	private String CPF;
	private int multa; //Valor de multa acumulada. O cliente sempre começa com 0.
	private String nome;
	private String telefone;
	private String email;
	private LocalDate dataNasc;
	private String senha;
	private String assinatura; // "basica", "Prata", "Dourado" etc
	private String status; // "ativo", "inativo", "suspenso", "bloqueado" etc
	private ArrayList<Emprestimo> listaEmprestimos;
	private ArrayList<Reserva> listaReservasItens;
	
	//Construtor
	public Cliente(Biblioteca biblioteca, String CPF, int multa, String nome, String telefone, String email, LocalDate dataNasc, String senha, String assinatura, String status, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Reserva> listaReservasItens) {
		Scanner entrada = new Scanner(System.in);
		this.biblioteca = biblioteca;
		this.CPF = CPF;
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
		while(true) {
	    	try {
	            if (!Validacao.validarNome(this.nome)) {
	                throw new IllegalArgumentException("Nome inválido");
	            }
	            break;
	        } catch (IllegalArgumentException e) {
	            System.out.println("Erro: " + e.getMessage());
	            System.out.println("Insira outro nome: ");
	            this.nome = entrada.next();
	        }
        }
		 while(true) {
		        try {
		            if (!Validacao.validarCpf(this.CPF)) {
		                throw new IllegalArgumentException("CPF inválido");
		            }
		            ArrayList<Cliente> c = biblioteca.getClientes();
		        	 for (Cliente cliente : c) {
		                 if (cliente.getCpf().equals(this.CPF)){
		                	 throw new IllegalArgumentException("CPF já cadastrado");
		                 }
		            }
		            break;
		        } catch (IllegalArgumentException e) {
		            System.out.println("Erro: " + e.getMessage());
		            System.out.println("Insira outro CPF: ");
		            this.CPF = entrada.next();
		        }
	        }
	        while(true) {
		        try {
		        	ArrayList<Cliente> c = biblioteca.getClientes();
		        	 for (Cliente cliente : c) {
		                 if (cliente.getCpf().equals(this.senha)){
		                	 throw new IllegalArgumentException("Senha já utilizada");
		                 }
		            }
		        	 break;
		        } catch (IllegalArgumentException e) {
		            System.out.println("Erro: " + e.getMessage());
		            System.out.println("Escolha outra senha: ");
		            this.senha = entrada.next();
		        }
	        }
	}

	//Getters e setters
	public String getCpf() {
		return CPF;
	}
	public void setCpf(String CPF) {
		try {
            if (!Validacao.validarCpf(this.CPF)) {
                throw new IllegalArgumentException("CPF inválido");
            }
            ArrayList<Cliente> c = biblioteca.getClientes();
	       	for (Cliente cliente : c) {
				 if (cliente.getCpf().equals(this.CPF)){
					 throw new IllegalArgumentException("CPF já cadastrado");
				 }
	        }
            this.CPF = CPF;
	     } catch (IllegalArgumentException e) {
	         System.out.println("Erro: " + e.getMessage());
	     }
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		try {
            if (!Validacao.validarNome(nome)) {
                throw new IllegalArgumentException("Nome inválido");
            }
            this.nome = nome;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
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
	public void setSenha(String senha) {
		try {
        	ArrayList<Cliente> c = biblioteca.getClientes();
        	 for (Cliente cliente : c) {
                 if (cliente.getCpf().equals(this.senha)){
                	 throw new IllegalArgumentException("Senha já utilizada");
                 }
            }
        	 this.senha = senha;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
	}
	public int getMulta() {
		return multa;
	}
	public void setMulta(int multa) {
		this.multa = multa;
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
				return "Item emprestado. \nEstará disponivel no máximo em " + emprestimo.getDataLim() + ".\n" + "Para caso queira fazer uma reserva, vá para a area de reservas.";
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
		biblioteca.cadastrarEmprestimo(getItem(titulo), Admin.getData(), Admin.getData().plusDays(verificaQtdDeDias(this)), this);
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
					emprestimo.setDataLim(emprestimo.getDataLim().plusDays(verificaQtdDeDias(this)));
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

	//toString
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

}
