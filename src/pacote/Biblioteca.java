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
    public void cadastrarEstudantes(String CPF, int multa, String nome, String telefone, String email, Date dataNasc, String ID, String senha, String status, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Reserva> listaReservasItens, String matricula, String curso, int ano_grad) {
        Estudantes estudante = new Estudantes(CPF, multa, nome, telefone, email, dataNasc, ID, senha, status, listaEmprestimos, listaReservasItens, matricula, curso, ano_grad);
        this.clientes.add(estudante);
    }
    public void cadastrarProfessores(String CPF, int multa, String nome, String telefone, String email, Date dataNasc, String ID, String senha, String status, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Reserva> listaReservasItens, String instituicao, String educacao, String area, String aulas, int ano_ing) {
        Professores professor = new Professores(CPF, multa, nome, telefone, email, dataNasc, ID, senha, status, listaEmprestimos, listaReservasItens, instituicao, educacao, area, aulas, ano_ing);
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

    //Metodos para atualizar emprestimos e reservas depois de um certo tempo.


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
