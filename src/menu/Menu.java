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
            return null;
        } else if (option == 0) { 
            return MenuPadrao.values()[menu.length - 1]; // opcao 0 = "SAIR", i.e. ultima opcao do menu
        } else {
            return MenuPadrao.values()[option - 1];
        }
    }

    // Executa a opcao do menu padrao passada
    public void runMenuPadraoOption(MenuPadrao option) {
        // Caso em que a opcao escolhida e invalida
        if (option == null) {
            System.out.println("Opcao Invalida.");
            return;
        }

        Biblioteca biblioteca;
        Cliente cliente;

        switch (option) {
            case ADMIN:
                runMenuAdmin();
                break;
            case BIBLIOTECA:
                System.out.println("Login da Biblioteca:");
                biblioteca = loginbiblioteca();
                if (biblioteca != null) {return;}
                System.out.println("Login realizado com sucesso!");
                System.out.printf("Bem vindo(a) %s!\n", "Nome Biblioteca");
                runMenuBiblioteca(biblioteca);
                break;
            case CLIENTE:
                System.out.println("Login do Cliente:");
                cliente = loginCliente();
                if (cliente != null) {return;}
                System.out.println("Login realizado com sucesso!");
                System.out.printf("Bem vindo(a) %s!\n", "Nome Cliente");
                runMenuCliente(cliente);
                break;
            case SAIR:
                System.out.println("Programa encerrado.");
                break;
        }
    }


    /******************************* MENU ADMIN *******************************/

    // Executa menu do admin (imprime, recebe a opcao e executa a opcao) de acordo com a opcao passada
    private void runMenuAdmin() {
        return;
    }


    /******************************* MENU BIBLIOTECA *******************************/

    // Executa menu da biblioteca (imprime, recebe a opcao e executa a opcao) de acordo com a opcao passada
    private void runMenuBiblioteca(Biblioteca biblioteca) {
        MenuBiblioteca option;
        do {
            showMenuBiblioteca();
            option = readOptionMenuBiblioteca();
            runMenuBibliotecaOption(option, biblioteca);

        } while (option != MenuBiblioteca.VOLTAR);
    }

    // Imprime o menu da biblioteca no terminal
    private void showMenuBiblioteca() {
        MenuBiblioteca menuBiblioteca[] = MenuBiblioteca.values();
        String title = getTituloFormatado("Biblioteca");

        System.out.println(title);
        System.out.println("|-------------------------------------------|");
        for (MenuBiblioteca option : menuBiblioteca) {
            // Se a opcao for a ultima (i.e. "SAIR"), recebe 0
            int numOption = option.ordinal() == menuBiblioteca.length - 1 ? 0 : option.ordinal() + 1;
        if (numOption < 10) {
            System.out.printf("| Opcao %d - %-31s |\n", numOption, option.getName());
        } else {
            System.out.printf("| Opcao %d - %-30s |\n", numOption, option.getName());
        }
        }
        System.out.println("|-------------------------------------------|");
    }

    // Le a opcao escolhida no menu biblioteca com o scanner e a retorna
    private MenuBiblioteca readOptionMenuBiblioteca() {
        int option;
        MenuBiblioteca menuBiblioteca[] = MenuBiblioteca.values();

        System.out.print("Digite uma opcao: ");
        option = scanner.nextInt();
        scanner.nextLine();
        if (option < 0 || option > menuBiblioteca.length - 1) {
            return null;
        } else if (option == 0) { 
            return MenuBiblioteca.values()[menuBiblioteca.length - 1]; // opcao 0 = "SAIR", i.e. ultima opcao do menu
        } else {
            return MenuBiblioteca.values()[option - 1];
        }
    }

    // Executa a opcao do menu biblioteca passada
    private void runMenuBibliotecaOption(MenuBiblioteca option, Biblioteca biblioteca) {
        // Caso em que a opcao escolhida e invalida
        if (option == null) {
            System.out.println("Opcao Invalida.");
            return;
        }

        switch (option) {
            case MINHA_CONTA:
            case CLIENTES:
            case ITENS:
            case EMPRESTIMOS:
            case RESERVAS:
                runSubmenuBiblioteca(option, biblioteca);
                break;
            case VOLTAR:
                break;
        }
    }

    // Executa submenu da biblioteca (imprime, recebe a opcao e executa a opcao) de acordo com a opcao passada
    private void runSubmenuBiblioteca(MenuBiblioteca option, Biblioteca biblioteca) {
        SubmenuBiblioteca subOption;
        do {
            showSubmenuBiblioteca(option);
            subOption = readOptionSubmenuBiblioteca(option);
            runSubmenuBibliotecaOption(subOption, biblioteca);
        } while (subOption != SubmenuBiblioteca.VOLTAR);
    }

    // Imprime o SubmenuBiblioteca de "suboption" no terminal.
    private void showSubmenuBiblioteca(MenuBiblioteca option) {
        SubmenuBiblioteca submenuBiblioteca[] = option.getSubOptions();
        String title = getTituloFormatado(option.getName());

        System.out.println(title);
        System.out.println("|-------------------------------------------|");
        for (int i = 0; i < submenuBiblioteca.length; i++) {
            int numSuboption;
            if (i == submenuBiblioteca.length - 1) { // Se a opcao for a ultima (i.e. "VOLTAR"), recebe 0
                numSuboption = 0;
            } else {
                numSuboption = i + 1;
            }
            if (numSuboption < 10) {
                System.out.printf("| Opcao %d - %-31s |\n", numSuboption, submenuBiblioteca[i].getName());
            } else {
                System.out.printf("| Opcao %d - %-30s |\n", numSuboption, submenuBiblioteca[i].getName());
            }
        }
        System.out.println("|-------------------------------------------|");
    }

    // Le a opcao escolhida no submenu da biblioteca com o scanner e a retorna
    private SubmenuBiblioteca readOptionSubmenuBiblioteca(MenuBiblioteca option) {
        int subOption;
        SubmenuBiblioteca submenu[] = option.getSubOptions();

        System.out.print("Digite uma opcao: ");
        subOption = scanner.nextInt();
        scanner.nextLine();
        if (subOption < 0 || subOption > submenu.length - 1) {
            return null;
        } else if (subOption == 0) {
            return submenu[submenu.length - 1]; // opcao 0 = "VOLTAR", i.e. ultima opcao do submenu
        } else {
            return submenu[subOption - 1];
        }
    }

    // Executa a opcao do submenu da biblioteca passada
    private void runSubmenuBibliotecaOption(SubmenuBiblioteca subOption, Biblioteca biblioteca) {
        // Caso em que a subopcao escolhida e invalida
        if (subOption == null) {
            System.out.println("Opcao Invalida.");
            return;
        }

        switch(subOption) {
            // Minha Conta
            case VISUALIZAR_DADOS:
                System.out.println("Visualizar Dados.");
                break;
            case EDITAR_DADOS:
                System.out.println("Editar Dados.");
                break;
            case EXCLUIR_CONTA:
                System.out.println("Excluir Conta.");
                break;

            // Clientes
            case LISTAR_CLIENTES:
                System.out.println("Listar Clientes.");
                break;
            case LISTAR_ESTUDANTES:
                System.out.println("Listar Estudantes.");
                break;
            case LISTAR_PROFESSORES:
                System.out.println("Listar Professores.");
                break;
            case CADASTRAR_CLIENTE:
                System.out.println("Cadastrar Cliente.");
                break;
            case EXCLUIR_CLIENTE:
                System.out.println("Excluir Cliente.");
                break;
            case LISTAR_ASSINATURAS:
                System.out.println("Listar Assinaturas.");
                break;
            case GERAR_ASSINATURA:
                System.out.println("Gerar Assinatura.");
                break;
            case CANCELAR_ASSINATURA:
                System.out.println("Cancelar Assinatura.");
                break;

            // Itens
            case PESQUISAR_ITEM:
                System.out.println("Pesquisar Item.");
                break;
            case LISTAR_ITENS:
                System.out.println("Listar Itens.");
                break;
            case LISTAR_LIVROS:
                System.out.println("Listar Livros.");
                break;
            case LISTAR_APOSTILAS:
                System.out.println("Listar Apostilas.");
                break;
            case LISTAR_ARTIGOS:
                System.out.println("Listar Artigos.");
                break;
            case LISTAR_REVISTAS:
                System.out.println("Listar Revistas.");
                break;
            case CADASTRAR_ITEM:
                System.out.println("Cadastrar Item.");
                break;
            case EXCLUIR_ITEM:
                System.out.println("Excluir Item.");
                break;

            // Emprestimos
            case LISTAR_EMPRESTIMOS:
                System.out.println("Listar Emprestimos.");
                break;
            case LISTAR_EMPRESTIMOS_ATIVOS:
                System.out.println("Listar Emprestimos Ativos.");
                break;
            case LISTAR_EMPRESTIMOS_ATRASADOS:
                System.out.println("Listar Emprestimos Atrasados.");
                break;
            case LISTAR_EMPRESTIMOS_CLIENTE:
                System.out.println("Listar Emprestimos de um Cliente.");
                break;

            // Reservas
            case LISTAR_RESERVAS:
                System.out.println("Listar Reservas.");
                break;
            case LISTAR_RESERVAS_ATIVAS:
                System.out.println("Listar Reservas Ativas.");
                break;
            case LISTAR_RESERVAS_CLIENTE:
                System.out.println("Listar Reservas de um Cliente.");
                break;

            // Comum
            case VOLTAR:
            	break;
        }
    }


    /******************************* MENU CLIENTE *******************************/

    // Executa menu do cliente (imprime, recebe a opcao e executa a opcao) de acordo com a opcao passada
    private void runMenuCliente(Cliente cliente) {
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