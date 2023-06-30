package run;
import arquivos.ArquivoBiblioteca;

import java.io.IOException;

public class ThreadGravarArquivos extends Thread {

    public void run() {
        ArquivoBiblioteca arquivoBiblioteca = new ArquivoBiblioteca();
        try {
            System.out.println(arquivoBiblioteca.LerDados(null));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}