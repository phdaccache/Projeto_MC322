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
            for(Estudante estudante : getEstudantes()){
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
            for(Professor professor : getProfessores()){
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
        //     throw new IllegalArgumentException("O cliente possui emprestimos pendentes");
        // }

        // Caso em que o cliente possui reservas pendentes
        // if (cliente.getReservasPendentes().size() > 0) {
        //     throw new IllegalArgumentException("O cliente possui reservas pendentes");
        // }

        // Exclusao do cliente
        clientes.remove(cliente);
        return "Cliente excluído!\n";
    }

    /////////////////////////////////// ITENS ///////////////////////////////////

    public String cadastrarLivro(int code, int qtdDePaginas, String status, String titulo, String autores, ArrayList<Reserva> listaReservas, int ano, String editora, int ISBN, String edicao, String tema){
        Livro livro = new Livro(code, qtdDePaginas, titulo, autores, ano, editora, ISBN, edicao, tema);
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
        Artigo artigo = new Artigo(code, qtdDePaginas, titulo, autores, ano, DOI, abstractArtigo, keywords);
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
    public String cadastrarRevista(int code, int qtdDePaginas, String status, String titulo, String autor, int ano, int edicao, String instituicao, String assuntos, int ISSN) {
        Revista revista = new Revista(code, qtdDePaginas, titulo, autor, ano, edicao, instituicao, assuntos, ISSN);
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
        Emprestimo emprestimo = new Emprestimo(item, data_ini, data_lim, cliente);
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

    public String removerItem(String Titulo) {
        System.out.println("***** Removendo item *****");
        try {
            if (this.itens == null) {
                throw new IllegalArgumentException("Lista vazia!");
            }
            for (Item item : this.itens) {
                if (item.getTitulo().equals(Titulo)) {
                    this.itens.remove(item);
                    //removerEmprestimoPorItem(Titulo);
                    //removerReservasPorItem(Titulo);
                    return "Item removido com sucesso!";
                }
            }
            return "Item não encontrado!";
        } catch (IllegalArgumentException e) {
            return "Erro: " + e.getMessage();
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
                if(cliente.getCPF().equals(CPF)){
                    for(Reserva reserva : reservas){
                        if(reserva.getCliente().getCPF().equals(CPF)){
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
                if(cliente.getCPF().equals(CPF)){
                    for(Emprestimo emprestimo : emprestimos){
                        if(emprestimo.getCliente().getCPF().equals(CPF)){
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

    public String excluirAssinatura(String CPF){
        for(Cliente cliente : clientes){
            if(cliente.getCPF().equals(CPF)){
                if(cliente instanceof Estudante){
                    Estudante estudante = (Estudante) cliente;
                    estudante.setAssinatura("Básico");
                    return "Assinatura excluida com sucesso!";
                }
                if(cliente instanceof Professor){
                    Professor professor = (Professor) cliente;
                    professor.setAssinatura("Básico");
                    return "Assinatura excluida com sucesso!";
                }
            }
        }
        return "Cliente não encontrado!";
    }
    public String gerarAssinatura(String CPF, String assinatura){
        for(Cliente cliente : clientes){
            if(cliente.getCPF().equals(CPF)){
                if(cliente instanceof Estudante){
                    Estudante estudante = (Estudante) cliente;
                    estudante.setAssinatura(assinatura);
                    return "Assinatura gerada com sucesso!";
                }
                if(cliente instanceof Professor){
                    Professor professor = (Professor) cliente;
                    professor.setAssinatura(assinatura);
                    return "Assinatura gerada com sucesso!";
                }
            }
        }
        return "Cliente não encontrado!";
    }


    // Getters para as listas
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