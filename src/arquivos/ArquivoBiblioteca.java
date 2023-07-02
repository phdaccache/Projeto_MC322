package arquivos;

import sistema.*;

import java.io.*;
import java.util.ArrayList;

public class ArquivoBiblioteca implements Arquivo<Biblioteca> {

    @Override
    public String GravarDados(ArrayList<Biblioteca> lista) throws IOException {
        File file = new File("src/arquivos/ArquivosCSV/Bibliotecas.csv");
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fileWriter);
        pw.println("NOME,CNPJ,ENDERECO,TELEFONE,SENHA\n");
        for (Biblioteca biblioteca : lista) {
            pw.println(biblioteca.getNome() + "," + biblioteca.getCNPJ() + "," + biblioteca.getEndereco() + "," + biblioteca.getTelefone() + "," + biblioteca.getSenha());
        }
        fileWriter.close();
        return "Bibliotecas salvas com sucesso!";
    }

    @Override
    public String LerDados(ArrayList<Biblioteca> lista) throws IOException {
        try {
            File file = new File("src/arquivos/ArquivosCSV/Bibliotecas.csv"); //Mudar para ser acessada por qualquer usuário
            String demilitador = ",";
            ArrayList<String[]> linhas = new ArrayList<>();

            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String linha = br.readLine();
                while (linha != null) {
                    if(linha.equals("NOME,CNPJ,ENDERECO,TELEFONE,SENHA")){
                        linha = br.readLine();
                        continue;
                    }

                    String[] campos = linha.split(demilitador);
                    linhas.add(campos);
                    lista.add(new Biblioteca(campos[0], campos[1], campos[2], campos[3], campos[4]));
                    linha = br.readLine();
                }
                br.close();
                return "Bibliotecas carregadas com sucesso!";
            } else {
                return "Arquivo não encontrado!";
            }
        } catch (FileNotFoundException e) {
            // Tratamento adequado para a exceção FileNotFoundException
            return "Erro: Arquivo não encontrado! Detalhes: " + e.getMessage();
        } catch (IOException e) {
            // Tratamento para outras exceções de IO
            return "Erro de IO: " + e.getMessage();
        }
    }
}