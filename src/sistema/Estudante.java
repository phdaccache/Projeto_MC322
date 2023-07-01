package sistema;

import java.time.LocalDate;
import java.util.StringJoiner;

public class Estudante extends Cliente {
	// Atributos
	private String matricula;
	private String curso;
	private int ano_grad; // ano limite de graduacao
	
	//Construtor
	public Estudante(Biblioteca biblioteca, String CPF, String nome, String telefone, String email, LocalDate dataNasc, String senha, String assinatura, String matricula, String curso, int ano_grad) {
		super(biblioteca, CPF, nome, telefone, email, dataNasc, senha, assinatura);
		this.matricula = matricula;
		this.curso = curso;
		this.ano_grad = ano_grad;
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");
		joiner.add(super.toString());
		if (matricula != null) {
		    joiner.add("Matrícula: " + this.matricula);
		} else {
			joiner.add("Matrícula: Não especificada");
		}
		if (curso != null) {
		    joiner.add("Curso: " + this.curso);
		} else {
			joiner.add("Curso: Não especificado");
		}
		if (ano_grad != -1) {
		    joiner.add("Ano de Graduação: " + this.ano_grad);
		} else {
			joiner.add("Ano de Graduação: Não especificado");
		}
		return joiner.toString();
	}

	public String editarDados(String cpf, String nome, String telefone, String email, LocalDate dataNasc, String senha, String matricula, String curso, int ano_grad) {
		// Caso em que o CPF e invalido
        if (!Validacao.validarDocumento(cpf, "CPF")) {
            throw new IllegalArgumentException("CPF inválido");
        }

        // Caso em que o CPF ja existe
        for (Cliente cliente : getBiblioteca().getClientes()) {
            if (cliente.getCPF().equals(cpf)) {
                throw new IllegalArgumentException("Já existe o cliente de CPF " + cpf);
            }
        }

        // Caso em que o nome e invalido
        if (!Validacao.validarNome(nome)) {
            throw new IllegalArgumentException("Nome inválido");
        }

        // Edicao dos dados
		setCPF(cpf);
		setNome(nome);
		setTelefone(telefone);
		setEmail(email);
		setDataNasc(dataNasc);
		setSenha(senha);
		setMatricula(matricula);
		setCurso(curso);
		setAno_grad(ano_grad);
        
        return "Dados atualizados!\n";
	}
	

	// Getters e Setters
	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return this.curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getAno_grad() {
		return this.ano_grad;
	}

	public void setAno_grad(int ano_grad) {
		this.ano_grad = ano_grad;
	}
}