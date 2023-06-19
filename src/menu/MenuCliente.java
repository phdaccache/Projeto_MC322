package menu;

public enum MenuCliente {
    MINHA_CONTA("Minha Conta", new SubmenuCliente[] {
        SubmenuCliente.VISUALIZAR_DADOS,
        SubmenuCliente.EDITAR_DADOS,
        SubmenuCliente.EXCLUIR_CONTA,
        SubmenuCliente.VOLTAR
    }),
    ITENS("Itens", new SubmenuCliente[] {
        SubmenuCliente.PESQUISAR_ITEM,
        SubmenuCliente.ULTIMAS_AQUISICOES,
        SubmenuCliente.VOLTAR
    }),
    EMPRESTIMOS("Emprestimos", new SubmenuCliente[] {
        SubmenuCliente.MEUS_EMPRESTIMOS,
        SubmenuCliente.EMPRESTIMOS_ATRASADOS,
        SubmenuCliente.GERAR_EMPRESTIMO,
        SubmenuCliente.DEVOLVER_EMPRESTIMO,
        SubmenuCliente.RENOVAR_EMPRESTIMO,
        SubmenuCliente.VOLTAR
    }),
    RESERVAS("Reservas", new SubmenuCliente[] {
        SubmenuCliente.MINHAS_RESERVAS,
        SubmenuCliente.RESERVAR_ITEM,
        SubmenuCliente.CANCELAR_RESERVA,
        SubmenuCliente.VOLTAR
    }),
    VOLTAR("Voltar");

    // Atributos
    private final String name;
    private final SubmenuCliente[] subOptions;

    // Construtor
    MenuCliente(String name, SubmenuCliente ... subOptions) {
        this.name = name;
        this.subOptions = subOptions;
    }

    // Getters
    public String getName() {
        return name;
    }

    public SubmenuCliente[] getSubOptions() {
        return subOptions;
    }
}
