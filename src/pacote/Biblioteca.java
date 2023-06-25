package pacote;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        this.nome = nome;
        this.CNPJ = CNPJ;
        this.endereco = endereco;
        this.telefone = telefone;
        this.itens = itens;
        this.clientes = clientes;
        this.emprestimos = emprestimos;
        this.reservas = reservas;
    }

    //Getters e setters

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCNPJ() {
        return CNPJ;
    }
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
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
    public void cadastrarEstudantes(String CPF, String nome, String telefone, String email, Date dataNasc, String ID, String senha, String status, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Reserva> listaReservasItens, String Matricula, String curso, int ano_grad){
        Estudantes estudante = new Estudantes(CPF, nome, telefone, email, dataNasc, ID, senha, status, listaEmprestimos, listaReservasItens, Matricula, curso, ano_grad);
        this.clientes.add(estudante);
    }
    public void cadastrarProfessores(String CPF, String nome, String telefone, String email, Date dataNasc, String ID, String senha, String status, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Reserva> listaReservasItens, String instituicao, String educacao, String area, String aulas, int ano_ing) {
        Professores professor = new Professores(CPF, nome, telefone, email, dataNasc, ID, senha, status, listaEmprestimos, listaReservasItens, instituicao, educacao, area, aulas, ano_ing);
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
    public void cadastrarEmprestimo(Item item, Date data_ini, Date data_lim, Cliente cliente, String code) {
        Emprestimo emprestimo = new Emprestimo(item, data_ini, data_lim, cliente, code);
        this.emprestimos.add(emprestimo);
    }
    public void cadastrarReserva(Item item, Date data, Cliente cliente, String code, String posicao) {
        Reserva reserva = new Reserva(item, data, cliente, code, posicao);
        this.reservas.add(reserva);
    }

    //toString
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("Nome: " + this.nome);
        joiner.add("CNPJ: " + this.CNPJ);
        joiner.add("Endereço: " + this.endereco);
        joiner.add("Telefone: " + this.telefone);

        return joiner.toString();
    }
}
