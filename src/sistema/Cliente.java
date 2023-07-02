package sistema;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataNascimento = getDataNasc().format(dtf);
		joiner.add("CPF: " + CPF);
		joiner.add("Nome: " + nome);
		joiner.add("Email: " + email);
		joiner.add("Telefone: " + telefone);
		joiner.add("Data de nascimento: " + dataNascimento);
		joiner.add("Status: " + status);
		joiner.add("Biblioteca: " + biblioteca.getNome());

		return joiner.toString();
	}

	/////////////////////////////////// MINHA CONTA ///////////////////////////////////

	public String visualizarDados(){
		return toString();
	}

	public String excluirConta() {
        try {
            getBiblioteca().excluirCliente(getCPF());
            return "Conta excluída!\n";
        } catch (IllegalArgumentException erro) {
            throw erro;
        }
    }

	/////////////////////////////////// ITENS ///////////////////////////////////

	public String pesquisarItem(String titulo) throws IllegalArgumentException {
		return getBiblioteca().pesquisarItem(titulo);
	}

	public String ultimasAquisicoes() {
		String string = "";
        ArrayList<Item> itens = getItens();

        if(itens == null || itens.isEmpty()){
            string += "Não há itens cadastrados.\n";
        }

        else {
            for(int i = itens.size() - 1; i >= 0; i--){
				// garantir que so vai pegar os ultimos 5 itens
				if (i < itens.size() - 5) {
					break;
				}
                string += "---------------------------------------------\n";
                string += (itens.get(i) + "\n");
            }
            string += "---------------------------------------------\n";
        }

        return string;
	}

	/////////////////////////////////// EMPRESTIMOS ///////////////////////////////////

	public String listarEmprestimos(){
        String string = "";
        ArrayList<Emprestimo> emprestimos = getListaEmprestimos();

        if(emprestimos == null || emprestimos.isEmpty()){
            string += "Não há empréstimos cadastrados.\n";
        }

        else {
            for(Emprestimo emprestimo : emprestimos){
                string += "---------------------------------------------\n";
                string += (emprestimo + "\n");
            }
            string += "---------------------------------------------\n";
        }

        return string;
    }

	public String listarEmprestimosAtrasados() {
		String string = "";
		ArrayList<Emprestimo> emprestimos = getEmprestimosAtrasados();

		if(emprestimos == null || emprestimos.isEmpty()){
            string += "Não há empréstimos atrasados.\n";
        }

        else {
            for(Emprestimo emprestimo : emprestimos){
                string += "---------------------------------------------\n";
                string += (emprestimo + "\n");
            }
            string += "---------------------------------------------\n";
        }

        return string;
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

	// Metodo para achar emprestimo na lista de emprestimos da biblioteca
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

	public String fazerEmprestimo(String titulo) throws IllegalArgumentException {
		String message = biblioteca.cadastrarEmprestimo(getItem(titulo), Admin.data, Admin.data.plusDays(verificaQtdDeDias(this)), this);
		Emprestimo emprestimo = new Emprestimo(biblioteca, getItem(titulo), Admin.data, Admin.data.plusDays(verificaQtdDeDias(this)), this);
		getListaEmprestimos().add(emprestimo);
		biblioteca.getItem(titulo).setStatus("emprestado");
		return message;
	}

	public String DevolverEmprestimo(String Titulo){
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
		throw new IllegalArgumentException("Empréstimo não encontrado!");
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

	/////////////////////////////////// RESERVAS ///////////////////////////////////

	public String listarReservas(){
		String string = "";
        ArrayList<Reserva> reservas = getListaReservasItens();

        if(reservas == null || reservas.isEmpty()){
            string += "Não há reservas cadastradas.\n";
        }

        else {
            for(Reserva reserva : reservas){
                string += "---------------------------------------------\n";
                string += (reserva + "\n");
            }
            string += "---------------------------------------------\n";
        }

        return string;
	}

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

	/////////////////////////////////// GETTERS PARA OBJETOS ///////////////////////////////////

	public ArrayList<Item> getItens() {
		return getBiblioteca().getItens();
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

	public ArrayList<Emprestimo> getEmprestimosAtrasados() {
		ArrayList<Emprestimo> emprestimosAtrasados = new ArrayList<Emprestimo>();
		ArrayList<Emprestimo> emprestimos = getListaEmprestimos();

		if (emprestimos == null || emprestimos.isEmpty()) {
			return emprestimosAtrasados;
		}

		for(Emprestimo emprestimo : emprestimos){
			if(emprestimo.isAtrasado()){
				emprestimosAtrasados.add(emprestimo);
			}
		}

		return emprestimosAtrasados;
	}

	/////////////////////////////////// METODOS AUXILIARES ///////////////////////////////////

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