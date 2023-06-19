import java.util.Scanner;

import menu.Menu;
import menu.MenuPadrao;

public class Main {
    public static void main(String[] args) throws Exception {
        /******************************* MENU INTERATIVO *******************************/

        Scanner scanner = new Scanner(System.in);        
        Menu menu = new Menu(scanner);
        MenuPadrao option;

        // Executa menu (imprime, recebe a opcao e executa a opcao) de acordo com a opcao passada
        do {
            menu.showMenuPadrao();
            option = menu.readOptionMenuPadrao();
            menu.runMenuPadraoOption(option);
        } while (option != MenuPadrao.SAIR);
    }
}
