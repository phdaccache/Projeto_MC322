package arquivos;

import sistema.Apostila;

import java.io.*;
import java.util.ArrayList;

public class ArquivoApostila implements Arquivo<Apostila>{
    @Override
    public String GravarDados(ArrayList<Apostila> lista) throws IOException {
        File file = new File("src/arquivos/ArquivosCSV/Apostilas.csv");
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fileWriter);
        pw.println("CODE_ITEM,DISCIPLINA,INSTITUICAO");
        for (Apostila apostila : lista) {
            pw.println(apostila.getCode() + "," + apostila.getDisciplina() + "," + apostila.getInstituicao());
        }
        fileWriter.close();
        return "Apostilas salvas com sucesso!";
    }

    @Override
    public String LerDados(ArrayList<Apostila> lista) throws IOException {
        File file = new File("src/arquivos/ArquivosCSV/Itens.csv");
        File file1 = new File("src/arquivos/ArquivosCSV/Apostilas.csv");
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
                            lista.add(new Apostila(Integer.parseInt(campos[1]), campos[3], campos[4], Integer.parseInt(campos[5]), campos1[1], campos1[2], campos[2]));
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
