package run;

import arquivos.Gravar;

public class ThreadGravarArquivos extends Thread {
    public void run() {
        Gravar.gravarDados();
    }
}