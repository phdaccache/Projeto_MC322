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

    //Construtor
    public Biblioteca(String nome, String CNPJ, String endereco, String telefone, ArrayList<Item> itens, ArrayList<Cliente> clientes, ArrayList<Emprestimo> emprestimos, ArrayList<Reserva> reservas) {
    	Scanner entrada = new Scanner(System.in);
    	this.nome = nome;
        this.CNPJ = CNPJ;
        this.endereco = endereco;
        this.telefone = telefone;
        this.itens = itens;
        this.clientes = clientes;
        this.emprestimos = emprestimos;
        this.reservas = reservas;
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

    //Métodos
    public void cadastrarEstudantes(Biblioteca biblioteca, String CPF, int multa, String nome, String telefone, String email, LocalDate dataNasc, String ID, String senha, String assinatura, String status, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Reserva> listaReservasItens, String matricula, String curso, int ano_grad) {
        Estudantes estudante = new Estudantes(biblioteca, CPF, multa, nome, telefone, email, dataNasc, ID, senha, assinatura, status, listaEmprestimos, listaReservasItens, matricula, curso, ano_grad);
        this.clientes.add(estudante);
    }
    public void cadastrarProfessores(Biblioteca biblioteca, String CPF, int multa, String nome, String telefone, String email, LocalDate dataNasc, String ID, String senha, String assinatura, String status, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Reserva> listaReservasItens, String instituicao, String educacao, String area, String aulas, int ano_ing) {
        Professores professor = new Professores(biblioteca, CPF, multa, nome, telefone, email, dataNasc, ID, senha, assinatura, status, listaEmprestimos, listaReservasItens, instituicao, educacao, area, aulas, ano_ing);
        this.clientes.add(professor);
    }
    public void cadastrarLivro(int code, int qtdDePaginas, String status, String titulo, String autores, ArrayList<Reserva> listaReservas, int ano, String editora, int ISBN, String edicao, String tema){
        Livro livro = new Livro(code, qtdDePaginas, status, titulo, autores, listaReservas, ano, editora, ISBN, edicao, tema);
        this.itens.add(livro);
    }
    public void cadastrarArtigo(int code, int qtdDePaginas, String status, String titulo, String autores, ArrayList<Reserva> listaReservas, int ano, int DOI, String abstractArtigo, String keywords){
        Artigo artigo = new Artigo(code, qtdDePaginas, status, titulo, autores, listaReservas, ano, DOI, abstractArtigo, keywords);
        this.itens.add(artigo);
    }
    public void cadastrarRevista(int code, int qtdDePaginas, String status, String titulo, String autores, ArrayList<Reserva> listaReservas, int ano, int edicao, String instituicao, ArrayList<String> assuntos, int ISSN) {
        Revista revista = new Revista(code, qtdDePaginas, status, titulo, autores, listaReservas, ano, edicao, instituicao, assuntos, ISSN);
        this.itens.add(revista);
    }
    public void cadastrarEmprestimo(Item item, LocalDate data_ini, LocalDate data_lim, Cliente cliente) {
        Emprestimo emprestimo = new Emprestimo(item, data_ini, data_lim, cliente);
        this.emprestimos.add(emprestimo);
    }
    public void cadastrarReserva(Item item, LocalDate data, Cliente cliente, int posicao) {
        Reserva reserva = new Reserva(item, data, cliente, posicao);
        this.reservas.add(reserva);
    }
    public void removerCliente(String CPF) {
        System.out.println("***** Removendo cliente *****");
        for (Cliente cliente : this.clientes) {
            if (cliente.getCpf().equals(CPF)) {
                this.clientes.remove(cliente);
                System.out.println("Cliente removido com sucesso!");
                removerEmprestimoPorCliente(CPF);
                removerReservasPorCliente(CPF);
                return;
            }
        }
        System.out.println("Cliente não encontrado!");
    }
    public void removerItem(String Titulo) {
        System.out.println("***** Removendo item *****");
        for (Item item : this.itens) {
            if (item.getTitulo().equals(Titulo)) {
                this.itens.remove(item);
                System.out.println("Item removido com sucesso!");
                removerEmprestimoPorItem(Titulo);
                removerReservasPorItem(Titulo);
                return;
            }
        }
        System.out.println("Item não encontrado!");
    }
    public void removerEmprestimoPorCliente(String CPF) {
        int i = 0;
        for (Emprestimo emprestimo : this.emprestimos) {
            i++;
            if (emprestimo.getCliente().getCpf().equals(CPF)) {
                this.emprestimos.remove(emprestimo);
                if(i == emprestimos.size()){
                    System.out.println("Emprestimos removidos com sucesso!");
                    return;
                }
            }
        }
        System.out.println("Emprestimos não encontrados!");
        return;
    }
    public void removerEmprestimoPorItem(String Titulo) {
        int i = 0;
        for (Emprestimo emprestimo : this.emprestimos) {
            i++;
            if (emprestimo.getItem().getTitulo().equals(Titulo)) {
                this.emprestimos.remove(emprestimo);
                if(i == emprestimos.size()){
                    System.out.println("Emprestimos removidos com sucesso!");
                    return;
                }
            }
        }
        System.out.println("Emprestimos não encontrados!");
        return;
    }
    public void removerReservasPorCliente(String CPF) {
        int i = 0;
        for (Reserva reserva : this.reservas) {
            i++;
            if (reserva.getCliente().getCpf().equals(CPF)) {
                this.reservas.remove(reserva);
                if(i == reservas.size()){
                    System.out.println("Reservas removidas com sucesso!");
                    return;
                }
            }
        }
        System.out.println("Reservas não encontradas!");
        return;
    }
    public void removerReservasPorItem(String Titulo) {
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
    }

    //Retorna uma lista de itens especificos
    public Item getItem(String titulo){
        for(Item item : itens){
            if(item.getTitulo().equals(titulo)){
                return item;
            }
        }
        System.out.println("Item não encontrado!");
        return null;
    }
    public ArrayList<Livro> getlivros(){
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
    }
    public ArrayList<Artigo> getArtigos(){
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
    }
    public ArrayList<Revista> getRevistas(){
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
    }
    public ArrayList<Estudantes> getEstudantes(){
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
    }
    public ArrayList<Professores> getProfessores(){
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
    }

    public void listarItens(){
        if(itens.isEmpty()){
            System.out.println("Não há itens cadastrados!");
            return;
        }
        for(Livro livro : getlivros()){
            System.out.println("***** Livros *****");
            System.out.println(livro.toString());
        }
        for(Artigo artigo : getArtigos()){
            System.out.println("***** Artigos *****");
            System.out.println(artigo.toString());
        }
        for (Revista revista : getRevistas()){
            System.out.println("***** Revistas *****");
            System.out.println(revista.toString());
        }
        return;
    }
    public void listarLivros(){
        if(getlivros() == null){
            System.out.println("Não há livros cadastrados!");
            return;
        }
        for(Livro livro : getlivros()){
            System.out.println("***** Livros *****");
            System.out.println(livro.toString());
        }
        return;
    }
    public void listarRevistas(){
        if(getRevistas() == null){
            System.out.println("Não há revistas cadastradas!");
            return;
        }
        for(Revista revista : getRevistas()){
            System.out.println("***** Revistas *****");
            System.out.println(revista.toString());
        }
        return;
    }
    public void listarArtigos(){
        if(getArtigos() == null){
            System.out.println("Não há artigos cadastrados!");
            return;
        }
        for(Artigo artigo : getArtigos()){
            System.out.println("***** Artigos *****");
            System.out.println(artigo.toString());
        }
        return;
    }
    public void listarClientes(){
        if(clientes.isEmpty()){
            System.out.println("Não há clientes cadastrados!");
            return;
        }
        for(Estudantes estudantes : getEstudantes()){
            System.out.println("***** Estudantes *****");
            System.out.println(estudantes.toString());
        }
        for(Professores professores : getProfessores()){
            System.out.println("***** Professores *****");
            System.out.println(professores.toString());
        }
        return;
    }
    public void listarReservas(){
        if(reservas.isEmpty()){
            System.out.println("Não há reservas cadastradas!");
            return;
        }
        for(Reserva reserva : reservas){
            System.out.println("***** Reservas *****");
            System.out.println(reserva.toString());
        }
        return;
    }

    public void listarReservasPorCliente(String CPF){
        for(Cliente cliente : clientes){
            if(cliente.getCPF().equals(CPF)){
                for(Reserva reserva : reservas){
                    if(reserva.getCliente().getCPF().equals(CPF)){
                        System.out.println("***** Reservas *****");
                        System.out.println(reserva.toString());
                    }
                }
                return;
            }
        }
    }
    public void listarEmprestimosPorCliente(String CPF){
        for(Cliente cliente : clientes){
            if(cliente.getCPF().equals(CPF)){
                for(Emprestimo emprestimo : emprestimos){
                    if(emprestimo.getCliente().getCPF().equals(CPF)){
                        System.out.println("***** Emprestimos *****");
                        System.out.println(emprestimo.toString());
                    }
                }
                return;
            }
        }
    }

    //public void listarEmprestimosAtrasados(){}
    public void listarEmprestimos(){
        if(emprestimos.isEmpty()){
            System.out.println("Não há emprestimos cadastrados!");
            return;
        }
        for(Emprestimo emprestimo : emprestimos){
            System.out.println("***** Emprestimos *****");
            System.out.println(emprestimo.toString());
        }
        return;
    }

    public Item pesquisarItem(String titulo){
        for(Item item : itens){
            if(item.getTitulo().equals(titulo)){
                System.out.println("Item encontrado!");
                //item.toString(); Talvez?
                return item;
            }
        }
        System.out.println("Item não encontrado!");
        return null;
    }
    public void UltimasAquisicoes(){
        if(itens.isEmpty()){
            System.out.println("Não há itens cadastrados!");
            return;
        }
        System.out.println("***** Ultimas Aquisições *****");
        //Faz a listagens dos ultimos 3 itens adicionados
        for(int i = 0; i < 2; i++){
            itens.get(i).toString();
        }
        return;
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
