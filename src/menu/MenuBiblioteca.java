package menu;

public enum MenuBiblioteca {
    MINHA_CONTA("Minha Conta", new SubmenuBiblioteca[] {
        SubmenuBiblioteca.VISUALIZAR_DADOS,
        SubmenuBiblioteca.EDITAR_DADOS,
        SubmenuBiblioteca.EXCLUIR_CONTA
    }),
    CLIENTES("Clientes", new SubmenuBiblioteca[] {
        SubmenuBiblioteca.LISTAR_CLIENTES,
        SubmenuBiblioteca.LISTAR_ESTUDANTES,
        SubmenuBiblioteca.LISTAR_PROFESSORES,
        SubmenuBiblioteca.CADASTRAR_CLIENTE,
        SubmenuBiblioteca.EXCLUIR_CLIENTE,
        SubmenuBiblioteca.LISTAR_ASSINATURAS,
        SubmenuBiblioteca.GERAR_ASSINATURA,
        SubmenuBiblioteca.EXCLUIR_ASSINATURA
    }),
    ITENS("Itens", new SubmenuBiblioteca[] {
        SubmenuBiblioteca.PESQUISAR_ITEM,
        SubmenuBiblioteca.LISTAR_ITENS,
        SubmenuBiblioteca.LISTAR_LIVROS,
        SubmenuBiblioteca.LISTAR_APOSTILAS,
        SubmenuBiblioteca.LISTAR_ARTIGOS,
        SubmenuBiblioteca.LISTAR_REVISTAS,
        SubmenuBiblioteca.CADASTRAR_ITEM,
        SubmenuBiblioteca.EXCLUIR_ITEM
    }),
    EMPRESTIMOS("Emprestimos", new SubmenuBiblioteca[] {
        SubmenuBiblioteca.LISTAR_EMPRESTIMOS,
        SubmenuBiblioteca.LISTAR_EMPRESTIMOS_ATIVOS,
        SubmenuBiblioteca.LISTAR_EMPRESTIMOS_ATRASADOS,
        SubmenuBiblioteca.LISTAR_EMPRESTIMOS_CLIENTE
    }),
    RESERVAS("Reservas", new SubmenuBiblioteca[] {
        SubmenuBiblioteca.LISTAR_RESERVAS,
        SubmenuBiblioteca.LISTAR_RESERVAS_ATIVAS,
        SubmenuBiblioteca.LISTAR_RESERVAS_CLIENTE
    }),
    SAIR("Sair");

    // Atributos
    private final String name;
    private final SubmenuBiblioteca[] subOptions;

    // Construtor
    MenuBiblioteca(String name, SubmenuBiblioteca ... subOptions) {
        this.name = name;
        this.subOptions = subOptions;
    }

    // Getters
    public String getName() {
        return name;
    }

    public SubmenuBiblioteca[] getSubOptions() {
        return subOptions;
    }
}
