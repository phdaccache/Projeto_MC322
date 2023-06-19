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

    /******************************* MENU PADRAO *******************************/

    // Imprime Menu Padrao no terminal
    public void showMenuPadrao() {
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

    // Le a opcao escolhida no menu padrao com o scanner e a retorna
    public MenuPadrao readOptionMenuPadrao() {
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

    // Executa a opcao do menu padrao passada
    public void runMenuPadraoOption(MenuPadrao option) {
        Biblioteca biblioteca;
        Cliente cliente;

        switch (option) {
            case ADMIN:
                runSubmenuPadrao(option, null, null);
                break;
            case BIBLIOTECA:
                System.out.println("Login da Biblioteca:");
                biblioteca = loginbiblioteca();
                if (biblioteca == null) {return;}
                System.out.println("Login realizado com sucesso!");
                System.out.printf("Bem vindo(a) %s!\n", "Nome Biblioteca");
                runSubmenuPadrao(option, biblioteca, null);
                break;
            case CLIENTE:
                System.out.println("Login do Cliente:");
                cliente = loginCliente();
                if (cliente == null) {return;}
                System.out.println("Login realizado com sucesso!");
                System.out.printf("Bem vindo(a) %s!\n", "Nome Cliente");
                runSubmenuPadrao(option, null, cliente);
                break;
            case SAIR:
                System.out.println("Programa encerrado.");
        }
    }


    /******************************* SUBMENU PADRAO *******************************/

    // Executa submenu padrao (imprime, recebe a opcao e executa a opcao) de acordo com a opcao passada
    private void runSubmenuPadrao(MenuPadrao option, Biblioteca biblioteca, Cliente cliente) {
        SubmenuPadrao subOption;
        do {
            showSubmenuPadrao(option);
            subOption = readOptionSubmenuPadrao(option);
            if (biblioteca != null) {
                runSubmenuPadraoOption(subOption, biblioteca, null);
            } else if (cliente != null) {
                runSubmenuPadraoOption(subOption, null, cliente);
            } else {
                runSubmenuPadraoOption(subOption, null, null);
            }
        } while (subOption != SubmenuPadrao.VOLTAR);
    }

    // Imprime o submenu padrao de "option" no terminal.
    private void showSubmenuPadrao(MenuPadrao option) {
        SubmenuPadrao submenu[] = option.getSubOptions();
        String title = getTituloFormatado(option.getName());

        System.out.println(title);
        System.out.println("|-------------------------------------------|");
        for (int i = 0; i < submenu.length; i++) {
            // Se a opcao for a ultima (i.e. "SAIR"), recebe 0
            int numSuboption = i == submenu.length - 1 ? 0 : i + 1;
            if (numSuboption < 10) {
                System.out.printf("| Opcao %d - %-31s |\n", numSuboption, submenu[i].getName());
            } else {
                System.out.printf("| Opcao %d - %-30s |\n", numSuboption, submenu[i].getName());
            }
        }
        System.out.println("|-------------------------------------------|");
    }
    
    // Le a opcao escolhida no submenu padrao com o scanner e a retorna
    private SubmenuPadrao readOptionSubmenuPadrao(MenuPadrao option) {
        int subOption;
        SubmenuPadrao submenu[] = option.getSubOptions();

        System.out.print("Digite uma opcao: ");
        subOption = scanner.nextInt();
        scanner.nextLine();
        if (subOption < 0 || subOption > submenu.length - 1) {
            System.out.println("Opcao Invalida.");
            return null;
        } else if (subOption == 0) {
            return submenu[submenu.length - 1]; // opcao 0 = "VOLTAR", i.e. ultima opcao do submenu
        } else {
            return submenu[subOption - 1];
        }
    }

    // Executa a opcao do submenu padrao passada
    private void runSubmenuPadraoOption(SubmenuPadrao subOption, Biblioteca biblioteca, Cliente cliente) {
        switch (subOption) {
            // Admin
            case LISTAR_BIBLIOTECAS:
                System.out.println("Listar Bibliotecas.");
                break;
            case CADASTRAR_BIBLIOTECA:
                System.out.println("Cadastrar Biblioteca.");
                break;
            case EXCLUIR_BIBLIOTECA:
                System.out.println("Excluir Biblioteca.");
                break;
            case AVANCAR_TEMPO:
                System.out.println("Avancar Tempo.");
                break;

            // Biblioteca
            case MINHA_CONTA_BIBLIOTECA:
            case CLIENTES:
            case ITENS_BIBLIOTECA:
            case EMPRESTIMOS_BIBLIOTECA:
            case RESERVAS_BIBLIOTECA:
                runSubmenuBiblioteca(subOption, biblioteca);
                break;

            // Cliente
            case MINHA_CONTA_CLIENTE:
            case ITENS_CLIENTE:
            case EMPRESTIMOS_CLIENTE:
            case RESERVAS_CLIENTE:
                runSubmenuCliente(subOption, cliente);
                break;

            // Comum
            case VOLTAR:
                break;
        }
    }


    /******************************* MENU BIBLIOTECA *******************************/

    // Executa submenu da biblioteca (imprime, recebe a opcao e executa a opcao) de acordo com a opcao passada
    private void runSubmenuBiblioteca(SubmenuPadrao option, Biblioteca biblioteca) {
        SubmenuBiblioteca subOption;
        do {
            showSubmenuBiblioteca(option);
            subOption = readOptionSubmenuBiblioteca(option);
            runSubmenuBibliotecaOption(subOption, biblioteca);

        } while (subOption != SubmenuBiblioteca.VOLTAR);
    }

    // Imprime o menu da biblioteca no terminal
    private void showSubmenuBiblioteca(SubmenuPadrao option) {
        return;
    }

    // Le a opcao escolhida no menu biblioteca com o scanner e a retorna
    private SubmenuBiblioteca readOptionSubmenuBiblioteca(SubmenuPadrao option) {
        return null;
    }

    // Executa a opcao do menu biblioteca passada
    private void runSubmenuBibliotecaOption(SubmenuBiblioteca subOption, Biblioteca biblioteca) {
        return;
    }


    /******************************* MENU CLIENTE *******************************/

    // Executa submenu do cliente (imprime, recebe a opcao e executa a opcao) de acordo com a opcao passada
    private void runSubmenuCliente(SubmenuPadrao option, Cliente cliente) {
        return;
    }


    /******************************* METODOS AUXILIARES *******************************/

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