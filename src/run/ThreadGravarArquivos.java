package run;
import sistema.Admin;

public class ThreadGravarArquivos extends Thread {
    public void run() {
        System.out.println(Admin.listarBibliotecas());
    }
}