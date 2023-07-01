package arquivos;

import sistema.Artigo;
import sistema.Revista;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoRevista implements Arquivo<Revista>{
    @Override
    public String GravarDados(ArrayList<Revista> lista) {
        return null;
    }

    @Override
    public String LerDados(ArrayList<Revista> lista) throws IOException {

        File file = new File("src/arquivos/Bibliotecas_arquivos/Itens.csv");
        File file1 = new File("src/arquivos/Bibliotecas_arquivos/Revistas.csv");
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

                if (campos[6].equals("Revista")) {
                    BufferedReader br1 = new BufferedReader(new FileReader(file1));
                    String linha1 = br1.readLine();

                    while (linha1 != null) {
                        if (linha1.equals("CODE_ITEM,EDICAO,INSTITUICAO,ASSUNTO,ISSN")) {
                            linha1 = br1.readLine();
                            continue;
                        }

                        String[] campos1 = linha1.split(demilitador);
                        linhas.add(campos1);

                        if (campos[0].equals(campos1[0])) {
                            lista.add(new Revista(Integer.parseInt(campos[1]), campos[3], campos[4], Integer.parseInt(campos[5]), campos1[1], campos1[2], campos1[3], Integer.parseInt(campos1[4])));
                        }

                        linha1 = br1.readLine();
                    }

                    br1.close();
                }

                linha = br.readLine();
            }

            br.close();
            return "Revistas carregados com sucesso!";
        }
        return "Arquivo não encontrado!";
    }
}
