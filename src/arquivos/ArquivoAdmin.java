package arquivos;

import sistema.Admin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ArquivoAdmin implements Arquivo<Admin>{
    @Override
    public String GravarDados(ArrayList<Admin> lista) {
        return null;
    }

    @Override
    public String LerDados(ArrayList<Admin> lista) throws IOException {
        try {
            File file = new File("src/arquivos/ArquivosCSV/Admin.csv"); //Mudar para ser acessada por qualquer usuário
            String demilitador = ",";
            ArrayList<String[]> linhas = new ArrayList<>();

            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String linha = br.readLine();
                while (linha != null) {
                    if(linha.equals("LOCAL_DATE")){
                        linha = br.readLine();
                        continue;
                    }

                    String[] campos = linha.split(demilitador);
                    linhas.add(campos);
                    Admin.data = LocalDate.parse(campos[0]);
                    linha = br.readLine();
                }
                br.close();
                return "Admin carregado com sucesso!";
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