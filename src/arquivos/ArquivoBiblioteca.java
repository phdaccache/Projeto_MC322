package arquivos;

import sistema.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoBiblioteca implements Arquivo<Biblioteca> {

    @Override
    public String GravarDados(ArrayList<Biblioteca> lista) {
        return null;
    }

    @Override
    public String LerDados(ArrayList<Biblioteca> lista) throws IOException {
        File file = new File("src/arquivos/Bibliotecas_arquivos/Bibliotecas.csv"); //Mudar para ser acessada por qualquer usuário
        String demilitador = ",";

        ArrayList<String[]> linhas = new ArrayList<>();
        if(file.exists()){
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linha = br.readLine();
            while (linha != null) {
                String[] campos = linha.split(demilitador);
                linhas.add(campos);
                lista.add(new Biblioteca(campos[0], campos[1], campos[2], campos[3], campos[4]));
            }
            return "Bibliotecas carregadas com sucesso!";
        }
        return "Arquivo não encontrado!";
    }
}
