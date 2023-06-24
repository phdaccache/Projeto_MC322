package pacote;

import java.util.ArrayList;

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

    //toString
    @Override
    public String toString() {
        return "Biblioteca [nome=" + nome + ", CNPJ=" + CNPJ + ", endereco=" + endereco + ", telefone=" + telefone
                + ", itens=" + itens + ", clientes=" + clientes + ", emprestimos=" + emprestimos + ", reservas="
                + reservas + "]";
    }
}
