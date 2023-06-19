package menu;

/* enum para o Menu
 * Cada constante e uma opcao do menu, que tem um nome e uma lista de submenus
 */
public enum MenuPadrao {
    ADMIN("Admin", new SubmenuPadrao[] {
        SubmenuPadrao.LISTAR_BIBLIOTECAS,
        SubmenuPadrao.CADASTRAR_BIBLIOTECA,
        SubmenuPadrao.EXCLUIR_BIBLIOTECA,
        SubmenuPadrao.AVANCAR_TEMPO,
        SubmenuPadrao.VOLTAR
    }),
    BIBLIOTECA("Area Biblioteca", new SubmenuPadrao[] {
        SubmenuPadrao.MINHA_CONTA_BIBLIOTECA,
        SubmenuPadrao.CLIENTES,
        SubmenuPadrao.ITENS_BIBLIOTECA,
        SubmenuPadrao.EMPRESTIMOS_BIBLIOTECA,
        SubmenuPadrao.RESERVAS_BIBLIOTECA,
        SubmenuPadrao.VOLTAR
    }),
    CLIENTE("Area Cliente", new SubmenuPadrao[] {
        SubmenuPadrao.MINHA_CONTA_CLIENTE,
        SubmenuPadrao.ITENS_CLIENTE,
        SubmenuPadrao.EMPRESTIMOS_CLIENTE,
        SubmenuPadrao.RESERVAS_CLIENTE,
        SubmenuPadrao.VOLTAR
    }),
    SAIR("Sair");

    // Atributos
    private final String name;
    private final SubmenuPadrao[] subOptions;

    // Construtor
    MenuPadrao(String name, SubmenuPadrao ... subOptions) {
        this.name = name;
        this.subOptions = subOptions;
    }

    // Getters
    public String getName() {
        return name;
    }

    public SubmenuPadrao[] getSubOptions() {
        return subOptions;
    }
}