package run;
import arquivos.*;
import sistema.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class ThreadGravarArquivos extends Thread {

    public void run() {
        try {
            Gravar.gravarDados();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}