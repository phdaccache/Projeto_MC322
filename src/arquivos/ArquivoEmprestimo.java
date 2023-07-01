package arquivos;

import sistema.Admin;
import sistema.Emprestimo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ArquivoEmprestimo implements Arquivo<Emprestimo>{
    @Override
    public String GravarDados(ArrayList<Emprestimo> lista) {
        return null;
    }

    @Override
    public String LerDados(ArrayList<Emprestimo> lista) throws IOException {

        File file = new File("src/arquivos/Bibliotecas_arquivos/Emprestimos.csv"); //Mudar para ser acessada por qualquer usuário

        String demilitador = ",";
        ArrayList<String[]> linhas = new ArrayList<>();
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linha = br.readLine();

            while (linha != null) {
                if (linha.equals("CNPJ_BIBLIOTECA,CODE_ITEM,STATUS,DATA_INI,DATA_FIM,CPF_CLIENTE,CODE_EMPRESTIMO")) {
                    linha = br.readLine();
                    continue;
                }

                String[] campos = linha.split(demilitador);
                linhas.add(campos);
                lista.add(new Emprestimo(Admin.getBiblioteca(campos[0]), Admin.getBiblioteca(campos[0]).getItem(campos[1]), LocalDate.parse(campos[2]), LocalDate.parse(campos[3]), Admin.getBiblioteca(campos[0]).getCliente(campos[5]), Integer.parseInt(campos[6])));
                linha = br.readLine();
        }
            br.close();
            return "Emprestimos carregados com sucesso!";
        }
        return "Arquivo não encontrado!";
    }
}
