package arquivos;

import sistema.Artigo;
import sistema.Revista;

import java.io.*;
import java.util.ArrayList;

public class ArquivoArtigo implements Arquivo<Artigo>{
    @Override
    public String GravarDados(ArrayList<Artigo> lista) throws IOException {
        File file = new File("src/arquivos/ArquivosCSV/Revistas.csv");
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fileWriter);
        pw.println("CODE_ITEM,DOI,ABSTRACT,KEYWORDS");
        for (Artigo artigo : lista) {
            pw.println(artigo.getCode() + "," + artigo.getDOI() + "," + artigo.getAbstractArtigo() + "," + artigo.getKeywords());
        }
        fileWriter.close();
        return "Artigos salvos com sucesso!";
    }

    @Override
    public String LerDados(ArrayList<Artigo> lista) throws IOException {

        File file = new File("src/arquivos/ArquivosCSV/Itens.csv");
        File file1 = new File("src/arquivos/ArquivosCSV/Artigos.csv");
        String demilitador = ",";
        ArrayList<String[]> linhas = new ArrayList<>();
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linha = br.readLine();

            while (linha != null) {
                if (linha.equals("CODE,QUANTIDADE,STATUS,TITULO,AUTOR,ANO,CLASSE")) {
                    linha = br.readLine();
                    continue;
                }

                String[] campos = linha.split(demilitador);
                linhas.add(campos);

                if (campos[6].equals("Artigo")) {
                    BufferedReader br1 = new BufferedReader(new FileReader(file1));
                    String linha1 = br1.readLine();

                    while (linha1 != null) {
                        if (linha1.equals("CODE_ITEM,DOI,ABSTRACT,KEYWORDS")) {
                            linha1 = br1.readLine();
                            continue;
                        }

                        String[] campos1 = linha1.split(demilitador);
                        linhas.add(campos1);

                        if (campos[0].equals(campos1[0])) {
                            Artigo artigo = new Artigo(Integer.parseInt(campos[1]), campos[3], campos[4], Integer.parseInt(campos[5]), Integer.parseInt(campos1[1]), campos1[2], campos1[3], campos[2]);
                            artigo.setStatus(campos[2]);
                            lista.add(artigo);
                        }

                        linha1 = br1.readLine();
                    }

                    br1.close();
                }

                linha = br.readLine();
            }

            br.close();
            return "Artigos carregados com sucesso!";
        }
        return "Arquivo não encontrado!";
    }
}
