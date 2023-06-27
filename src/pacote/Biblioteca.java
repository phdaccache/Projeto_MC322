package pacote;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.jar.JarEntry;


public class Biblioteca {
    private String nome;
    private String CNPJ;
    private String endereco;
    private String telefone;
    private ArrayList<Item> itens;
    private ArrayList<Cliente> clientes;
    private ArrayList<Emprestimo> emprestimos;
    private ArrayList<Reserva> reservas;
    private String senha;

    //Construtor
    public Biblioteca(String nome, String CNPJ, String endereco, String telefone, ArrayList<Item> itens, ArrayList<Cliente> clientes, ArrayList<Emprestimo> emprestimos, ArrayList<Reserva> reservas, String senha) {
    	Scanner entrada = new Scanner(System.in);
    	this.nome = nome;
        this.CNPJ = CNPJ;
        this.endereco = endereco;
        this.telefone = telefone;
        this.itens = itens;
        this.clientes = clientes;
        this.emprestimos = emprestimos;
        this.reservas = reservas;
        this.senha = senha;
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
	            if (!Validacao.validarCnpj(this.CNPJ)) {
                    System.out.println(CNPJ);
	                throw new IllegalArgumentException("CNPJ inválido");
	            }
	            break;
	        } catch (IllegalArgumentException e) {
	            System.out.println("Erro: " + e.getMessage());
	            System.out.println("Insira outro CNPJ: ");
	            this.CNPJ = entrada.next();
	        }
        }
    }

    //Getters e setters

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
    public String getCNPJ() {
        return CNPJ;
    }
    public void setCNPJ(String CNPJ) {
    	try {
            if (!Validacao.validarCnpj(this.CNPJ)) {
                throw new IllegalArgumentException("CNPJ inválido");
            }
            this.CNPJ = CNPJ;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public ArrayList<Item> getItens() {
        return itens;
    }
    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }
    public String getSenha() {
		return senha;
	}

    //Métodos
    public String cadastrarEstudantes(Biblioteca biblioteca, String CPF, int multa, String nome, String telefone, String email, LocalDate dataNasc, String senha, String assinatura, String status, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Reserva> listaReservasItens, String matricula, String curso, int ano_grad) {
        Estudantes estudante = new Estudantes(biblioteca, CPF, multa, nome, telefone, email, dataNasc, senha, assinatura, status, listaEmprestimos, listaReservasItens, matricula, curso, ano_grad);
        try {
	        if (this.clientes == null) {
	            throw new IllegalArgumentException();
	        }
	    this.clientes.add(estudante);
	    return "Estudante cadastrado com sucesso";
    	} catch (IllegalArgumentException e) {
        	this.clientes = new ArrayList<>();
 	        this.clientes.add(estudante);
            return "Estudante cadastrado com sucesso";
 	    }
    }
    public String cadastrarProfessores(Biblioteca biblioteca, String CPF, int multa, String nome, String telefone, String email, LocalDate dataNasc, String senha, String assinatura, String status, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Reserva> listaReservasItens, String instituicao, String educacao, String area, String aulas, int ano_ing) {
        Professores professor = new Professores(biblioteca, CPF, multa, nome, telefone, email, dataNasc, senha, assinatura, status, listaEmprestimos, listaReservasItens, instituicao, educacao, area, aulas, ano_ing);
        try {
	        if (this.clientes == null) {
	            throw new IllegalArgumentException();
	        }
	    this.clientes.add(professor);
	    return "Professor cadastrado com sucesso";
    	} catch (IllegalArgumentException e) {
        	this.clientes = new ArrayList<>();
 	        this.clientes.add(professor);
            return "Professor cadastrado com sucesso";
 	    }
    }
    public String cadastrarLivro(int code, int qtdDePaginas, String status, String titulo, String autores, ArrayList<Reserva> listaReservas, int ano, String editora, int ISBN, String edicao, String tema){
        Livro livro = new Livro(code, qtdDePaginas, status, titulo, autores, listaReservas, ano, editora, ISBN, edicao, tema);
        try {
	        if (this.itens == null) {
	            throw new IllegalArgumentException();
	        }
	    this.itens.add(livro);
	    return "Livro cadastrado com sucesso.";
    	} catch (IllegalArgumentException e) {
        	this.itens = new ArrayList<>();
 	        this.itens.add(livro);
            return "Livro cadastrado com sucesso.";
 	    }
    }
    public String cadastrarArtigo(int code, int qtdDePaginas, String status, String titulo, String autores, ArrayList<Reserva> listaReservas, int ano, int DOI, String abstractArtigo, String keywords){
        Artigo artigo = new Artigo(code, qtdDePaginas, status, titulo, autores, listaReservas, ano, DOI, abstractArtigo, keywords);
        try {
	        if (this.itens == null) {
	            throw new IllegalArgumentException();
	        }
	    this.itens.add(artigo);
	    return "Artigo cadastrado com sucesso";
    	} catch (IllegalArgumentException e) {
        	this.itens = new ArrayList<>();
 	        this.itens.add(artigo);
            return "Artigo cadastrado com sucesso";
 	    }
    }
    public String cadastrarRevista(int code, int qtdDePaginas, String status, String titulo, String autores, ArrayList<Reserva> listaReservas, int ano, int edicao, String instituicao, ArrayList<String> assuntos, int ISSN) {
        Revista revista = new Revista(code, qtdDePaginas, status, titulo, autores, listaReservas, ano, edicao, instituicao, assuntos, ISSN);
        try {
	        if (this.itens == null) {
	            throw new IllegalArgumentException();
	        }
	    this.itens.add(revista);
	    return "Revista cadastrado com sucesso";
    	} catch (IllegalArgumentException e) {
        	this.itens = new ArrayList<>();
 	        this.itens.add(revista);
            return "Revista cadastrado com sucesso";
 	    }
    }
    public String cadastrarEmprestimo(Item item, LocalDate data_ini, LocalDate data_lim, Cliente cliente) {
        Emprestimo emprestimo = new Emprestimo(item, data_ini, data_lim, cliente, true);
        try {
            if (this.emprestimos == null) {
                throw new IllegalArgumentException();
            }
            this.emprestimos.add(emprestimo);
            return "Emprestimo cadastrado com sucesso";

        } catch (IllegalArgumentException e) {
            this.emprestimos = new ArrayList<>();
            this.emprestimos.add(emprestimo);
            return "Emprestimo cadastrado com sucesso";
        }
    }
    public String cadastrarReserva(Item item, LocalDate data, Cliente cliente, int posicao) {
        Reserva reserva = new Reserva(item, data, cliente, posicao);
        try {
            if (this.reservas == null) {
                throw new IllegalArgumentException();
            }
            this.reservas.add(reserva);
            return "Reserva cadastrado com sucesso";
        } catch (IllegalArgumentException e) {
            this.reservas = new ArrayList<>();
            this.reservas.add(reserva);
            return "Reserva cadastrado com sucesso";
        }
    }
    public String removerCliente(String CPF) {
        System.out.println("***** Removendo cliente *****");
        try {
            if (this.clientes == null) {
                throw new IllegalArgumentException("Lista vazia!");
            }
            for (Cliente cliente : this.clientes) {
                if (cliente.getCpf().equals(CPF)) {
                    this.clientes.remove(cliente);
                    removerEmprestimoPorCliente(CPF);
                    removerReservasPorCliente(CPF);
                    return "Cliente removido com sucesso!";
                }
            }
            return "Cliente não encontrado!";
        } catch (IllegalArgumentException e) {
            return "Erro: " + e.getMessage();
        }
    }
    public String removerItem(String Titulo) {
        System.out.println("***** Removendo item *****");
        try {
            if (this.itens == null) {
                throw new IllegalArgumentException("Lista vazia!");
            }
            for (Item item : this.itens) {
                if (item.getTitulo().equals(Titulo)) {
                    this.itens.remove(item);
                    removerEmprestimoPorItem(Titulo);
                    removerReservasPorItem(Titulo);
                    return "Item removido com sucesso!";
                }
            }
            return "Item não encontrado!";
        } catch (IllegalArgumentException e) {
            return "Erro: " + e.getMessage();
        }
    }
    public String removerEmprestimoPorCliente(String CPF) {
        try {
            if (this.emprestimos == null) {
                throw new IllegalArgumentException("Lista vazia!");
            }
            for (Emprestimo emprestimo : this.emprestimos) {
                int i = 0;
                i++;
                if (emprestimo.getCliente().getCpf().equals(CPF)) {
                    this.emprestimos.remove(emprestimo);
                    if(i == emprestimos.size()){
                        return "Emprestimos removidos com sucesso!";
                    }
                }
            }
            return "Emprestimos não encontrados!";
        } catch (IllegalArgumentException e) {
            return "Erro: " + e.getMessage();
        }
    }
    public String removerEmprestimoPorItem(String Titulo) {
        try {
            if (this.emprestimos == null) {
                throw new IllegalArgumentException("Lista vazia!");
            }
            int i = 0;
            for (Emprestimo emprestimo : this.emprestimos) {
                i++;
                if (emprestimo.getItem().getTitulo().equals(Titulo)) {
                    this.emprestimos.remove(emprestimo);
                    if(i == emprestimos.size()){
                        return "Emprestimos removidos com sucesso!";
                    }
                }
            }
            return "Emprestimos não encontrados!";
        } catch (IllegalArgumentException e) {
            return "Erro: " + e.getMessage();
        }
    }
    public String removerReservasPorCliente(String CPF) {
        try {
            if (this.reservas == null) {
                throw new IllegalArgumentException("Lista vazia!");
            }
            int i = 0;
            for (Reserva reserva : this.reservas) {
                i++;
                if (reserva.getCliente().getCpf().equals(CPF)) {
                    this.reservas.remove(reserva);
                    if(i == reservas.size()){
                        return "Reservas removidas com sucesso!";
                    }
                }
            }
            return "Reservas não encontradas!";
        } catch (IllegalArgumentException e) {
            return "Erro: " + e.getMessage();
        }
    }
    public void removerReservasPorItem(String Titulo) {
        try {
            if (this.reservas == null) {
                throw new IllegalArgumentException("Lista vazia!");
            }
            int i = 0;
            for (Reserva reserva : this.reservas) {
                i++;
                if (reserva.getItem().getTitulo().equals(Titulo)) {
                    this.reservas.remove(reserva);
                    if(i == reservas.size()){
                        System.out.println("Reservas removidas com sucesso!");
                        return;
                    }
                }
            }
            System.out.println("Reservas não encontradas!");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }
    }
    public void removerReserva(String titulo){
        try {
            if (this.reservas == null) {
                throw new IllegalArgumentException("Lista vazia!");
            }
            for(Reserva reserva : reservas){
                if(reserva.getItem().getTitulo().equals(titulo)){
                    this.reservas.remove(reserva);
                    return;
                }
            }
            return;
        } catch (IllegalArgumentException e) {
            return;
        }
    }
    public void removerEmprestimo(String titulo){
        try {
            if (this.emprestimos == null) {
                throw new IllegalArgumentException("Lista vazia!");
            }
            for(Emprestimo emprestimo : emprestimos){
                if(emprestimo.getItem().getTitulo().equals(titulo)){
                    this.emprestimos.remove(emprestimo);
                    return;
                }
            }
            return;
        } catch (IllegalArgumentException e) {
            return;
        }
    }

    //Retorna uma lista de itens especificos
    public Item getItem(String titulo){
        try {
            if (this.itens == null) {
                throw new IllegalArgumentException("Lista vazia!");
            }
            for(Item item : itens){
                if(item.getTitulo().equals(titulo)){
                    return item;
                }
            }
            System.out.println("Item não encontrado!");
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public ArrayList<Livro> getlivros(){
        try {
            if (this.itens == null) {
                throw new IllegalArgumentException("Lista vazia!");
            }
            ArrayList<Livro> livros = new ArrayList<>();
            for(Item item : itens){
                if(item instanceof Livro){
                    livros.add((Livro) item);
                }
            }
            if(livros.isEmpty()){
                System.out.println("Não há livros cadastrados!");
                return null;
            }
            return livros;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public ArrayList<Artigo> getArtigos(){
        try {
            if (this.itens == null) {
                throw new IllegalArgumentException("Lista vazia!");
            }
            ArrayList<Artigo> artigos = new ArrayList<>();
            for(Item item : itens){
                if(item instanceof Artigo){
                    artigos.add((Artigo) item);
                }
            }
            if (artigos.isEmpty()){
                System.out.println("Não há artigos cadastrados!");
                return null;
            }
            return artigos;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public ArrayList<Revista> getRevistas(){
        try {
            if (this.itens == null) {
                throw new IllegalArgumentException("Lista vazia!");
            }
            ArrayList<Revista> revistas = new ArrayList<>();
            for(Item item : itens){
                if(item instanceof Revista){
                    revistas.add((Revista) item);
                }
            }
            if (revistas.isEmpty()){
                System.out.println("Não há revistas cadastradas!");
                return null;
            }
            return revistas;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public ArrayList<Estudantes> getEstudantes(){
        try {
            if (this.clientes == null) {
                throw new IllegalArgumentException("Lista vazia!");
            }
            ArrayList<Estudantes> estudantes = new ArrayList<>();
            for(Cliente cliente : clientes){
                if(cliente instanceof Estudantes){
                    estudantes.add((Estudantes) cliente);
                }
            }
            if (estudantes.isEmpty()){
                System.out.println("Não há estudantes cadastrados!");
                return null;
            }
            return estudantes;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public ArrayList<Professores> getProfessores(){
        try {
            if (this.clientes == null) {
                throw new IllegalArgumentException("Lista vazia!");
            }
            ArrayList<Professores> professores = new ArrayList<>();
            for(Cliente cliente : clientes){
                if(cliente instanceof Professores){
                    professores.add((Professores) cliente);
                }
            }
            if (professores.isEmpty()){
                System.out.println("Não há professores cadastrados!");
                return null;
            }
            return professores;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public String listarItens(){
        String retorno = "";
        if(itens == null || itens.isEmpty()){
            return "Não há itens cadastrados!";
        }
        if (getlivros() != null) {
            retorno = "***** Livros *****";
            for(Livro livro : getlivros()){
                retorno = retorno + livro.toString();
            }
        }
        if (getArtigos() != null) {
            retorno = retorno + "***** Artigos *****";
            for(Artigo artigo : getArtigos()){
                retorno = retorno + artigo.toString();
            }
        }
        if (getRevistas() != null) {
            retorno = retorno + "***** Revistas *****";
            for(Revista revista : getRevistas()){
                retorno = retorno + revista.toString();
            }
        }
        return retorno;
    }
    public String listarLivros(){
        if(getlivros() == null){
            return "Não há livros cadastrados!";
        }
        String retorno = "***** Livros *****\n";
        for(Livro livro : getlivros()){
            retorno = retorno + livro.toString();
        }
        return retorno;
    }
    public String listarRevistas(){
        String retorno = "";
        if(getRevistas() == null){
            return "Não há revistas cadastradas!";
        }
        retorno = "***** Revistas *****\n";
        for(Revista revista : getRevistas()){
           retorno = retorno + revista.toString();
        }
        return retorno;
    }
    public String listarArtigos(){
        String retorno = "";
        if(getArtigos() == null){
            return "Não há artigos cadastrados!";
        }
        retorno = "***** Artigos *****\n";
        for(Artigo artigo : getArtigos()){
            retorno = retorno + artigo.toString();
        }
        return retorno;
    }
    public String listarClientes(){
        String retorno = "";
        if(clientes.isEmpty()){
            return "Não há clientes cadastrados!";
        }
        retorno = "***** Estudantes *****\n";
        for(Estudantes estudantes : getEstudantes()){
            retorno = retorno + estudantes.toString();
        }
        retorno = retorno + "***** Professores *****\n";
        for(Professores professores : getProfessores()){
            retorno = retorno + professores.toString();
        }
        return retorno;
    }
    public String listarEstudantes(){
        String retorno = "";
        if(getEstudantes() == null){
            return "Não há estudantes cadastrados!";
        }
        retorno = "***** Estudantes *****\n";
        for(Estudantes estudantes : getEstudantes()){
            retorno = retorno + estudantes.toString();
        }
        return retorno;
    }
    public String listarProfessores(){
        String retorno = "";
        if(getProfessores() == null){
            return "Não há professores cadastrados!";
        }
        retorno = "***** Professores *****\n";
        for(Professores professores : getProfessores()){
            retorno = retorno + professores.toString();
        }
        return retorno;
    }
    public String listarReservas(){
        String retorno = "";
        if(reservas.isEmpty()){
            return "Não há reservas cadastradas!";
        }
        retorno = "***** Reservas *****\n";
        for(Reserva reserva : reservas){
            retorno = retorno + reserva.toString();
        }
        return retorno;
    }

    public String listarReservasPorCliente(String CPF){
        String retorno = "";
        try {
            if (this.clientes == null) {
                throw new IllegalArgumentException("Lista vazia!");
            }
            retorno = "***** Reservas *****\n";
            for(Cliente cliente : clientes){
                if(cliente.getCpf().equals(CPF)){
                    for(Reserva reserva : reservas){
                        if(reserva.getCliente().getCpf().equals(CPF)){
                            retorno = retorno + reserva.toString();
                        }
                    }
                }
            }
            return retorno;
        } catch (IllegalArgumentException e) {
            return "Erro: " + e.getMessage();
        }
    }
    public String listarEmprestimosPorCliente(String CPF){
        String retorno = "";
        try {
            if (this.clientes == null) {
                throw new IllegalArgumentException("Lista vazia!");
            }
            retorno = "***** Emprestimos *****\n";
            for(Cliente cliente : clientes){
                if(cliente.getCpf().equals(CPF)){
                    for(Emprestimo emprestimo : emprestimos){
                        if(emprestimo.getCliente().getCpf().equals(CPF)){
                            retorno = retorno + emprestimo.toString();
                        }
                    }
                }
            }
            return retorno;
        } catch (IllegalArgumentException e) {
            return "Erro: " + e.getMessage();
        }
    }
    //public void listarEmprestimosAtrasados(){}
    public String listarEmprestimos(){
        String retorno = "";
        try {
            if (this.emprestimos == null) {
                throw new IllegalArgumentException("Lista vazia!");
            }
            if(emprestimos.isEmpty()){
                return "Não há emprestimos cadastrados!";
            }
            retorno = "***** Emprestimos *****";
            for(Emprestimo emprestimo : emprestimos){
                retorno = retorno + emprestimo.toString();
            }
            return retorno;
        } catch (IllegalArgumentException e) {
            return "Erro: " + e.getMessage();
        }
    }
    public String pesquisarItem(String titulo){ //QUESTÃO DO RETURN
        try {
            if (this.itens == null) {
                throw new IllegalArgumentException("Lista vazia!");
            }
            for(Item item : itens){
                if(item.getTitulo().equals(titulo)){
                    return "Item encontrado!" + item.toString();
                }
            }
            return "Item não encontrado!";
        } catch (IllegalArgumentException e) {
            return "Erro: " + e.getMessage();
        }
    }
    public String UltimasAquisicoes(){
        String retorno = "";
        try {
            if (this.itens == null) {
                throw new IllegalArgumentException("Lista vazia!");
            }
            if(itens.isEmpty()){
                return "Não há itens cadastrados!";
            }
            System.out.println("***** Ultimas Aquisições *****");
            //Faz a listagens dos ultimos 3 itens adicionados
            for(int i = 0; i < 2; i++){
                retorno = retorno + itens.get(i).toString();
            }
            return retorno;
        } catch (IllegalArgumentException e) {
            return "Erro: " + e.getMessage();
        }
    }
    public String excluirAssinatura(String CPF){
        for(Cliente cliente : clientes){
            if(cliente.getCpf().equals(CPF)){
                if(cliente instanceof Estudantes){
                    Estudantes estudante = (Estudantes) cliente;
                    estudante.setAssinatura("Básico");
                    return "Assinatura excluida com sucesso!";
                }
                if(cliente instanceof Professores){
                    Professores professor = (Professores) cliente;
                    professor.setAssinatura("Básico");
                    return "Assinatura excluida com sucesso!";
                }
            }
        }
        return "Cliente não encontrado!";
    }
    public String gerarAssinatura(String CPF, String assinatura){
        for(Cliente cliente : clientes){
            if(cliente.getCpf().equals(CPF)){
                if(cliente instanceof Estudantes){
                    Estudantes estudante = (Estudantes) cliente;
                    estudante.setAssinatura(assinatura);
                    return "Assinatura gerada com sucesso!";
                }
                if(cliente instanceof Professores){
                    Professores professor = (Professores) cliente;
                    professor.setAssinatura(assinatura);
                    return "Assinatura gerada com sucesso!";
                }
            }
        }
        return "Cliente não encontrado!";
    }
    //Metodos para atualizar emprestimos e reservas depois de um certo tempo.


    //toString
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("Nome: " + this.nome);
        joiner.add("CNPJ: " + this.CNPJ);
        joiner.add("Endereço: " + this.endereco);
        joiner.add("Telefone: " + this.telefone);
        joiner.add("Lista de itens: " + this.itens);
        joiner.add("Lista de clientes: " + this.clientes);
        joiner.add("Lista de emprestimos: " + this.emprestimos);
        joiner.add("Lista de reservar: " + this.reservas);

        return joiner.toString();
    }
}
