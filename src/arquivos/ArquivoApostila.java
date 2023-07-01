package arquivos;

import sistema.Apostila;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoApostila implements Arquivo<Apostila>{
    @Override
    public String GravarDados(ArrayList<Apostila> lista) {
        return null;
    }

    @Override
    public String LerDados(ArrayList<Apostila> lista) throws IOException {
        File file = new File("src/arquivos/Bibliotecas_arquivos/Itens.csv");
        File file1 = new File("src/arquivos/Bibliotecas_arquivos/Apostilas.csv");
        String demilitador = ",";
        ArrayList<String[]> linhas = new ArrayList<>();
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linha = br.readLine();

            while (linha != null) {
                if (linha.equals("CODE,QTD_DE_PAGINAS,STATUS,TITULO,AUTOR,ANO,CLASSE")) {
                    linha = br.readLine();
                    continue;
                }

                String[] campos = linha.split(demilitador);
                linhas.add(campos);

                if (campos[6].equals("Apostila")) {
                    BufferedReader br1 = new BufferedReader(new FileReader(file1));
                    String linha1 = br1.readLine();

                    while (linha1 != null) {
                        if (linha1.equals("CODE_ITEM,DISCIPLINA,INSTITUICAO\n")) {
                            linha1 = br1.readLine();
                            continue;
                        }

                        String[] campos1 = linha1.split(demilitador);
                        linhas.add(campos1);

                        if (campos[0].equals(campos1[0])) {
                            lista.add(new Apostila(Integer.parseInt(campos[1]), campos[3], campos[4], Integer.parseInt(campos[5]), campos1[1], campos1[2]));
                        }

                        linha1 = br1.readLine();
                    }

                    br1.close();
                }

                linha = br.readLine();
            }

            br.close();
            return "Apostilas carregados com sucesso!";
        }
        return "Arquivo não encontrado!";
    }
}
