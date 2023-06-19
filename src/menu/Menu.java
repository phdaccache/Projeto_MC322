package menu;

import java.util.Scanner;

import pacote.Biblioteca;
import pacote.Cliente;

public class Menu {
    private Scanner scanner;

    // Construtor
    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    // Imprime Menu no terminal
    public void showMenu() {
        MenuPadrao menu[] = MenuPadrao.values();
        String title = getTituloFormatado("Menu");

        System.out.println(title);
        System.out.println("|-------------------------------------------|");
        for (MenuPadrao option : menu) {
            // Se a opcao for a ultima (i.e. "SAIR"), recebe 0
            int numOption = option.ordinal() == menu.length - 1 ? 0 : option.ordinal() + 1;
        if (numOption < 10) {
            System.out.printf("| Opcao %d - %-31s |\n", numOption, option.getName());
        } else {
            System.out.printf("| Opcao %d - %-30s |\n", numOption, option.getName());
        }
        }
        System.out.println("|-------------------------------------------|");
    }

    // Le a opcao escolhida no menu com o scanner e a retorna
    public MenuPadrao readOptionMenu() {
        int option;
        MenuPadrao menu[] = MenuPadrao.values();

        System.out.print("Digite uma opcao: ");
        option = scanner.nextInt();
        scanner.nextLine();
        if (option < 0 || option > menu.length - 1) {
            System.out.println("Opcao Invalida.");
            return null;
        } else if (option == 0) { 
            return MenuPadrao.values()[menu.length - 1]; // opcao 0 = "SAIR", i.e. ultima opcao do menu
        } else {
            return MenuPadrao.values()[option - 1];
        }
    }

    // Executa a opcao do menu passada
    public void runMenuOption(MenuPadrao option) {
        Biblioteca biblioteca;
        Cliente cliente;

        switch (option) {
            case ADMIN:
                runSubmenu(option, null, null);
                break;
            case BIBLIOTECA:
                System.out.println("Login da Biblioteca:");
                biblioteca = loginbiblioteca();
                if (biblioteca == null) {return;}
                System.out.println("Login realizado com sucesso!");
                System.out.printf("Bem vindo(a) %s!\n", biblioteca.getNome());
                runSubmenu(option, biblioteca, null);
                break;
            case CLIENTE:
                System.out.println("Login do Cliente:");
                cliente = loginCliente();
                if (cliente == null) {return;}
                System.out.println("Login realizado com sucesso!");
                System.out.printf("Bem vindo(a) %s!\n", cliente.getNome());
                runSubmenu(option, null, cliente);
                break;
            case SAIR:
                System.out.println("Programa encerrado.");
        }
    }

    // Executa submenu (imprime, recebe a opcao e executa a opcao) de acordo com a opcao passada
    private void runSubmenu(MenuPadrao option, biblioteca biblioteca, Cliente cliente) {
        SubmenuBiblioteca subOption;
        do {
            showSubmenu(option);
            subOption = readOptionSubmenu(option);
            if (biblioteca != null) {
                runSubmenuOption(subOption, biblioteca, null);
            } else if (cliente != null) {
                runSubmenuOption(subOption, null, cliente);
            } else {
                runSubmenuOption(subOption, null, null);
            }
        } while (subOption != SubmenuBiblioteca.VOLTAR);
    }

    // Imprime o Submenu de "option" no terminal.
    private void showSubmenu(MenuPadrao option) {
        SubmenuBiblioteca submenu[] = option.getSubOptions();
        String title = getTituloFormatado(option.getName());

        System.out.println(title);
        System.out.println("|-------------------------------------------|");
        for (int i = 0; i < submenu.length; i++) {
            int numSuboption;
            if (i == submenu.length - 1) { // Se a opcao for a ultima (i.e. "VOLTAR"), recebe 0
                numSuboption = 0;
            } else {
                numSuboption = i + 1;
            }
            if (numSuboption < 10) {
                System.out.printf("| Opcao %d - %-31s |\n", numSuboption, submenu[i].getName());
            } else {
                System.out.printf("| Opcao %d - %-30s |\n", numSuboption, submenu[i].getName());
            }
        }
        System.out.println("|-------------------------------------------|");
    }
    
    // Le a opcao escolhida no submenu com o scanner e a retorna
    private SubmenuBiblioteca readOptionSubmenu(MenuPadrao option) {
        int subOption;
        SubmenuBiblioteca submenu[] = option.getSubOptions();

        // Enquanto a opcao nao for valida, fica pedindo a opcao novamente
        while (true) {
            System.out.print("Digite uma opcao: ");
            subOption = scanner.nextInt();
            scanner.nextLine();
            if (subOption < 0 || subOption > submenu.length - 1) {
                System.out.println("Opcao Invalida.");
            } else if (subOption == 0) {
                return submenu[submenu.length - 1]; // opcao 0 = "VOLTAR", i.e. ultima opcao do submenu
            } else {
                return submenu[subOption - 1];
            }
        }
    }

    // Executa a opcao do submenu passada
    private void runSubmenuOption(SubmenuBiblioteca subOption, biblioteca biblioteca, Cliente cliente) {
        switch(subOption) {
            // Admin
            case LISTAR_bibliotecaS:
                Admin.listarbibliotecas();
                break;
            case CADASTRAR_biblioteca:
                Admin.cadastrarbiblioteca(scanner);
                break;
            case EXCLUIR_biblioteca:
                Admin.excluirbiblioteca(scanner);
                break;

            // biblioteca
            case VISUALIZAR_DADOS_biblioteca:
                biblioteca.visualizarDados();
                break;
            case LISTAR_CLIENTES:
                biblioteca.listarClientes();
                break;
            case CADASTRAR_CLIENTE:
                biblioteca.cadastrarCliente(scanner);
                break;
            case EXCLUIR_CLIENTE:
                biblioteca.excluirCliente(scanner);
                break;
            case LISTAR_SEGUROS_biblioteca:
                biblioteca.listarSeguros();
                break;
            case LISTAR_SEGUROS_biblioteca_CLIENTE:
                biblioteca.listarSegurosPorCliente(scanner);
                break;
            case GERAR_SEGURO:
                biblioteca.gerarSeguro(scanner);
                break;
            case CANCELAR_SEGURO:
                biblioteca.cancelarSeguro(scanner);
                break;
            case LISTAR_SINISTROS_biblioteca:
                biblioteca.listarSinistros();
                break;
            case LISTAR_SINISTROS_biblioteca_CLIENTE:
                biblioteca.listarSinistrosPorCliente(scanner);
                break;
            case GERAR_SINISTRO:
                biblioteca.gerarSinistro(scanner);
                break;
            case EXCLUIR_SINISTRO:
                biblioteca.excluirSinistro(scanner);
                break;
            case CALCULAR_RECEITA_biblioteca:
                biblioteca.calcularReceita();
                break;

            // Cliente PF
            case VISUALIZAR_DADOS_CLIENTE_PF:
                cliente.visualizarDados();
                break;
            case LISTAR_SEGUROS_CLIENTE_PF:
                cliente.listarSeguros();
                break;
            case VISUALIZAR_SEGURO_CLIENTE_PF:
                cliente.visualizarSeguro(scanner);
                break;
            case LISTAR_CONDUTORES_PF:
                cliente.listarCondutores();
                break;
            case CADASTRAR_CONDUTOR_PF:
                cliente.cadastrarCondutor(scanner);
                break;
            case EXCLUIR_CONDUTOR_PF:
                cliente.excluirCondutor(scanner);
                break;
            case LISTAR_VEICULOS:
                ((ClientePF)cliente).listarVeiculos();
                break;
            case CADASTRAR_VEICULO:
                ((ClientePF)cliente).cadastrarVeiculo(scanner);
                break;
            case EXCLUIR_VEICULO:
                ((ClientePF)cliente).excluirVeiculo(scanner);
                break;

            // Cliente PJ
            case VISUALIZAR_DADOS_CLIENTE_PJ:
                cliente.visualizarDados();
                break;
            case LISTAR_SEGUROS_CLIENTE_PJ:
                cliente.listarSeguros();
                break;
            case VISUALIZAR_SEGURO_CLIENTE_PJ:
                cliente.visualizarSeguro(scanner);
                break;
            case LISTAR_CONDUTORES_PJ:
                cliente.listarCondutores();
                break;
            case CADASTRAR_CONDUTOR_PJ:
                cliente.cadastrarCondutor(scanner);
                break;
            case EXCLUIR_CONDUTOR_PJ:
                cliente.excluirCondutor(scanner);
                break;
            case LISTAR_FROTAS:
                ((ClientePJ)cliente).listarFrotas();
                break;
            case VISUALIZAR_FROTA:
                ((ClientePJ)cliente).visualizarFrota(scanner);
                break;
            case CADASTRAR_FROTA:
                ((ClientePJ)cliente).cadastrarFrota(scanner);
                break;
            case ATUALIZAR_FROTA:
                ((ClientePJ)cliente).atualizarFrota(scanner);
                break;

            // Comum
            case VOLTAR:
            	break;
        }
    }

    // Retorna o titulo do menu (ou submenu) no formato '#################### Menu ###################'
    private String getTituloFormatado(String titulo) {
        int width = 43; // Tamanho total do titulo
        int padding = width - titulo.length();

        if (padding <= 0) { // padding <= 0 indica que o titulo e maior ou igual ao tamanho total
            return titulo; // Se esse for o caso, nao tem espaco para colocar o #. Logo, retorna o titulo
        } else {
            int right = padding / 2;
            int left = padding - right; // O esquerdo e sempre igual ao direito ou igual ao direito + 1
            String leftPadding = "#".repeat(left);
            String rightPadding = "#".repeat(right);
            return String.format("\n%s %s %s", leftPadding, titulo, rightPadding);
        }
    }

    // Login da Biblioteca
    private Biblioteca loginbiblioteca() {
        return null;
    }

    // Login do Cliente
    private Cliente loginCliente() {
        return null;
    }
}