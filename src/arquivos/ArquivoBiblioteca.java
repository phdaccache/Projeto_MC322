package arquivos;

import sistema.Biblioteca;

import java.io.File;
import java.util.ArrayList;

public class ArquivoBiblioteca implements I_arquivos<Biblioteca> {

    @Override
    public String GravarDados(ArrayList<Biblioteca> lista) {
        return null;
    }

    @Override
    public String LerDados(ArrayList<Biblioteca> lista) {
        File file = new File("src/arquivos/Bibliotecas_arquivos/Bibliotecas.csv"); //Mudar para ser acessada por qualquer usuário
        if(file.exists()){
            return "Bibliotecas carregadas com sucesso!";
        }
        return "Arquivo não encontrado!";
    }
}
