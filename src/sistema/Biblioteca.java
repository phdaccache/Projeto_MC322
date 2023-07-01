package sistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.StringJoiner;


public class Biblioteca {
    // Atributos
    private String nome;
    private String CNPJ;
    private String endereco;
    private String telefone;
    private String senha;
    private ArrayList<Item> itens;
    private ArrayList<Cliente> clientes;
    private ArrayList<Emprestimo> emprestimos;
    private ArrayList<Reserva> reservas;

    // Construtor
    public Biblioteca(String nome, String CNPJ, String endereco, String telefone, String senha) {
    	this.nome = nome;
        this.CNPJ = CNPJ;
        this.endereco = endereco;
        this.telefone = telefone;
        this.senha = senha;
        this.itens = new ArrayList<Item>();
        this.clientes = new ArrayList<Cliente>();
        this.emprestimos = new ArrayList<Emprestimo>();
        this.reservas = new ArrayList<Reserva>();
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("Nome: " + getNome());
        joiner.add("CNPJ: " + getCNPJ());
        joiner.add("Endereço: " + getEndereco());
        joiner.add("Telefone: " + getTelefone());
        joiner.add("Quantidade de Itens: " + getItens().size());
        joiner.add("Quantidade de Clientes: " + getClientes().size());
        joiner.add("Quantidade de Empréstimos: " + getEmprestimos().size());
        joiner.add("Quantidade de Reservas: " + getReservas().size());

        return joiner.toString();
    }

    /////////////////////////////////// MINHA CONTA ///////////////////////////////////

    public String visualizarDados() {
        return toString();
    }

    public String editarDados(String nome, String cnpj, String endereco, String telefone, String senha) {
        // Caso em que o CNPJ e invalido
        if (!Validacao.validarDocumento(cnpj, "CNPJ")) {
            throw new IllegalArgumentException("CNPJ invalido");
        }

        // Caso em que o CNPJ ja existe
        for (Biblioteca biblioteca : Admin.listaBibliotecas) {
            if (biblioteca.getCNPJ().equals(cnpj) && !biblioteca.getCNPJ().equals(getCNPJ())) {
                throw new IllegalArgumentException("Ja existe a biblioteca de CNPJ " + cnpj);
            }
        }

        // Edicao dos dados
        setNome(nome);
        setCNPJ(cnpj);
        setEndereco(endereco);
        setTelefone(telefone);
        setSenha(senha);
        return "Dados atualizados!\n";
    }

    public String excluirConta() {
        try {
            Admin.excluirBiblioteca(getCNPJ());
            return "Conta excluída!\n";
        } catch (IllegalArgumentException erro) {
            throw erro;
        }
    }

    /////////////////////////////////// CLIENTES ///////////////////////////////////

    public String listarClientes(){
        String string = "";
        if(clientes == null || clientes.isEmpty()){
            string += "Não há clientes cadastrados.\n";
        } 
        
        else {
            string += "Estudantes:\n";
            string += listarEstudantes();
            string += "\n";
            string += "Professores:\n";
            string += listarProfessores();
        }
        return string;
    }

    public String listarEstudantes(){
        String string = "";
        ArrayList<Estudante> estudantes = getEstudantes();

        if(estudantes == null || estudantes.isEmpty()){
            string += "Não há estudantes cadastrados.\n";
        }

        else {
            for(Estudante estudante : estudantes){
                string += "---------------------------------------------\n";
                string += (estudante + "\n");
            }
            string += "---------------------------------------------\n";
        }


        return string;
    }

    public String listarProfessores(){
        String string = "";
        ArrayList<Professor> professores = getProfessores();

        if(professores == null || professores.isEmpty()){
            string += "Não há professores cadastrados.\n";
        }

        else {
            for(Professor professor : professores){
                string += "---------------------------------------------\n";
                string += (professor + "\n");
            }
            string += "---------------------------------------------\n";
        }


        return string;
    }

    public String cadastrarEstudante(String CPF, String nome, String telefone, String email, LocalDate dataNasc, String senha, String assinatura, String matricula, String curso, int ano_grad) {
        // Caso em que o CPF e invalido
        if (!Validacao.validarDocumento(CPF, "CPF")) {
            throw new IllegalArgumentException("CPF invalido");
        }

        // Caso em que o CPF ja existe
        for (Cliente cliente : clientes) {
            if (cliente.getCPF().equals(CPF)) {
                throw new IllegalArgumentException("Ja existe o cliente de CPF " + CPF);
            }
        }

        // Caso em que o nome e invalido
        if (!Validacao.validarNome(nome)) {
            throw new IllegalArgumentException("Nome invalido");
        }

        // Cadastro do estudante
        Estudante estudante = new Estudante(this, CPF, nome, telefone, email, dataNasc, senha, assinatura, matricula, curso, ano_grad);
        clientes.add(estudante);
        return "Estudante cadastrado!\n";
    }

    public String cadastrarProfessor(String CPF, String nome, String telefone, String email, LocalDate dataNasc, String senha, String assinatura, String instituicao, String educacao, String area, String aulas, int ano_ing) {
        // Caso em que o CPF e invalido
        if (!Validacao.validarDocumento(CPF, "CPF")) {
            throw new IllegalArgumentException("CPF invalido");
        }

        // Caso em que o CPF ja existe
        for (Cliente cliente : clientes) {
            if (cliente.getCPF().equals(CPF)) {
                throw new IllegalArgumentException("Ja existe o cliente de CPF " + CPF);
            }
        }

        // Caso em que o nome e invalido
        if (!Validacao.validarNome(nome)) {
            throw new IllegalArgumentException("Nome invalido");
        }

        // Cadastro do professor
        Professor professor = new Professor(this, CPF, nome, telefone, email, dataNasc, senha, assinatura, instituicao, educacao, area, aulas, ano_ing);
        clientes.add(professor);
        return "Professor cadastrado!\n";
    }

    public String excluirCliente(String CPF) {
        Cliente cliente = getCliente(CPF);

        // Caso em que o cliente nao existe
        if (cliente == null) {
            throw new IllegalArgumentException("Nao existe o cliente de CPF " + CPF);
        }

        // Caso em que o cliente possui emprestimos pendentes
        // if (cliente.getEmprestimosPendentes().size() > 0) {
        //     throw new IllegalArgumentException("O cliente possui empréstimos pendentes");
        // }

        // Caso em que o cliente possui reservas pendentes
        // if (cliente.getReservasPendentes().size() > 0) {
        //     throw new IllegalArgumentException("O cliente possui reservas pendentes");
        // }

        // Exclusao do cliente
        clientes.remove(cliente);
        return "Cliente excluído!\n";
    }

    public String listarAssinaturas() {
        String string = "";
        boolean temAssinatura = false;

        for(Cliente cliente: clientes){
            if (!cliente.getAssinatura().equals("Básico")) {
                temAssinatura = true;
                string += "---------------------------------------------\n";
                string += String.format("Cliente: %s\n", cliente.getNome());
                string += String.format("CPF: %s\n", cliente.getCPF());
                string += String.format("Assinatura: %s\n", cliente.getAssinatura());
            }
        }
        if (!temAssinatura) {
            string += "Não há assinaturas ativas.\n";
        } else {
            string += "---------------------------------------------\n";
        }

        return string;
    }

    public String atualizarAssinatura(String CPF, String assinatura) {
        for(Cliente cliente : clientes){
            if(cliente.getCPF().equals(CPF)){
                cliente.setAssinatura(assinatura);
                return "Assinatura atualizada!";
            }
        }
        throw new IllegalArgumentException("Cliente não encontrado");
    }

    /////////////////////////////////// ITENS ///////////////////////////////////

    public String pesquisarItem(String titulo) {
        String string = "";

        for(Item item: itens){
            if (item.getTitulo().equals(titulo)) {
                string += (item + "\n");
                return string;
            }
        }
        
        throw new IllegalArgumentException("Item não encontrado");
    }

    public String listarItens(){
        String string = "";
        if(itens == null || itens.isEmpty()){
            string += "Não há itens cadastrados.\n";
        } 
        
        else {
            string += "Livros:\n";
            string += listarLivros();
            string += "\n";
            string += "Apostilas:\n";
            string += listarApostilas();
            string += "\n";
            string += "Artigos:\n";
            string += listarArtigos();
            string += "\n";
            string += "Revistas:\n";
            string += listarRevistas();
        }
        return string;
    }

    public String listarLivros(){
        String string = "";
        ArrayList<Livro> livros = getLivros();

        if(livros == null || livros.isEmpty()){
            string += "Não há livros cadastrados.\n";
        }

        else {
            for(Livro livro : getLivros()){
                string += "---------------------------------------------\n";
                string += (livro + "\n");
            }
            string += "---------------------------------------------\n";
        }


        return string;
    }

    public String listarApostilas() {
        String string = "";
        ArrayList<Apostila> apostilas = getApostilas();

        if(apostilas == null || apostilas.isEmpty()){
            string += "Não há apostilas cadastradas.\n";
        }

        else {
            for(Apostila apostila : getApostilas()){
                string += "---------------------------------------------\n";
                string += (apostila + "\n");
            }
            string += "---------------------------------------------\n";
        }


        return string;
    }

    public String listarArtigos(){
        String string = "";
        ArrayList<Artigo> artigos = getArtigos();

        if(artigos == null || artigos.isEmpty()){
            string += "Não há artigos cadastrados.\n";
        }

        else {
            for(Artigo artigo : getArtigos()){
                string += "---------------------------------------------\n";
                string += (artigo + "\n");
            }
            string += "---------------------------------------------\n";
        }


        return string;
    }

    public String listarRevistas(){
        String string = "";
        ArrayList<Revista> revistas = getRevistas();

        if(revistas == null || revistas.isEmpty()){
            string += "Não há revistas cadastradas.\n";
        }

        else {
            for(Revista revista : getRevistas()){
                string += "---------------------------------------------\n";
                string += (revista + "\n");
            }
            string += "---------------------------------------------\n";
        }


        return string;
    }

    public String cadastrarLivro(int qtdDePaginas, String titulo, String autor, int ano, String editora, int ISBN, String edicao, String tema){
        // Caso em que o ISBN ja existe
        for (Item item : itens) {
            if (item.getCode() == ISBN) {
                throw new IllegalArgumentException("Ja existe o item de ISBN " + ISBN);
            }
        }

        // Cadastro do item
        Item item = new Livro(qtdDePaginas, titulo, autor, ano, editora, ISBN, edicao, tema);
        itens.add(item);
        return "Livro cadastrado!\n";
    }

    public String cadastrarApostila(int qtdDePaginas, String titulo, String autor, int ano, String disciplina, String instituicao) {
        Apostila apostila = new Apostila(qtdDePaginas, titulo, autor, ano, disciplina, instituicao);
        itens.add(apostila);
        return "Apostila cadastrada!\n";
    }

    public String cadastrarArtigo(int qtdDePaginas, String titulo, String autor, int ano, int DOI, String abstractArtigo, String keywords){
        // Caso em que o DOI ja existe
        for (Item item : itens) {
            if (item.getCode() == DOI) {
                throw new IllegalArgumentException("Ja existe o item de DOI " + DOI);
            }
        }

        // Cadastro do item
        Item item = new Artigo(qtdDePaginas, titulo, autor, ano, DOI, abstractArtigo, keywords);
        itens.add(item);
        return "Artigo cadastrado!\n";
    }

    public String cadastrarRevista(int qtdDePaginas, String titulo, String autor, int ano, String edicao, String instituicao, String assuntos, int ISSN) {
        // Caso em que o ISSN ja existe
        for (Item item : itens) {
            if (item.getCode() == ISSN) {
                throw new IllegalArgumentException("Ja existe o item de ISSN " + ISSN);
            }
        }

        // Cadastro do item
        Item item = new Revista(qtdDePaginas, titulo, autor, ano, edicao, instituicao, assuntos, ISSN);
        itens.add(item);
        return "Revista cadastrada!\n";
    }

    public String excluirItem(int code) {
        return "";
    }

    /////////////////////////////////// EMPRESTIMOS ///////////////////////////////////

    public String listarEmprestimos(){
        String string = "";
        ArrayList<Emprestimo> emprestimos = getEmprestimos();

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

    public String listarEmprestimosPorCliente(String CPF){
        Cliente cliente = getCliente(CPF);
        String string = "";

        // Caso em que o cliente nao existe
        if(cliente == null){
            throw new IllegalArgumentException("Cliente nao existe");
        }

        ArrayList<Emprestimo> emprestimos = getEmprestimosPorCliente(CPF);

        if(emprestimos == null || emprestimos.isEmpty()){
            string += "Não há empréstimos cadastrados para esse cliente.\n";
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
    
    /////////////////////////////////// RESERVAS ///////////////////////////////////
    
    public String listarReservas(){
        String string = "";
        ArrayList<Reserva> reservas = getReservas();

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

    public String listarReservasPorCliente(String CPF){
        Cliente cliente = getCliente(CPF);
        String string = "";

        // Caso em que o cliente nao existe
        if(cliente == null){
            throw new IllegalArgumentException("Cliente nao existe");
        }

        ArrayList<Reserva> reservas = getReservasPorCliente(CPF);

        if(reservas == null || reservas.isEmpty()){
            string += "Não há reservas cadastradas para esse cliente.\n";
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


    /////////////////////////////////// GETTERS PARA OBJETOS ///////////////////////////////////

    public ArrayList<Estudante> getEstudantes(){
        ArrayList<Estudante> estudantes = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente instanceof Estudante) {
                estudantes.add((Estudante)cliente);
            }
        }
        return estudantes;
    }

    public ArrayList<Professor> getProfessores(){
        ArrayList<Professor> professores = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente instanceof Professor) {
                professores.add((Professor)cliente);
            }
        }
        return professores;
    }

    public Cliente getCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCPF().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

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

    public ArrayList<Livro> getLivros(){
        ArrayList<Livro> livros = new ArrayList<>();
        for (Item item : itens) {
            if (item instanceof Livro) {
                livros.add((Livro)item);
            }
        }
        return livros;
    }

    public ArrayList<Apostila> getApostilas() {
        ArrayList<Apostila> apostilas = new ArrayList<>();
        for (Item item : itens) {
            if (item instanceof Apostila) {
                apostilas.add((Apostila)item);
            }
        }
        return apostilas;
    }

    public ArrayList<Artigo> getArtigos(){
        ArrayList<Artigo> artigos = new ArrayList<>();
        for (Item item : itens) {
            if (item instanceof Artigo) {
                artigos.add((Artigo)item);
            }
        }
        return artigos;
    }

    public ArrayList<Revista> getRevistas(){
        ArrayList<Revista> revistas = new ArrayList<>();
        for (Item item : itens) {
            if (item instanceof Revista) {
                revistas.add((Revista)item);
            }
        }
        return revistas;
    }

    public ArrayList<Emprestimo> getEmprestimosAtrasados() {
        ArrayList<Emprestimo> emprestimosAtrasados = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.isAtrasado()) {
                emprestimosAtrasados.add(emprestimo);
            }
        }
        return emprestimosAtrasados;
    }

    public ArrayList<Emprestimo> getEmprestimosPorCliente(String CPF) {
        ArrayList<Emprestimo> emprestimosPorCliente = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getCliente().getCPF().equals(CPF)) {
                emprestimosPorCliente.add(emprestimo);
            }
        }
        return emprestimosPorCliente;
    }

    public ArrayList<Reserva> getReservasPorCliente(String CPF) {
        ArrayList<Reserva> reservasPorCliente = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().getCPF().equals(CPF)) {
                reservasPorCliente.add(reserva);
            }
        }
        return reservasPorCliente;
    }
  
    // Getters e Setters
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJ() {
        return this.CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<Item> getItens() {
        return this.itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return this.emprestimos;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public ArrayList<Reserva> getReservas() {
        return this.reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }
}