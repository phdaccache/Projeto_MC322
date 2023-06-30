package run;
import arquivos.ArquivoBiblioteca;

public class ThreadGravarArquivos extends Thread {

    public void run() {
        ArquivoBiblioteca arquivoBiblioteca = new ArquivoBiblioteca();
        System.out.println(arquivoBiblioteca.LerDados(null));
    }
}