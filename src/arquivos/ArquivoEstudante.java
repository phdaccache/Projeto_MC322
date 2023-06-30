package arquivos;
import sistema.Biblioteca;
import sistema.Estudante;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class ArquivoEstudante implements Arquivo<Estudante>{

    @Override
    public String GravarDados(ArrayList<Estudante> lista) {
        return null;
    }

    @Override
    public String LerDados(ArrayList<Estudante> lista) throws IOException, ParseException {

        File file = new File("src/arquivos/Bibliotecas_arquivos/Clientes.csv"); //Mudar para ser acessada por qualquer usuário
        File file1 = new File("src/arquivos/Bibliotecas_arquivos/Estudantes.csv"); //Mudar para ser acessada por qualquer usuário
        String demilitador = ",";
        ArrayList<String[]> linhas = new ArrayList<>();
        if(file.exists()){
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linha = br.readLine();
            while (linha != null) {
                String[] campos = linha.split(demilitador);
                linhas.add(campos);
                if(campos[12].equals("Estudante")){
                    //Função para achar biblioteca
                    BufferedReader br1 = new BufferedReader(new FileReader(file1));
                    String linha1 = br1.readLine();
                    while (linha1 != null) {
                        String[] campos1 = linha1.split(demilitador);
                        linhas.add(campos1);
                        if(campos[1].equals(campos1[0])){
                            //lista.add(new Estudante(campos[1], campos[1], campos[3], campos[4], campos[5], LocalDate.parse(campos[6]), campos[7], campos[8], campos1[1], campos1[2], campos1[3]));
                        }
                        linha1 = br1.readLine();
                    }
                }
            }
            return "Bibliotecas carregadas com sucesso!";
        }
        return "Arquivo não encontrado!";
    }
}
