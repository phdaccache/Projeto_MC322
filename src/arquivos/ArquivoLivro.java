package arquivos;

import sistema.Livro;

import java.io.*;
import java.util.ArrayList;

public class ArquivoLivro implements Arquivo<Livro>{
    @Override
    public String GravarDados(ArrayList<Livro> lista) {
        return null;
    }

    @Override
    public String LerDados(ArrayList<Livro> lista) throws IOException {

        File file = new File("src/arquivos/Bibliotecas_arquivos/Itens.csv");
        File file1 = new File("src/arquivos/Bibliotecas_arquivos/Livros.csv");
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

                if (campos[6].equals("Livro")) {
                    BufferedReader br1 = new BufferedReader(new FileReader(file1));
                    String linha1 = br1.readLine();

                    while (linha1 != null) {
                        if (linha1.equals("CODE_ITEM,EDITORA,ISBN,EDICAO,TEMA")) {
                            linha1 = br1.readLine();
                            continue;
                        }

                        String[] campos1 = linha1.split(demilitador);
                        linhas.add(campos1);

                        if (campos[0].equals(campos1[0])) {
                            lista.add(new Livro(Integer.parseInt(campos[1]), campos[3], campos[4], Integer.parseInt(campos[5]), campos1[1], Integer.parseInt(campos1[2]), campos1[3], campos1[4], campos[2]));
                        }

                        linha1 = br1.readLine();
                    }

                    br1.close();
                }

                linha = br.readLine();
            }

            br.close();
            return "Alunos carregados com sucesso!";
        }
        return "Arquivo não encontrado!";
    }
}
