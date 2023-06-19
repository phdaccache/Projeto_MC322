package menu;

public enum SubmenuCliente {
    // Minha Conta
    VISUALIZAR_DADOS("Visualizar Dados"),
    EDITAR_DADOS("Editar Dados"),
    EXCLUIR_CONTA("Excluir Conta"),
    // Itens
    PESQUISAR_ITEM("Pesquisar Item"),
    ULTIMAS_AQUISICOES("Ultimas Aquisicoes"),
    // Emprestimos
    MEUS_EMPRESTIMOS("Meus Emprestimos"),
    EMPRESTIMOS_ATRASADOS("Emprestimos Atrasados"),
    GERAR_EMPRESTIMO("Gerar Emprestimo"),
    DEVOLVER_EMPRESTIMO("Devolver Emprestimo"),
    RENOVAR_EMPRESTIMO("Renovar Emprestimo"),
    // Reservas
    MINHAS_RESERVAS("Minhas Reservas"),
    RESERVAR_ITEM("Reservar Item"),
    CANCELAR_RESERVA("Cancelar Reserva"),
    // Comum
	VOLTAR("Voltar");
	
    // Atributo
	private final String name;
	
    // Construtor
	SubmenuCliente(String name){
		this.name = name;
	}
	
    // Getter
	public String getName() {
		return name;
	}
}
