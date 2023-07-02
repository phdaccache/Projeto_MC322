package run;
import arquivos.*;

import java.io.IOException;

public class ThreadGravarArquivos extends Thread {
    public void run() {
        try {
            Gravar.gravarDados();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}