package arquivos;
import sistema.Admin;
import sistema.Estudante;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ArquivoEstudante implements Arquivo<Estudante>{

    @Override
    public String GravarDados(ArrayList<Estudante> lista) {
        return null;
    }

    @Override
    public String LerDados(ArrayList<Estudante> lista) throws IOException, ParseException {

        File file = new File("src/arquivos/ArquivosCSV/Clientes.csv"); //Mudar para ser acessada por qualquer usuário
        File file1 = new File("src/arquivos/ArquivosCSV/Estudantes.csv"); //Mudar para ser acessada por qualquer usuário
        String demilitador = ",";
        ArrayList<String[]> linhas = new ArrayList<>();
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linha = br.readLine();

            while (linha != null) {
                if (linha.equals("BIBLIOTECA_CNPJ,CPF,MULTA,NOME,TELEFONE,EMAIL,DATANASC,SENHA,ASSINATURA,STATUS,CLASSE")) {
                    linha = br.readLine();
                    continue;
                }

                String[] campos = linha.split(demilitador);
                linhas.add(campos);

                if (campos[10].equals("Estudante")) {
                    BufferedReader br1 = new BufferedReader(new FileReader(file1));
                    String linha1 = br1.readLine();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    while (linha1 != null) {
                        if (linha1.equals("CPF_CLIENTE,MATRICULA,CURSO,ANO_GRAD")) {
                            linha1 = br1.readLine();
                            continue;
                        }

                        String[] campos1 = linha1.split(demilitador);
                        linhas.add(campos1);

                        if (campos[1].equals(campos1[0])) {
                            lista.add(new Estudante(Admin.getBiblioteca(campos[0]), campos[1], campos[3], campos[4], campos[5], LocalDate.parse(campos[6], dtf), campos[7], campos[8], campos1[1], campos1[2], Integer.parseInt(campos1[3])));
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