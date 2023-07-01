package arquivos;

import sistema.Admin;
import sistema.Professor;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ArquivoProfessor implements Arquivo<Professor>{
    @Override
    public String GravarDados(ArrayList<Professor> lista) {
        return null;
    }

    @Override
    public String LerDados(ArrayList<Professor> lista) throws IOException {
        File file = new File("src/arquivos/ArquivosCSV/Clientes.csv"); //Mudar para ser acessada por qualquer usuário
        File file1 = new File("src/arquivos/ArquivosCSV/Professores.csv"); //Mudar para ser acessada por qualquer usuário
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

                if (campos[10].equals("Professor")) {
                    BufferedReader br1 = new BufferedReader(new FileReader(file1));
                    String linha1 = br1.readLine();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    while (linha1 != null) {
                        if (linha1.equals("CPF_CLIENTE,INSTITUICAO,EDUCACAO,AREA,AULAS,ANO_ING")) {
                            linha1 = br1.readLine();
                            continue;
                        }

                        String[] campos1 = linha1.split(demilitador);
                        linhas.add(campos1);

                        if (campos[1].equals(campos1[0])) {
                            lista.add(new Professor(Admin.getBiblioteca(campos[0]), campos[1], campos[3], campos[4], campos[5], LocalDate.parse(campos[6], dtf), campos[7], campos[8], campos1[1], campos1[2], campos1[3], campos1[4], Integer.parseInt(campos1[5])));
                        }

                        linha1 = br1.readLine();
                    }

                    br1.close();
                }

                linha = br.readLine();
            }

            br.close();
            return "Professores carregados com sucesso!";
        }
        return "Arquivo não encontrado!";
    }
}